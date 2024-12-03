package com.ravi.linkedinjobs.controller;

import com.ravi.linkedinjobs.service.LinkedInRestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class LinkedInControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestTemplate restTemplate;

    @MockitoBean
    private LinkedInRestService linkedInRestService;

    @InjectMocks
    private LinkedInController linkedInController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSavedJobs_Error() throws Exception {

        // JSON body for the POST request
        String jsonRequest = """
            {
                "cardType": "APPLIED",
                "cookie": "Test-Cookie",
                "csrfToken": "Test-CsrfToken"
            }
        """;

        // Perform the mock MVC call
        mockMvc.perform(post("/linkedin/saved-jobs")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

}
