package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchDashClustersByAll {

    @JsonProperty("elements")
    private List<Element> elements;

    // Getter and Setter
    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}

