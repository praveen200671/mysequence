package com.meditation.my_sequence.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.*;

@Service
public class PushNotificationService {

    public void sendNotification(String deviceToken, String title, String body) throws FirebaseMessagingException {
        Notification notification = Notification.builder()
                .setTitle(title)
                .setBody(body)
                .build();

        Message message = Message.builder()
                .setToken(deviceToken)
                .setNotification(notification)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
   
    }
}
