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
        String postcode = "AT3ST";
        when(restTemplate.getForObject("/postcodes/{postcode}", PostCodeResponse.class, postcode))
                .thenReturn(mockResponse);

        PostCodeResponse result = controller.getPostCode(postcode);
        verify(restTemplate).getForObject("/postcodes/{postcode}", PostCodeResponse.class, postcode);
        assertEquals(mockResponse, result);
    }
}