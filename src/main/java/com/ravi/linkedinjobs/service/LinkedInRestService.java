package com.ravi.linkedinjobs.service;

import com.ravi.linkedinjobs.model.JobDetails;
import com.ravi.linkedinjobs.model.RequestBodyModel;
import com.ravi.linkedinjobs.model.json.Element;
import com.ravi.linkedinjobs.model.json.EntityResultDetails;
import com.ravi.linkedinjobs.model.json.Item;
import com.ravi.linkedinjobs.model.json.LinkedInResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LinkedInRestService {


    public String getApiUrl(RequestBodyModel model) {
        String apiUrl = "https://www.linkedin.com/voyager/api/graphql";
        String queryParams = "?variables=(start:0,query:(flagshipSearchIntent:SEARCH_MY_ITEMS_JOB_SEEKER,queryParameters:List((key:cardType,value:List("+model.getCardType()+")))))&queryId=voyagerSearchDashClusters.8832876bc08b96972d2c68331a27ba76";

        return apiUrl + queryParams;
    }

    public HttpHeaders getApiHeaders(RequestBodyModel model) {
        // Build headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("cookie", model.getCookie());
        headers.set("csrf-token", model.getCsrfToken());
        headers.set("Content-Type", "application/json");

        return headers;
    }

    public List<JobDetails> paraseAndCreateResponseData(LinkedInResponse jsonResponse) {
        List<JobDetails> apiJobDetailsResponse = new ArrayList<>();
        for (Element element : jsonResponse.getData().getSearchDashClustersByAll().getElements()) {
            for (Item item : element.getItems()) {
                EntityResultDetails entityResultDetails = item.getItem().getEntityResult();
                JobDetails jd = new JobDetails(entityResultDetails.getTitle().getText(),
                        entityResultDetails.getPrimarySubtitle().getText(), entityResultDetails.getSecondarySubtitle().getText(),
                        entityResultDetails.getInsightsResolutionResults().get(0).getSimpleInsight().getTitle().getText());
                apiJobDetailsResponse.add(jd);
            }
        }
        return apiJobDetailsResponse;
    }

}
