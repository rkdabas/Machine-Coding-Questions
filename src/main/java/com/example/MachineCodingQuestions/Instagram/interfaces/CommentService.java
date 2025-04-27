package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.Comment;
import com.example.MachineCodingQuestions.Instagram.dto.Post;
import com.example.MachineCodingQuestions.Instagram.dto.Profile;

public interface CommentService {
    public void createCommentOnPost(String description, Profile cretedBy, Post post);
    public void createCommentOnComment(String description, Profile createdBy, Comment comment);

}
