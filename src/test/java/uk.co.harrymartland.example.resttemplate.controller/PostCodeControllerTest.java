package uk.co.harrymartland.example.resttemplate.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class PostCodeControllerTest {

    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private PostCodeController postCodeController = new PostCodeController(restTemplate);

    @Test
    private void shouldCallService(){

        postCodeController.getPostCode("AT3ST");


    }

}