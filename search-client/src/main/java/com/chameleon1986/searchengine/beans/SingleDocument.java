package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class SingleDocument implements Serializable {
   private String key;
   private String document;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


}