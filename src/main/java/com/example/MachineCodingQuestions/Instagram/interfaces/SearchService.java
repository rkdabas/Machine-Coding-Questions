package com.example.MachineCodingQuestions.Instagram.interfaces;

import com.example.MachineCodingQuestions.Instagram.dto.Profile;

import java.util.List;

public interface SearchService {
    public List<Profile>searchProfile(String searchKey);
}
