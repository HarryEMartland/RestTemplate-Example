package uk.co.harrymartland.example.resttemplate.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.harrymartland.example.resttemplate.repository.NumberEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NumbersControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnNumber() {
        NumberEntity forObject = testRestTemplate.getForObject("/number/5", NumberEntity.class);
        assertEquals((Integer) 5, forObject.getNumber());
    }
}