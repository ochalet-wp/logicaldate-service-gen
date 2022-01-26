package io.swagger.service;

import io.swagger.model.Lde;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/*
* Dummy DB service to hold in memory a map of logical date per app and group
* */
@Component("inMemoryLdeCache")
public class InMemoryLdeCache {

    private HashMap<String, Lde> dates;

    public InMemoryLdeCache() {
        dates = new HashMap<>();
    }

    public void putLde(String application, String processingGroup, Lde lde) {
        dates.put(application+processingGroup,lde);
    }

    public Lde getLde(String application, String processingGroup) {
        return dates.get(application+processingGroup);
    }
}
