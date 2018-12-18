package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FactController {

    private final RestTemplate restTemplate;

    public FactController( @Qualifier("catFactsRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/fact")
    public String getFact(){
        return restTemplate.getForObject("/facts/random", CatFactResponse.class).getText();
    }

    public static class CatFactResponse {

        private String text;

        public String getText() {
            return text;
        }

    }
}
