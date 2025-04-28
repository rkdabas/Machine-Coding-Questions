package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.interfaces.TimelineService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimelineServiceImpl implements TimelineService {
    @Override
    public List<Post> fetchTimeline(Profile profile) {
        List<Post>posts=profile.getTimeline().getPosts();
        List<Post>celebPosts=pullCelebPosts(profile);
        posts.addAll(celebPosts);
        profile.getTimeline().setPosts(new ArrayList<>());
        return posts;
    }

    @Override
    public void addToTimeline(Post post, List<Profile> profiles) {
        profiles.stream().parallel().forEach(profile -> profile.getTimeline().getPosts().add(post));
    }

    private List<Post>pullCelebPosts(Profile profile){
        List<Post>posts=new ArrayList<Post>();
        List<Profile>followings=profile.getFollowings();
        List<Profile>celebs=followings.stream().filter(following -> following.isCelebrity()).collect(Collectors.toList());
        celebs.stream().forEach(celeb -> posts.addAll(getPostOfProfileAfterTime(profile.getLastSeen(),celeb.getPosts())));
        return posts;
    }
    private List<Post>getPostOfProfileAfterTime(LocalDateTime lastSeen,List<Post>posts){
//        do binary search to return all list of posts
        return posts;
    }
}
