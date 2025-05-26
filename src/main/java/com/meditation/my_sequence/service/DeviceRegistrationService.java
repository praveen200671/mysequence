package com.meditation.my_sequence.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditation.my_sequence.dto.DeviceEntity;
import com.meditation.my_sequence.model.RegisterDeviceRequest;
import com.meditation.my_sequence.model.RegisterDeviceResponse;
import com.meditation.my_sequence.repositories.DeviceRepository;

@Service
public class DeviceRegistrationService {

    @Autowired
    private DeviceRepository deviceRepository; 

    public RegisterDeviceResponse registerDevice(RegisterDeviceRequest deviceInfo) {
        // Check if device already exists for this user
        DeviceEntity existingDevice = deviceRepository.findByUserIdAndDeviceId(
            deviceInfo.getUserId(), deviceInfo.getDeviceId()
        );

        if (existingDevice != null) {
            // Update existing device
            existingDevice.setDeviceType(deviceInfo.getDeviceType());
            existingDevice.setDeviceModel(deviceInfo.getDeviceModel());
            existingDevice.setOs(deviceInfo.getOs());
            existingDevice.setOsVersion(deviceInfo.getOsVersion());
            existingDevice.setAppVersion(deviceInfo.getAppVersion());
            existingDevice.setManufacturer(deviceInfo.getManufacturer());
            existingDevice.setPushToken(deviceInfo.getPushToken());
            existingDevice.setLatitude(deviceInfo.getLatitude());
            existingDevice.setLongitude(deviceInfo.getLongitude());
            deviceRepository.save(existingDevice);
            
            
            return new RegisterDeviceResponse("200","Device updated successfully.");
        } else {
            // Create a new device
            DeviceEntity newDevice = new DeviceEntity();
            newDevice.setUserId(deviceInfo.getUserId());
            newDevice.setDeviceId(deviceInfo.getDeviceId());
            newDevice.setDeviceType(deviceInfo.getDeviceType());
            newDevice.setDeviceModel(deviceInfo.getDeviceModel());
            newDevice.setOs(deviceInfo.getOs());
            newDevice.setOsVersion(deviceInfo.getOsVersion());
            newDevice.setAppVersion(deviceInfo.getAppVersion());
            newDevice.setManufacturer(deviceInfo.getManufacturer());
            newDevice.setPushToken(deviceInfo.getPushToken());
            newDevice.setLatitude(deviceInfo.getLatitude());
            newDevice.setLongitude(deviceInfo.getLongitude());
            deviceRepository.save(newDevice);
            return new RegisterDeviceResponse("200","Device registered successfully.");
        }
    }
}
