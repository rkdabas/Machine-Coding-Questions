package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.Profile;

public interface NotificationService {
    public void sendNotification(String description, Profile profile);
}
