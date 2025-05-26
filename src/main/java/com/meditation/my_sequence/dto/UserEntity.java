package com.meditation.my_sequence.dto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mobile;

    private String email;

    private String name;

    @Column(name = "photo_url", columnDefinition = "TEXT")
    private String photoUrl;

    private String city;

    private Integer age;

    private String gender;

    private Double lat;

    private Double longitude;

    private String country;

 }
