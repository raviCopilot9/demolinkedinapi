package com.ravi.linkedinjobs.controller;

import com.ravi.linkedinjobs.model.JobDetails;
import com.ravi.linkedinjobs.model.RequestBodyModel;
import com.ravi.linkedinjobs.model.ResponseData;
import com.ravi.linkedinjobs.model.json.LinkedInResponse;
import com.ravi.linkedinjobs.service.LinkedInRestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LinkedInController {

    private static final Logger logger = LoggerFactory.getLogger(LinkedInController.class);

    private final LinkedInRestService linkedInRestService;

    private final RestTemplate restTemplate;


    @GetMapping("/home")
    public String home() {
        return "Hello from LinkedIn App home.";
    }

    @Operation(summary = "Gets your LinkedIn My Jobs data",
        responses = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "200", description = "Response Successful",
                content = { @Content(schema = @Schema(implementation = ResponseData.class))
            }),
        }
    )
    @PostMapping("/linkedin/saved-jobs")
    public ResponseEntity<ResponseData> getSavedJobs(@RequestBody RequestBodyModel model) {//SAVED,IN_PROGRESS,ARCHIVED,APPLIED
        String apiUrl = linkedInRestService.getApiUrl(model);

        // Build headers & Entity
        HttpEntity<String> entity = new HttpEntity<>(linkedInRestService.getApiHeaders(model));

        // Make the API call
        ResponseEntity<LinkedInResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                LinkedInResponse.class
        );

        // Prepare Response Data
        ResponseData responseData = new ResponseData();

        // Access parsed data
        if (response != null && response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            try {
                // Create response data
                List<JobDetails> apiJobDetailsResponse = linkedInRestService.paraseAndCreateResponseData(response.getBody());
                responseData.setData(apiJobDetailsResponse);
            } catch (Exception e) {
                responseData.setError("Failed to parse data.");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
            }

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        } else {
            responseData.setError("Failed to fetch data.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }
}
