package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.dto.Timeline;
import com.example.MachineCodingQuestions.Instagram.interfaces.PostService;
import com.example.MachineCodingQuestions.Instagram.interfaces.TimelineService;

public class PostServiceImpl implements PostService {
    private TimelineServiceImpl timelineService= new TimelineServiceImpl();

    @Override
    public void createPost(Profile profile, String description) {
        Post post = new Post(description,profile);
        profile.getPosts().add(post);
        if(!profile.isCelebrity()){
            timelineService.addToTimeline(post,profile.getFollowers());
        }
    }
}
