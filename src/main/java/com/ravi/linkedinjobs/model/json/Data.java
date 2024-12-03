package com.ravi.linkedinjobs.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("searchDashClustersByAll")
    private SearchDashClustersByAll searchDashClustersByAll;

    // Getter and Setter
    public SearchDashClustersByAll getSearchDashClustersByAll() {
        return searchDashClustersByAll;
    }

    public void setSearchDashClustersByAll(SearchDashClustersByAll searchDashClustersByAll) {
        this.searchDashClustersByAll = searchDashClustersByAll;
    }
}

