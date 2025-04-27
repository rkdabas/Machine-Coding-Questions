package com.example.MachineCodingQuestions.Instagram.followRequestState;

//using state design pattern

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;

public abstract class State {
    public abstract void notifyUser(FollowRequest followRequest);

}
