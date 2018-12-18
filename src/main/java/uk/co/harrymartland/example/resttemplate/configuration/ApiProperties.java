package uk.co.harrymartland.example.resttemplate.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private ApiProperty catFacts;
    private ApiProperty joke;

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

    public static class ApiProperty{
        private String url;
        private int connectTimeout;
        private int readTimeout;
        private boolean secure;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public int getReadTimeout() {
            return readTimeout;
        }

        public void setReadTimeout(int readTimeout) {
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
