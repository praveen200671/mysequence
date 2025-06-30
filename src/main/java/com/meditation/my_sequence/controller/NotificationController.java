package com.meditation.my_sequence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meditation.my_sequence.service.PushNotificationService;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private PushNotificationService pushService;

    @PostMapping
    public ResponseEntity<String> send(@RequestParam String token,
                                       @RequestParam String title,
                                       @RequestParam String body) {
        try {
            pushService.sendNotification(token, title, body);
            return ResponseEntity.ok("Notification sent");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed: " + e.getMessage());
        }
    }
}

