package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Notification;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.NotificationService;

public class SmsNotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String description, Profile profile) {
        Notification notification=new Notification(description);
//        add logic to send notification to phone number
        System.out.println("sms notification sent");
    }
}
