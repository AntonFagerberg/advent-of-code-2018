package com.antonfagerberg.aoc2018.day05;

import java.util.HashSet;

class Day05 {

    static int part1(String input) {
        return reactUntilNoChange(input).length();
    }

    static String reactUntilNoChange(String input) {
        var current = input;
        var permutation = react(current);

        while (!current.equals(permutation)) {
            current = permutation;
            permutation = react(current);
        }

        return current;
    }

    private static String react(String input) {
        var permutation = new StringBuilder();

        for (var i = 0; i < input.length(); i++) {
            var current = input.charAt(i);

            try {
                var next = input.charAt(i + 1);

                if (Math.abs(current - next) != 32) {
                    permutation.append(current);
                } else {
                    i++;
                }
            } catch (IndexOutOfBoundsException e) {
                permutation.append(current);
            }
        }

        return permutation.toString();
    }

    static int part2(String input) {
        var targets = new HashSet<Character>() {{
            for (var c : input.toUpperCase().toCharArray()) {
                add(c);
            }
        }};

        var shortestLength = input.length();

        for (var target : targets) {
            var changedInput =
                    input.replace(target.toString(), "")
                            .replace(target.toString().toLowerCase(), "");

            var reactionLength = part1(changedInput);

            if (shortestLength > reactionLength) {
                shortestLength = reactionLength;
            }
        }

        return shortestLength;
    }

}
