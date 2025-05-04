package com.example.MachineCodingQuestions.InMemorySearchEngine.services;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SortOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.ResultOrderStrategy;

import java.util.List;

public class AuthorNameOrder implements ResultOrderStrategy {
    @Override
    public List<Article> sort(List<Article> articles, SortOrderType sortOrderType) {
        return List.of();
    }
}
