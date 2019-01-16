package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.harrymartland.example.resttemplate.dto.PostCodeResponse;

@RestController
public class PostCodeController {

    private final RestTemplate restTemplate;

    public PostCodeController(@Qualifier("postcodeRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/postcode/{postcode}")
    public PostCodeResponse getPostCode(@PathVariable String postcode) {
        return restTemplate.getForObject("/postcodes/{postcode}", PostCodeResponse.class, postcode);
    }

}
