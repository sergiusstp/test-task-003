package com.chameleon1986.searchengine.controllers;

import com.chameleon1986.searchengine.documents.ConditionDocument;
import com.chameleon1986.searchengine.documents.InputDocument;
import com.chameleon1986.searchengine.services.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/engine")
public class SearchController {

    private final SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<HashMap<String, Object>>> getAllDocuments() {

        List<HashMap<String, Object>> list = searchService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<HashMap<String, Object>> getDocumentById(@PathVariable String id) {

        HashMap<String, Object> map = searchService.findById(new Long(id));

        if (map != null)
            return new ResponseEntity<>(map, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HashMap<String, Object>> postDocument(@RequestBody InputDocument inputDocument) {

        Long id = searchService.saveDocument(inputDocument.document);

        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("key", id);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }


    @PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HashMap<String, Object>> searchKeysByCondition(@RequestBody ConditionDocument document) {

        List<String> list = searchService.getKeysByCondition(document.condition);

        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("keys", list);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
