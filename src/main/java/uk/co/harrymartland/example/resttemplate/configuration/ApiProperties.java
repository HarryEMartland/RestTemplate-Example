package uk.co.harrymartland.example.resttemplate.configuration;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private ApiProperty catFacts;
    private ApiProperty joke;
    private ApiProperty postcode;

    public ApiProperty getCatFacts() {
        return catFacts;
    }

    public void setCatFacts(ApiProperty catFacts) {
        this.catFacts = catFacts;
    }

    public ApiProperty getJoke() {
        return joke;
    }

    public void setJoke(ApiProperty joke) {
        this.joke = joke;
    }

    public ApiProperty getPostcode() {
        return postcode;
    }

    public void setPostcode(ApiProperty postcode) {
        this.postcode = postcode;
    }

    public static class ApiProperty{
        private String url;
        private Duration connectTimeout;
        private Duration readTimeout;
        private boolean secure;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Duration getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public Duration getReadTimeout() {
            return readTimeout;
        }

        public void setReadTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
        }

        public boolean isSecure() {
            return secure;
        }

        public void setSecure(boolean secure) {
            this.secure = secure;
        }
    }
}
