package com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SortOrderType;

import java.util.List;

public interface ResultOrderStrategy {
    public List<Article>sort(List<Article>articles, SortOrderType sortOrderType);
}
