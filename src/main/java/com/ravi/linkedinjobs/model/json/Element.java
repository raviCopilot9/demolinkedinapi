package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Element {

    @JsonProperty("items")
    private List<Item> items;

    // Getter and Setter
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

