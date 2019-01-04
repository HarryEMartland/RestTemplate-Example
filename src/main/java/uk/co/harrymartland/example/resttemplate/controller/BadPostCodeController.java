package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.co.harrymartland.example.resttemplate.configuration.ApiProperties;
import uk.co.harrymartland.example.resttemplate.dto.PostCodeResponse;

@RestController
public class BadPostCodeController {

    private final ApiProperties apiProperties;

    public BadPostCodeController(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @GetMapping("/bad/postcode/{postcode}")
    private PostCodeResponse getPostCode(@PathVariable String postcode) {
        String baseUrl = apiProperties.getPostcode().getUrl();
        return new RestTemplate().getForObject(baseUrl + "/postcodes/" + postcode, PostCodeResponse.class);
    }

}
