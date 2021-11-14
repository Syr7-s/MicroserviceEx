package com.syrisa.lectureservice.utilities.generate.impl;

import com.syrisa.lectureservice.utilities.generate.Generate;

import java.util.Random;

public class NumberGenerate {
    public static Generate<Long> generate = numberSize -> {
        StringBuilder builder = new StringBuilder();
        builder.append(1 + new Random().nextInt(9));
        for (int i = 0; i < numberSize - 1; i++) {
            builder.append(new Random().nextInt(10));
        }
        return Long.parseLong(builder.toString());
    };
}
