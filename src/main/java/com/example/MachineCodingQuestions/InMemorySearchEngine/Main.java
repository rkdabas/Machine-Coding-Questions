package com.example.MachineCodingQuestions.InMemorySearchEngine;

import com.example.MachineCodingQuestions.InMemorySearchEngine.dtos.Article;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.ResultOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SearchType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SortOrderType;

import java.util.List;

public class Main {
    public static void main(String args[]){
        SearchEngine searchEngine=SearchEngine.getInstance();

        searchEngine.createCategory("Tech articles");
        searchEngine.createCategory("news articles");

        searchEngine.addArticleToCategory("Tech articles","blog on ai/ml","This is the first line of ai/ml blog post on deep learning","author1");
        searchEngine.addArticleToCategory("Tech articles","blog on blockchain","Learning is deep and This is the second line of blockchain blog post","author2");
        searchEngine.addArticleToCategory("news articles","blog on terror","This is the third line of ai/ml terror post","author3");
        searchEngine.addArticleToCategory("news articles","blog on investors","This is the fourth line of investors blog post","author4");

        List<Article>result1=searchEngine.search("Tech articles","deep learning", SearchType.UNORDERED, ResultOrderType.RECENTLY_PUBLISHED, SortOrderType.ASC);
        System.out.println("Unordered seach results for deep learning are ");
        for(Article article:result1){
            System.out.println(article.getName());
        }

    }
}
