package uk.co.harrymartland.example.resttemplate.controller;

import java.util.stream.IntStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.harrymartland.example.resttemplate.SlowService;

@RestController
public class SlowController {

    private final SlowService slowService;

    public SlowController(SlowService slowService) {
        this.slowService = slowService;
    }

    @GetMapping("/slow/{amount}")
    public void getSlow(@PathVariable int amount){
        IntStream.range(0,amount).forEach(slowService::get);
    }

}
