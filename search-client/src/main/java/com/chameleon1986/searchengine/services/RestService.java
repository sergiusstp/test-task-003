package com.chameleon1986.searchengine.services;

import com.chameleon1986.searchengine.beans.*;

import java.util.List;

public interface RestService {

    // GET ALL
    List<SingleDocument> findAll();

    // GET
    SingleDocument findById(String s);

    // POST
    PostDocumentResponse saveDocument(PostDocumentRequest doc);

    // POST
    SearchDocumentResponse getKeysByCondition(SearchDocumentRequest doc);

}
