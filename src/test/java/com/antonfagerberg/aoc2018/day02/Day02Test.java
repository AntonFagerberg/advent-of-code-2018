package com.antonfagerberg.aoc2018.day02;


import com.antonfagerberg.aoc2018.tools.Input;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class Day02Test {

    @Test
    public void testPart01Example01() {
        String[] input = {
                "abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab"
        };
        assertEquals(12, Day02.part01(input));
    }

    @Test
    public void testPart01() throws IOException, URISyntaxException {
        var input = (String[]) Input.get("day02/input").toArray(String[]::new);
        assertEquals(6474, Day02.part01(input));
    }

    @Test
    public void testPart02Example01() {
        String[] input = {
                "abcde",
                "fghij",
                "klmno",
                "pqrst",
                "fguij",
                "axcye",
                "wvxyz"
        };

        assertEquals("fgij", Day02.part02(input));
    }

    @Test
    public void testPart02() throws IOException, URISyntaxException {
        var input = (String[]) Input.get("day02/input").toArray(String[]::new);
        assertEquals("mxhwoglxgeauywfkztndcvjqr", Day02.part02(input));
    }

}
