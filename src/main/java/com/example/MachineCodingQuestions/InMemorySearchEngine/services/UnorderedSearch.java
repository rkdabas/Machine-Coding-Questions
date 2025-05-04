package com.example.MachineCodingQuestions.InMemorySearchEngine.services;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Category;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.SearchStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnorderedSearch implements SearchStrategy {
    @Override
    public List<Article> search(Category category, String pattern) {
        String[] words=pattern.toLowerCase().split(" ");

        Set<Article>articles=new HashSet<>();
        Set<Article>firstWordArticles=category.getInvertedIndex().getArticlesForWord(words[0]);
        if(firstWordArticles!=null){
            articles.addAll(firstWordArticles);
        }

        for(int i=1;i<words.length;i++){
            Set<Article>currentWordArticle=category.getInvertedIndex().getArticlesForWord(words[i]);
            if(currentWordArticle==null){
                articles.clear();
                break;
            }
            articles.retainAll(currentWordArticle);
        }
        return new ArrayList<>(articles);
    }
}
