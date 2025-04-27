package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.Comment;
import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;

public interface LikeService {
    public void likeOnPost(Post post, Profile createdBy);
    public void likeOnComment(Comment comment,Profile createdBy);
    public void unLikeOnComment(Comment comment,Profile createdBy);
    public void unLikeOnPost(Post post,Profile createdBy);
}
