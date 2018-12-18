package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostCodeController {

    private final RestTemplate restTemplate;

    public PostCodeController(@Qualifier("postcodeRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/postcode/{postcode}")
    private PostCodeResponse getPostCode(@PathVariable String postcode) {
        return restTemplate.getForObject("/postcodes/{postcode}", PostCodeResponse.class, postcode);
    }

    public static class PostCodeResponse {
        private PostCodeResult result;

        public PostCodeResult getResult() {
            return result;
        }

        public void setResult(PostCodeResult result) {
            this.result = result;
        }
    }

    public static class PostCodeResult {
        private String longitude;
        private String latitude;
        private String parish;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getParish() {
            return parish;
        }

        public void setParish(String parish) {
            this.parish = parish;
        }
    }
}
