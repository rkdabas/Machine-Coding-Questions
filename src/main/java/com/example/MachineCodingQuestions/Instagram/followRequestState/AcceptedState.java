package com.example.MachineCodingQuestions.Instagram.followRequestState;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.interfaces.NotificationService;
import com.example.MachineCodingQuestions.Instagram.services.SmsNotificationServiceImpl;

public class AcceptedState extends State{
    public AcceptedState(){
        super(new SmsNotificationServiceImpl());
    }

    @Override
    public void notifyUser(FollowRequest followRequest){
        notificationService.sendNotification("Your follow request is accepted: ",followRequest.getSender());
    }
}
