package com.meditation.my_sequence.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity {
	
	@Id
	private int id;
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

}
