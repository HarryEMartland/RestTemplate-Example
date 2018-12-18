package uk.co.harrymartland.example.resttemplate.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfiguration {

    private final ApiProperties apiProperties;
    private final MeterRegistry meterRegistry;

    public ApiConfiguration(ApiProperties apiProperties, MeterRegistry meterRegistry) {
        this.apiProperties = apiProperties;
        this.meterRegistry = meterRegistry;
    }

    @Bean
    public PoolingHttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        monitor(manager);
        return manager;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClientConnectionManager manager) {
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(manager)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Bean
    public RestTemplate catFactsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        ApiProperties.ApiProperty properties = apiProperties.getCatFacts();
        return restTemplateBuilder
                .rootUri(properties.getUrl())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .build();
    }

    @Bean
    public RestTemplate jokeRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        ApiProperties.ApiProperty properties = apiProperties.getJoke();
        return restTemplateBuilder
                .rootUri(properties.getUrl())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .interceptors()
                .build();
    }

    @Bean
    public RestTemplate postcodeRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        ApiProperties.ApiProperty properties = apiProperties.getPostcode();
        return restTemplateBuilder
                .rootUri(properties.getUrl())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .interceptors()
                .build();
    }

    private void monitor(PoolingHttpClientConnectionManager manager) {
        meterRegistry.gauge("http.pool.total", Tags.of("status", "leased"), manager, (m) -> m.getTotalStats().getLeased());
        meterRegistry.gauge("http.pool.total", Tags.of("status", "pending"), manager, (m) -> m.getTotalStats().getPending());
        meterRegistry.gauge("http.pool.total", Tags.of("status", "available"), manager, (m) -> m.getTotalStats().getAvailable());

        monitor(manager,  apiProperties.getCatFacts());
        monitor(manager, apiProperties.getJoke());
        monitor(manager, apiProperties.getPostcode());
    }

    private void monitor(PoolingHttpClientConnectionManager manager, ApiProperties.ApiProperty joke) {
        HttpRoute jokeRoute = new HttpRoute(HttpHost.create(joke.getUrl()), null, joke.isSecure());
        meterRegistry.gauge("http.pool", Tags.of("status", "leased", "host", joke.getUrl()), manager, (m) -> m.getStats(jokeRoute).getLeased());
        meterRegistry.gauge("http.pool", Tags.of("status", "pending", "host", joke.getUrl()), manager, (m) -> m.getStats(jokeRoute).getPending());
        meterRegistry.gauge("http.pool", Tags.of("status", "available", "host", joke.getUrl()), manager, (m) -> m.getStats(jokeRoute).getAvailable());
    }
}
