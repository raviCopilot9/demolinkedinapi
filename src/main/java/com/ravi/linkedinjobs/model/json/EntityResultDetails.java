package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityResultDetails {

    @JsonProperty("insightsResolutionResults")
    private List<Insight> insightsResolutionResults;

    @JsonProperty("primarySubtitle")
    private Text primarySubtitle;

    @JsonProperty("secondarySubtitle")
    private Text secondarySubtitle;

    @JsonProperty("title")
    private Text title;

    @JsonProperty("image")
    private Image image;

    // Getters and Setters
    public List<Insight> getInsightsResolutionResults() {
        return insightsResolutionResults;
    }

    public void setInsightsResolutionResults(List<Insight> insightsResolutionResults) {
        this.insightsResolutionResults = insightsResolutionResults;
    }

    public Text getPrimarySubtitle() {
        return primarySubtitle;
    }

    public void setPrimarySubtitle(Text primarySubtitle) {
        this.primarySubtitle = primarySubtitle;
    }

    public Text getSecondarySubtitle() {
        return secondarySubtitle;
    }

    public void setSecondarySubtitle(Text secondarySubtitle) {
        this.secondarySubtitle = secondarySubtitle;
    }

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

