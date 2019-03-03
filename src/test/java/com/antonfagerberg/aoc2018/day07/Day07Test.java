package com.antonfagerberg.aoc2018.day07;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day07Test {

    @Test
    public void testPart1Example1() {
        var input = new String[]{
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        };

        Assert.assertEquals("CABDFE", Day07.part1(input));
    }

    @Test
    public void testPart1() throws IOException, URISyntaxException {
        var input = Input.get("day07/input").toArray(String[]::new);
        Assert.assertEquals("JMQZELVYXTIGPHFNSOADKWBRUC", Day07.part1(input));
    }

    @Test
    public void testPart2Example1() {
        var input = new String[]{
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        };

        Assert.assertEquals(15, Day07.part2(input, 2, 0));
    }

    @Test
    public void testPart2() throws IOException, URISyntaxException {
        var input = Input.get("day07/input").toArray(String[]::new);
        Assert.assertEquals(1133, Day07.part2(input, 5, 60));
    }

}
