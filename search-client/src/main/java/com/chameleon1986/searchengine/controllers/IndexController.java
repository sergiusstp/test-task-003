package com.chameleon1986.searchengine.controllers;

import com.chameleon1986.searchengine.beans.*;
import com.chameleon1986.searchengine.services.RestService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class IndexController {

    public IndexController(RestService restService) {
        this.restService = restService;
    }
    private final RestService restService;


    @GetMapping(value = {"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("item", new Item());
        return "index";
    }


    @GetMapping(value = "/engine")
    public String getAllData(Model model) {
        List<SingleDocument> rates = restService.findAll();

        model.addAttribute("item", new Item());
        model.addAttribute("data", rates);
        return "index";
    }


    @GetMapping(value = "/engine/findById")
    public String findById(@ModelAttribute Item item, Model model) {

        SingleDocument singleDocument = null;

        if (item.getKey() != null)
            singleDocument = restService.findById(item.getKey().toString());

        if (singleDocument == null)
            model.addAttribute("data", null);
        else
            model.addAttribute("data", singleDocument);

        model.addAttribute("item", new Item());
        return "index";
    }


    @PostMapping(value = "/engine")
    public String postDocument(@ModelAttribute Item item, Model model) {

        PostDocumentResponse postDocumentResponse = null;
        if (item.getDocument().length() > 0) {
            PostDocumentRequest doc = new PostDocumentRequest();
            doc.setDocument(item.getDocument());
            postDocumentResponse = restService.saveDocument(doc);
        }

        Item itemThymeleaf = new Item();
        if (postDocumentResponse != null)
            itemThymeleaf.setPostResponseBody("new key = " + postDocumentResponse.getKey());

        model.addAttribute("item", itemThymeleaf);
        return "index";
    }


    @PostMapping(value = "/engine/search")
    public String searchKeysByCondition(@ModelAttribute Item item, Model model) {

        SearchDocumentResponse searchDocumentResponse = null;
        if (item.getCondition().length() > 0) {
            SearchDocumentRequest doc = new SearchDocumentRequest();
            doc.setCondition(item.getCondition());
            searchDocumentResponse = restService.getKeysByCondition(doc);
        }

        Item itemThymeleaf = new Item();
        if (searchDocumentResponse != null) {
            String joined = String.join(",", searchDocumentResponse.getKeys());
            itemThymeleaf.setSearchResponseBody(joined);
        }

        model.addAttribute("item", itemThymeleaf);
        return "index";
    }


}
