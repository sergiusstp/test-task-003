package com.chameleon1986.searchengine.services;

import com.chameleon1986.searchengine.beans.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RestServiceImpl implements RestService {
    // By default Service annotation creates a singleton scoped bean.

    // document storage
    private HashMap<Long, String> storage = new HashMap<>();

    // token set storage
    private HashMap<Long, HashSet<String>> tokens = new HashMap<>();

    // current key value
    private AtomicLong key = new AtomicLong();


    @Override
    public List<SingleDocument> findAll() {

        RestTemplate restTemplate = new RestTemplate();
        String findAllResourceUrl
                = "http://localhost:8010/engine/";

        ResponseEntity<String> response
                = restTemplate.getForEntity(findAllResourceUrl, String.class);

        ResponseEntity<List<SingleDocument>> rateResponse =
                restTemplate.exchange(findAllResourceUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<SingleDocument>>() {
                        });

        List<SingleDocument> rates = rateResponse.getBody();

        return rates;
    }


    @Override
    public SingleDocument findById(String s) {

        RestTemplate restTemplate = new RestTemplate();
        String findByIdResourceUrl
                = "http://localhost:8010/engine/" + s;

        // only body response
        SingleDocument singleDocument = null;
        try {
            singleDocument = restTemplate
                    .getForObject(findByIdResourceUrl, SingleDocument.class);
        }
        catch (Exception e) {
        }

        return singleDocument;

    }


    @Override
    public PostDocumentResponse saveDocument(PostDocumentRequest doc) {

        RestTemplate restTemplate = new RestTemplate();
        String postDocumentResourceUrl
                = "http://localhost:8010/engine/";

        HttpEntity<PostDocumentRequest> request = new HttpEntity<>(doc);

        ResponseEntity<PostDocumentResponse> response =
                restTemplate.exchange(postDocumentResourceUrl,
                        HttpMethod.POST, request,
                        new ParameterizedTypeReference<PostDocumentResponse>() {
                        });

        PostDocumentResponse responseBody = response.getBody();
        return responseBody;

    }


    public SearchDocumentResponse getKeysByCondition(SearchDocumentRequest doc) {

        RestTemplate restTemplate = new RestTemplate();
        String postDocumentResourceUrl
                = "http://localhost:8010/engine/search";

        HttpEntity<SearchDocumentRequest> request = new HttpEntity<>(doc);

        ResponseEntity<SearchDocumentResponse> response =
                restTemplate.exchange(postDocumentResourceUrl,
                        HttpMethod.POST, request,
                        new ParameterizedTypeReference<SearchDocumentResponse>() {
                        });

        SearchDocumentResponse responseBody = response.getBody();
        return responseBody;
    }
}
