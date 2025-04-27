package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.FollowRequest;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;

import java.util.List;

public interface FollowRequestService {
    public void createFollowRequest(Profile sender,Profile receiver);
    public List<FollowRequest>fetchAllRequest(Profile profile);
    public void acceptFollowRequest(FollowRequest followRequest);
    public void rejectFollowRequest(FollowRequest followRequest);
}
