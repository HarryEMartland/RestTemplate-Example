package uk.co.harrymartland.example.resttemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.harrymartland.example.resttemplate.repository.NumberEntity;
import uk.co.harrymartland.example.resttemplate.repository.NumberRepository;

@RestController
public class NumbersController {

    private final NumberRepository numberRepository;

    public NumbersController(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @GetMapping("/number/{number}")
    public NumberEntity getNumber(@PathVariable Integer number){
        return numberRepository.findNumber(number);
    }
}
