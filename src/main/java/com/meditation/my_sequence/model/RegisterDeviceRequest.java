package com.meditation.my_sequence.model;

public class RegisterDeviceRequest {

    private String deviceId;
    private String deviceType;
    private String deviceModel;
    private String os;
    private String osVersion;
    private String appVersion;
    private String manufacturer;
    private String userId;
    private String pushToken;
    private double latitude;
    private double longitude;

    // Getters and Setters

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

	@Override
	public String toString() {
		return "RegisterDeviceRequest [deviceId=" + deviceId + ", deviceType=" + deviceType + ", deviceModel="
				+ deviceModel + ", os=" + os + ", osVersion=" + osVersion + ", appVersion=" + appVersion
				+ ", manufacturer=" + manufacturer + ", userId=" + userId + ", pushToken=" + pushToken + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
    
    
}
