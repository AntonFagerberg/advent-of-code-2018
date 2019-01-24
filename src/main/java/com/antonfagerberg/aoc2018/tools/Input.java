package com.antonfagerberg.aoc2018.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;

public class Input {

    public static Stream<String> get(String resource) {
        InputStream inputStream = Input.class.getClassLoader().getResourceAsStream(resource);
        InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(inputStream));
        BufferedReader bufferedReader = new BufferedReader(reader);
        return bufferedReader.lines();
    }

}
