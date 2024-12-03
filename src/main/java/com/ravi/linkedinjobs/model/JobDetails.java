package com.ravi.linkedinjobs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobDetails {

    @JsonProperty("Role")
    private String role;

    @JsonProperty("Company")
    private String company;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("Applied")
    private String applied;

    public JobDetails(String role, String company, String location, String applied) {
        this.role = role;
        this.company = company;
        this.location = location;
        this.applied = applied;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getApplied() {
        return applied;
    }
}
