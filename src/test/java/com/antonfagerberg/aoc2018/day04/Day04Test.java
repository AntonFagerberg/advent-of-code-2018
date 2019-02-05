package com.antonfagerberg.aoc2018.day04;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Day04Test {

    @Test
    public void testParseAndSortInput() {
        var input = new String[]{
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:05] falls asleep"
        };

        var expected = new String[]{
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up"
        };

        assertEquals(expected, Stream.of(Day04.parseAndSortInput(input)).map(ParsedInput::toString).toArray(String[]::new));
    }

    @Test
    public void testPart01Example01() throws IOException, URISyntaxException {
        var exampleInput = Input.get("day04/example").toArray(String[]::new);
        var parsedInput = Day04.parseAndSortInput(exampleInput);
        assertEquals(240, Day04.part1(parsedInput));
    }

    @Test
    public void testPart01() throws IOException, URISyntaxException {
        var exampleInput = Input.get("day04/input").toArray(String[]::new);
        var parsedInput = Day04.parseAndSortInput(exampleInput);
        assertEquals(84834, Day04.part1(parsedInput));
    }

    @Test
    public void testPart02Example01() throws IOException, URISyntaxException {
        var exampleInput = Input.get("day04/example").toArray(String[]::new);
        var parsedInput = Day04.parseAndSortInput(exampleInput);
        assertEquals(4455, Day04.part2(parsedInput));
    }

    @Test
    public void testPart02() throws IOException, URISyntaxException {
        var exampleInput = Input.get("day04/input").toArray(String[]::new);
        var parsedInput = Day04.parseAndSortInput(exampleInput);
        assertEquals(53427, Day04.part2(parsedInput));
    }

}
