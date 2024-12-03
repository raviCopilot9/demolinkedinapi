package com.ravi.linkedinjobs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseData {

    @JsonProperty("data")
    private List<JobDetails> data;

    @JsonProperty("error")
    private String error;

    public List<JobDetails> getData() {
        return data;
    }

    public void setData(List<JobDetails> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
