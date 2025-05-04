package com.example.MachineCodingQuestions.InMemorySearchEngine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    public String name;
    public String content;
    public String author;
    public Date lastPublishedDate;
    public Date lastUpdatedDate;
    public Date lastSearchedDate;

    public Article(String name,String content,String author){
        this.name=name;
        this.content=content;
        this.author=author;
        this.lastPublishedDate=new Date();
        this.lastSearchedDate=null;
        this.lastUpdatedDate=new Date();
    }
}
