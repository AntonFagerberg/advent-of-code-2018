package com.antonfagerberg.aoc2018.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day02 {

    static int part01(String[] input) {
        var count2 = 0;
        var count3 = 0;

        for (var line : input) {
            var charCount = new HashMap<Character, Integer>();

            for (var letter : line.toCharArray()) {
                charCount.merge(letter, 1, (a, b) -> a + b);
            }

            if (charCount.values().stream().anyMatch(i -> i == 2)) {
                count2 += 1;
            }

            if (charCount.values().stream().anyMatch(i -> i == 3)) {
                count3 += 1;
            }

        }

        return count2 * count3;
    }

    static String part02(String[] input) {
        var maxScore = input[0].length();

        for (var i = 0; i < input.length; i++) {
            var id1 = input[i];

            for (var j = i + 1; j < input.length; j++) {
                var id2 = input[j];

                var score = 1;

                for (var x = 0; x < maxScore; x++) {
                    if (id1.charAt(x) == id2.charAt(x)) {
                        score++;
                    }
                }

                if (score == maxScore) {
                    var builder = new StringBuilder();
                    for (var x = 0; x < maxScore; x++) {
                        if (id1.charAt(x) == id2.charAt(x)) {
                            builder.append(id1.charAt(x));
                        }
                    }

                    return builder.toString();
                }
            }
        }

        //var result = branch(0, new HashMap<>() {{ put('?', new ArrayList<>(Arrays.asList(input))); }});
        return null;
    }

    static ArrayList<String> branch(int index, HashMap<Character, ArrayList<String>> partitions) {

        var result = new ArrayList<String>();

        for (var ids : partitions.values()) {
            if (ids.size() > 2) {
                if (ids.get(0).length() == index) {
                    return ids;
                } else {
                    var newPartitions = new HashMap<Character, ArrayList<String>>();

                    for (var id : ids) {
                        newPartitions.merge(id.charAt(index), new ArrayList<>() {{ add(id); }}, (a, b) -> { a.addAll(b); return a; } );
                    }

                    result.addAll(branch(index + 1, newPartitions));
                }
            }
        }

        return result;
    }

}
