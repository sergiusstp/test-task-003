package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class PostDocumentResponse implements Serializable {
   private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}