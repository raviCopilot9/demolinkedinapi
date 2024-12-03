package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleInsight {

    @JsonProperty("title")
    private Text title;

    // Getter and Setter
    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }
}
