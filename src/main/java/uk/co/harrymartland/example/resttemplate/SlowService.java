package uk.co.harrymartland.example.resttemplate;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Service;

@Service
public class SlowService {

    private static final Logger LOG = LoggerFactory.getLogger(SlowService.class);

    @NewSpan
    @Timed("slow_service")
    public void get(@SpanTag("seconds") int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOG.trace("Error sleeping", e);
        }
    }
}
