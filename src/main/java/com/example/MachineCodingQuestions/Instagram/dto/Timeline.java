package com.example.MachineCodingQuestions.Instagram.dto;


import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Data
public class Timeline {
    private List<Post>posts;

    public Timeline(){
        posts=new ArrayList<>();
    }
}
