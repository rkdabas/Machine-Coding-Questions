package com.example.MachineCodingQuestions.InMemorySearchEngine.dtos;

import java.util.*;

public class InvertedIndex {
    public Map<String, Set<Article>>index;

    public InvertedIndex(){
        index=new HashMap<>();
    }

    public void addArticle(Article article){
        String[] words=article.getContent().toLowerCase().split("\\W+");
        for(String word:words){
            if(!index.containsKey(word)){
                Set<Article>set=new HashSet<>();
                set.add(article);
                index.put(word,set);
            }
            else{
                index.get(word).add(article);
            }
        }
    }

    public Set<Article> getArticlesForWord(String word){
        if(index.containsKey(word)){
            return index.get(word);
        }
        return null;
    }


}
