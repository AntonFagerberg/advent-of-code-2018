package com.antonfagerberg.aoc2018.day05;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class Day05Test {

    @Test
    public void testPart01Example01() {
        var exampleInput = "dabAcCaCBAcCcaDAaA";
        assertEquals("dabCBAcaDA", Day05.reactUntilNoChange(exampleInput));
    }

    @Test
    public void testPart01() throws IOException, URISyntaxException {
        var input = Input.get("day05/input").findFirst().get();
        assertEquals(10708, Day05.part1(input));
    }


    @Test
    public void testPart02Example01() {
        var exampleInput = "dabAcCaCBAcCcaDA";
        assertEquals(4, Day05.part2(exampleInput));
    }

    @Test
    public void testPart02() throws IOException, URISyntaxException {
        var input = Input.get("day05/input").findFirst().get();
        assertEquals(5330, Day05.part2(input));
    }

}