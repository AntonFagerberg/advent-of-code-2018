package com.antonfagerberg.aoc2018.day06;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.Assert.assertEquals;

public class Day06Test {

    @Test
    public void testPart01Example() throws IOException, URISyntaxException {
        var input = Input.get("day06/example").toArray(String[]::new);
        assertEquals(17, Day06.part1(input));
    }

    @Test
    public void testPart01() throws IOException, URISyntaxException {
        var input = Input.get("day06/input").toArray(String[]::new);
        assertEquals(3260, Day06.part1(input));
    }


    @Test
    public void testPart02Example() throws IOException, URISyntaxException {
        var input = Input.get("day06/example").toArray(String[]::new);
        assertEquals(16, Day06.part2(input, 32));
    }


    @Test
    public void testPart02() throws IOException, URISyntaxException {
        var input = Input.get("day06/input").toArray(String[]::new);
        assertEquals(42535, Day06.part2(input, 10000));
    }

}
