package com.syrisa.generateservice.controller;

import com.syrisa.generateservice.service.Generate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GenerateController {
    private final Generate<String> generate;

    public GenerateController(Generate<String> generate) {
        this.generate = generate;
    }

    @GetMapping("/generate/{size}")
    public String generateNumber(@PathVariable("size") int size){
        return generate.generate(size);
    }
}
