package com.example.MachineCodingQuestions.InMemorySearchEngine.factory;

import com.example.MachineCodingQuestions.InMemorySearchEngine.enums.ResultOrderType;
import com.example.MachineCodingQuestions.InMemorySearchEngine.interfaces.ResultOrderStrategy;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.AuthorNameOrder;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.RecentlyPublishedOrder;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.RecentlySearchedOrder;
import com.example.MachineCodingQuestions.InMemorySearchEngine.services.RecentlyUpdatedOrder;

public class ResultOrderFactory {
    public static ResultOrderStrategy createResultOrderStrategy(ResultOrderType type){
        return switch (type){
            case RECENTLY_PUBLISHED -> new RecentlyPublishedOrder();
            case RECENTLY_SEARCHED -> new RecentlySearchedOrder();
            case RECENTLY_UPDATED -> new RecentlyUpdatedOrder();
            case AUTHOR_NAME -> new AuthorNameOrder();
            default -> null;
        };
    }
}
