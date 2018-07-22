package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class PostDocumentRequest implements Serializable {
   private String document;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


}