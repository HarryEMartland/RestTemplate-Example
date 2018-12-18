package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JokeController {

    private final RestTemplate restTemplate;

    public JokeController(@Qualifier("jokeRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/joke")
    public String getIpsum() {
        return restTemplate.getForObject("/jokes/random", JokeResponse.class).getValue();
    }

    public static class JokeResponse{

        private String value;

        public String getValue() {
            return value;
        }
    }
}
