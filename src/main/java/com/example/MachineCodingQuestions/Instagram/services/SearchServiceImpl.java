package com.example.MachineCodingQuestions.Instagram.services;

import com.example.MachineCodingQuestions.Instagram.dto.Profile;
import com.example.MachineCodingQuestions.Instagram.dto.SearchCatalog;
import com.example.MachineCodingQuestions.Instagram.interfaces.SearchService;

import java.util.List;
import java.util.Map;

public class SearchServiceImpl implements SearchService {
    @Override
    public List<Profile> searchProfile(String searchKey) {
//        implement trie approach
        Map<String,Profile>profiles= SearchCatalog.getInstance().getProfiles();
        return null;
    }
}
