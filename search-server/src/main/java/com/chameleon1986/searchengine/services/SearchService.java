package com.chameleon1986.searchengine.services;

import java.util.HashMap;
import java.util.List;

public interface SearchService {

    // GET ALL
    List<HashMap<String, Object>> findAll();

    // GET
    HashMap<String, Object> findById(Long l);

    // POST
    Long saveDocument(String string);

    // POST
    List<String> getKeysByCondition(String string);

}
