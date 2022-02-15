package com.syrisa.webappbff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @GetMapping("/home")
    public String welcome() {
        return "Welcome";
    }

}
