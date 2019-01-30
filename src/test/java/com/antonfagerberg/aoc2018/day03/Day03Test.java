package com.antonfagerberg.aoc2018.day03;

import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class Day03Test {

    @Test
    public void testPart01Parser() {
        var result = Day03.parse("#1 @ 11,33: 22x44");

        var xy = result.left;
        assertEquals(11, xy.left.intValue());
        assertEquals(33, xy.right.intValue());

        var wt = result.right;
        assertEquals(22, wt.left.intValue());
        assertEquals(44, wt.right.intValue());
    }

    @Test
    public void testPart01Example() {
        String[] input = {
                "#1 @ 1,3: 4x4",
                "#2 @ 3,1: 4x4",
                "#3 @ 5,5: 2x2"
        };

        assertEquals(4, Day03.part1(input));
    }

    @Test
    public void testPart01() throws IOException, URISyntaxException {
        String[] input = Input.get("day03/input").toArray(String[]::new);
        assertEquals( 96569, Day03.part1(input));
    }

    @Test
    public void testPart02() throws IOException, URISyntaxException {
        String[] input = Input.get("day03/input").toArray(String[]::new);
        assertEquals( 1023, Day03.part2(input));
    }

}
