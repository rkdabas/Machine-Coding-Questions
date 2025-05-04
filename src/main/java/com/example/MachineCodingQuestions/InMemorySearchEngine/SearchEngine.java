package com.example.MachineCodingQuestions.InMemorySearchEngine;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Category;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.ResultOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SearchType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SortOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.factory.ResultOrderFactory;
import com.example.MachineCodingQuestions.InMemorySearchEngine.factory.SearchFactory;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.ResultOrderStrategy;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.SearchStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private static SearchEngine instance;
    public final Map<String, Category>categoryMap;

    private SearchEngine(){
        categoryMap=new HashMap<>();
    }

    public static synchronized SearchEngine getInstance(){
        if(instance==null){
            instance=new SearchEngine();
        }
        return instance;
    }

    public void createCategory(String categoryName){
        Category category=new Category(categoryName);
        categoryMap.put(categoryName,category);
    }

    public void addArticleToCategory(String categoryName,String articleName,String content,String author){
        Category category=categoryMap.get(categoryName);
        Article article=new Article(articleName,content,author);
        category.addArticle(article);
    }

    public List<Article>search(String categoryName, String pattern, SearchType searchType, ResultOrderType resultOrderType, SortOrderType sortOrderType){
        Category category=categoryMap.get(categoryName);
        SearchStrategy searchStrategy= SearchFactory.createSearchStrategy(searchType);
        List<Article>searchResult=searchStrategy.search(category,pattern);
        ResultOrderStrategy resultOrderStrategy= ResultOrderFactory.createResultOrderStrategy(resultOrderType);
        return resultOrderStrategy.sort(searchResult,sortOrderType);
    }
}
