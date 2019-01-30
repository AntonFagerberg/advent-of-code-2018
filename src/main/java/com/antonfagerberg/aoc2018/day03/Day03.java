package com.antonfagerberg.aoc2018.day03;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.HashSet;
import java.util.regex.Pattern;

public class Day03 {

    static Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+,\\d+): (\\d+x\\d+)");

    public static ImmutablePair<ImmutablePair<Integer, Integer>, ImmutablePair<Integer, Integer>> parse(String input) {
        var matcher = pattern.matcher(input);

        matcher.find();

        var xy = matcher.group(2).split(",");
        var wt = matcher.group(3).split("x");

        return ImmutablePair.of(
                ImmutablePair.of(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])),
                ImmutablePair.of(Integer.parseInt(wt[0]), Integer.parseInt(wt[1]))
        );
    }

    private static HashSet<ImmutablePair<Integer, Integer>> duplicates(String[] input) {
        var firstCheck = new HashSet<ImmutablePair<Integer, Integer>>();
        var duplicates = new HashSet<ImmutablePair<Integer, Integer>>();

        for (var line : input) {
            var pieces = parse(line);

            var xy = pieces.left;
            var wt = pieces.right;

            for (var x = xy.left; x < xy.left + wt.left; x++) {
                for (var y = xy.right; y < xy.right + wt.right; y++) {
                    var point = ImmutablePair.of(x, y);
                    if (firstCheck.contains(point)) {
                        duplicates.add(point);
                    } else {
                        firstCheck.add(point);
                    }
                }
            }
        }

        return duplicates;
    }


    public static int part1(String[] input) {
        return duplicates(input).size();
    }

    public static int part2(String[] input) {
        var duplicates = duplicates(input);
        var id = 1;

        for (var line : input) {
            var pieces = parse(line);

            var xy = pieces.left;
            var wt = pieces.right;

            var noDuplicates = true;

            for (var x = xy.left; x < xy.left + wt.left; x++) {
                for (var y = xy.right; y < xy.right + wt.right; y++) {
                    var point = ImmutablePair.of(x, y);

                    if (duplicates.contains(point)) {
                        noDuplicates = false;
                    }
                }
            }

            if (noDuplicates) {
                return id;
            }

            id++;
        }


        throw new IllegalStateException();
    }

}
