package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;

import java.util.List;

public interface TimelineService {
    public List<Post>fetchTimeline(Profile profile);
    public void addToTimeline(Post post,List<Profile>profiles);
}
