package uk.co.harrymartland.example.resttemplate.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import uk.co.harrymartland.example.resttemplate.dto.PostCodeResponse;

public class PostCodeControllerTest {

    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private PostCodeController controller = new PostCodeController(restTemplate);
    private PostCodeResponse mockResponse = Mockito.mock(PostCodeResponse.class);

    @Test
    public void shouldMakeRequest() {
        String url = "/postcodes/{postcode}";
        String postcode = "AT3ST";
        Class<PostCodeResponse> postcodeClass = PostCodeResponse.class;
        when(restTemplate.getForObject(url, postcodeClass, postcode))
                .thenReturn(mockResponse);

        PostCodeResponse result = controller.getPostCode(postcode);
        verify(restTemplate).getForObject(url, postcodeClass, postcode);
        assertEquals(mockResponse, result);
    }
}