package com.antonfagerberg.aoc2018.day01;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class Day01Test {

    @Test
    public void testPart01Example01() {
        int[] input = {1, 1, 1};
        assertEquals("Day 1, Part 1, Example 1", 3, Day01.part1(input));
    }

    @Test
    public void testPart01Example02() {
        int[] input = {1, 1, -2};
        assertEquals("Day 1, Part 1, Example 2", 0, Day01.part1(input));
    }

    @Test
    public void testPart01Example03() {
        int[] input = {-1, -2, -3};
        assertEquals("Day 1, Part 1, Example 3", -6, Day01.part1(input));
    }


    @Test
    public void testPart01() throws IOException, URISyntaxException {
        int[] input = Input.get("day01/input").mapToInt(Integer::parseInt).toArray();
        assertEquals("Day 1, Part 1", 510, Day01.part1(input));
    }

    @Test
    public void testPart02Example01() {
        int[] input = {1, -1};
        assertEquals("Day 1, Part 2, Example 1", 0, Day01.part2(input));
    }

    @Test
    public void testPart02Example02() {
        int[] input = {3, 3, 4, -2 - 4};
        assertEquals("Day 1, Part 2, Example 2", 10, Day01.part2(input));
    }

    @Test
    public void testPart02Example03() {
        int[] input = {-6, 3, 8, 5, -6};
        assertEquals("Day 1, Part 2, Example 3", 5, Day01.part2(input));
    }

    @Test
    public void testPart02Example04() {
        int[] input = {7, 7, -2, -7, -4};
        assertEquals("Day 1, Part 2, Example 4", 14, Day01.part2(input));
    }


    @Test
    public void testPart02() throws IOException, URISyntaxException {
        int[] input = Input.get("day01/input").mapToInt(Integer::parseInt).toArray();
        assertEquals("Day 1, Part 2", 69074, Day01.part2(input));
    }

}
