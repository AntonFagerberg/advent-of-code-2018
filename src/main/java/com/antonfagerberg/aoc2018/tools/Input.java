package com.antonfagerberg.aoc2018.tools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Input {

    public static Stream<String> get(String resource) throws URISyntaxException, IOException {
        return Files.lines(Paths.get(Input.class.getClassLoader().getResource(resource).toURI()));
    }

}
