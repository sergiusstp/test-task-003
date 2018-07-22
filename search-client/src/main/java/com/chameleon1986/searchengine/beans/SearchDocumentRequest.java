package com.chameleon1986.searchengine.beans;

import java.io.Serializable;

public class SearchDocumentRequest implements Serializable {
   private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


}