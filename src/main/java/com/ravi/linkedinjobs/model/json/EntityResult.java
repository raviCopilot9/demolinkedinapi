package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityResult {

    @JsonProperty("entityResult")
    private EntityResultDetails entityResult;

    // Getter and Setter
    public EntityResultDetails getEntityResult() {
        return entityResult;
    }

    public void setEntityResult(EntityResultDetails entityResult) {
        this.entityResult = entityResult;
    }
}

