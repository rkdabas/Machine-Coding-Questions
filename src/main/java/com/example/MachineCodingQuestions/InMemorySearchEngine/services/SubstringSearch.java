package com.example.MachineCodingQuestions.InMemorySearchEngine.services;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Category;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class SubstringSearch implements SearchStrategy {
    @Override
    public List<Article> search(Category category, String pattern) {
        List<Article>result=new ArrayList<>();
        String lowerCasedPattern=pattern.toLowerCase();
        for(Article arl: category.getArticles()){
            String content=arl.getContent().toLowerCase();
            if(content.contains(lowerCasedPattern)){
                result.add(arl);
            }
        }
        return result;
    }
}
