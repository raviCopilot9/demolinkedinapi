package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("item")
    private EntityResult item;

    // Getter and Setter
    public EntityResult getItem() {
        return item;
    }

    public void setItem(EntityResult item) {
        this.item = item;
    }
}

