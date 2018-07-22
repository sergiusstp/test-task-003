package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class Item implements Serializable {
    private Integer key;
    private String document;
    private String condition;

    private String postResponseBody;
    private String searchResponseBody;


    // standard getters and setters
    public Integer getKey() {
        return key;
    }
    public void setKey(Integer key) {
        this.key = key;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPostResponseBody() {
        return postResponseBody;
    }

    public void setPostResponseBody(String postResponseBody) {
        this.postResponseBody = postResponseBody;
    }

    public String getSearchResponseBody() {
        return searchResponseBody;
    }

    public void setSearchResponseBody(String searchResponseBody) {
        this.searchResponseBody = searchResponseBody;
    }
}
