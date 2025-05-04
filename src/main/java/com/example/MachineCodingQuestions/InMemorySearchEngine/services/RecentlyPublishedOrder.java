package com.example.MachineCodingQuestions.InMemorySearchEngine.services;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SortOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.ResultOrderStrategy;

import java.util.Comparator;
import java.util.List;

public class RecentlyPublishedOrder implements ResultOrderStrategy {
    @Override
    public List<Article> sort(List<Article> articles, SortOrderType sortOrderType) {
        if(sortOrderType==SortOrderType.ASC){
            articles.sort(Comparator.comparing(article -> article.getLastPublishedDate()));
        }
        else{
            articles.sort((doc1,doc2)->doc2.getLastPublishedDate().compareTo(doc1.getLastPublishedDate()));
        }
        return articles;
    }
}
