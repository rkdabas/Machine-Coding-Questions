package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Notification;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.NotificationService;

public class EmailNotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String description, Profile profile) {
        Notification notification=new Notification(description);
        System.out.println("email notification sent");
    }
}
