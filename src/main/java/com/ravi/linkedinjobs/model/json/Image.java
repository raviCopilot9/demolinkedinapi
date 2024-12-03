package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    @JsonProperty("accessibilityText")
    private String accessibilityText;

    // Getter and Setter
    public String getAccessibilityText() {
        return accessibilityText;
    }

    public void setAccessibilityText(String accessibilityText) {
        this.accessibilityText = accessibilityText;
    }
}

