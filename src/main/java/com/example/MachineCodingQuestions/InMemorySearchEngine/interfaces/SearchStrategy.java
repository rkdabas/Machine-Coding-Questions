package com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Category;

import java.util.List;

public interface SearchStrategy {
    public List<Article>search(Category category,String pattern);
}
