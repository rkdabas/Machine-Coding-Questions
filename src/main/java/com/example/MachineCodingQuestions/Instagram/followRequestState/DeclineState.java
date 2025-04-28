package com.example.MachineCodingQuestions.Instagram.followRequestState;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.services.EmailNotificationServiceImpl;

public class DeclineState extends State{
    public DeclineState(){
        super(new EmailNotificationServiceImpl());
    }

    @Override
    public void notifyUser(FollowRequest followRequest){
        notificationService.sendNotification("Your follow request is declined: ",followRequest.getSender());
    }
}
