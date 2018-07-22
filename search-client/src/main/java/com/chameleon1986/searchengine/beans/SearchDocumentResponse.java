package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class SearchDocumentResponse implements Serializable {
    private String[] keys;

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }
}