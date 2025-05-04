package com.example.MachineCodingQuestions.InMemorySearchEngine.services;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Category;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.SearchStrategy;

import java.util.List;

public class OrderedSearch implements SearchStrategy {
    @Override
    public List<Article> search(Category category, String pattern) {
        System.out.println("not implemented");
        return List.of();
    }
}
