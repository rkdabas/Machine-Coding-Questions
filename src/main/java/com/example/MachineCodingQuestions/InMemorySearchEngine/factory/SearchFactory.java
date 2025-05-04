package com.example.MachineCodingQuestions.InMemorySearchEngine.factory;

import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.SearchType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.SearchStrategy;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.OrderedSearch;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.SubstringSearch;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.UnorderedSearch;

public class SearchFactory {
    public static SearchStrategy createSearchStrategy(SearchType type){
        return switch (type){
            case ORDERED -> new OrderedSearch();
            case UNORDERED -> new UnorderedSearch();
            case SUBSTRING -> new SubstringSearch();
            default -> null;
        };
    }
}
