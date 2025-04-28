package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.dto.SearchCatalog;
import com.example.MachineCodingQuestions.Instagram.interfaces.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    @Override
    public void createProfile(String email, String password, String id) {
        Profile profile=new Profile(email,password,id);
        SearchCatalog searchCatalog=SearchCatalog.getInstance();
        searchCatalog.getProfiles().put(id,profile);
    }
}
