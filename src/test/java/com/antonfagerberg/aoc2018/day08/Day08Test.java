package com.antonfagerberg.aoc2018.day08;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Day08Test {

    @Test
    public void part1Example1() {
        int[] input = {2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2};
        Assert.assertEquals(138, Day08.part1(input));
    }

    @Test
    public void testPart1() throws IOException, URISyntaxException {
        var input = Input.get("day08/input")
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .mapToInt(Integer::parseInt)
                .toArray();

        Assert.assertEquals(42951, Day08.part1(input));
    }

    @Test
    public void part2Example1() {
        int[] input = {2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2};
        Assert.assertEquals(66, Day08.part2(input));
    }

    @Test
    public void testPart2() throws IOException, URISyntaxException {
        var input = Input.get("day08/input")
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .mapToInt(Integer::parseInt)
                .toArray();

        Assert.assertEquals(18568, Day08.part2(input));
    }

}
