package com.antonfagerberg.aoc2018.day01;

import java.util.Arrays;
import java.util.HashSet;

public class Day01 {

    static int part1(int[] input) {
        return Arrays.stream(input).sum();
    }

    static int part2(int[] input) {
        var sum = 0;

        var seen = new HashSet<Integer>() {{
            add(0);
        }};

        var index = 0;

        while (true) {
            sum += input[index];

            if (seen.contains(sum)) {
                return sum;
            } else {
                seen.add(sum);
                index = (index + 1) % input.length;
            }
        }
    }

}
