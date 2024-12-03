package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text {

    @JsonProperty("text")
    private String text;

    // Getter and Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
