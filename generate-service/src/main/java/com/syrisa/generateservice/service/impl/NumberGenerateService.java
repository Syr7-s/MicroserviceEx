package com.syrisa.generateservice.service.impl;

import com.syrisa.generateservice.service.Generate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberGenerateService {
    public Generate<String> generate = numberSize -> {
        StringBuilder builder = new StringBuilder();
        builder.append(1 + new Random().nextInt(9));
        for (int i = 0; i < numberSize - 1; i++) {
            builder.append(new Random().nextInt(10));
        }
        return builder.toString();
    };
}
