package com.example.MachineCodingQuestions.InMemorySearchEngine.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    public String name;
    public List<Article>articles;
    public InvertedIndex invertedIndex;

    public Category(String name){
        this.name=name;
        this.articles=new ArrayList<>();
        this.invertedIndex=new InvertedIndex();
    }

    public void addArticle(Article article){
        articles.add(article);
        updateInvertedIndex(article);
    }

    public void updateInvertedIndex(Article article){
        invertedIndex.addArticle(article);
    }
}
