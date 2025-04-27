package com.example.MachineCodingQuestions.Instagram.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String description;
    private Profile createdBy;
    private List<Comment>comments;
    private List<Like>likes;

    public Comment(String description,Profile createdBy){
        this.description=description;
        this.createdBy=createdBy;
        comments=new ArrayList<>();
        likes=new ArrayList<>();
    }
}
