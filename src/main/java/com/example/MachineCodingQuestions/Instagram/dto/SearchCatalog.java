package com.example.MachineCodingQuestions.Instagram.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

// It has profiles in map
// This should be singleton as only one instance of search catalog shoould
// be everywhere

@Data
@AllArgsConstructor
public class SearchCatalog {
    private Map<String,Profile>profiles;
    private static SearchCatalog searchCatalog=null;

    private SearchCatalog(){
        this.profiles=new HashMap<String,Profile>();
    }

    public static SearchCatalog getInstance(){
        if(searchCatalog==null){
            searchCatalog=new SearchCatalog();
        }
        return searchCatalog;
    }
}
