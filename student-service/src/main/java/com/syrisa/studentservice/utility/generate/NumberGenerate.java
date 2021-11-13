package com.syrisa.studentservice.utility.generate;

import java.util.Random;

public final class NumberGenerate {
    public static Generate<Long> generate = numberSize -> {
        StringBuilder builder = new StringBuilder();
        builder.append(1 + new Random().nextInt(9));
        for (int i = 0; i < numberSize - 1; i++) {
            builder.append(new Random().nextInt(10));
        }
        return Long.parseLong(builder.toString());
    };
}
