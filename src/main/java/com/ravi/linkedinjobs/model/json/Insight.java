package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Insight {

    @JsonProperty("simpleInsight")
    private SimpleInsight simpleInsight;

    // Getter and Setter
    public SimpleInsight getSimpleInsight() {
        return simpleInsight;
    }

    public void setSimpleInsight(SimpleInsight simpleInsight) {
        this.simpleInsight = simpleInsight;
    }
}

