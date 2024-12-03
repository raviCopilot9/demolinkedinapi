package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkedInResponse {
    @JsonProperty("data")
    private Data data;

    // Getters and Setters
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
