package com.antonfagerberg.aoc2018.day06;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.HashSet;

class Day06 {

    static int part1(String[] input) {

        int maxX = 0, maxY = 0;
        var key = 'A';
        var coordinates = new HashMap<Character, Pair<Integer, Integer>>();
        var infinite = new HashSet<Character>();
        var charCount = new HashMap<Character, Integer>();

        for (var line : input) {
            var parts = line.split(", ");
            var x = Integer.parseInt(parts[0]);
            var y = Integer.parseInt(parts[1]);

            if (x > maxX) {
                maxX = x;
            }

            if (y > maxY) {
                maxY = y;
            }

            coordinates.put(key, Pair.of(x, y));
            key++;
        }

        for (var x = 0; x <= maxX; x++) {
            for (var y = 0; y <= maxY; y++) {
                var delta = Integer.MAX_VALUE;

                var identifier = '.';

                for (var entry : coordinates.entrySet()) {
                    var xx = entry.getValue().getLeft();
                    var yy = entry.getValue().getRight();

                    var entryDelta = Math.abs(xx - x) + Math.abs(yy - y);

                    if (entryDelta < delta) {
                        identifier = entry.getKey();

                        delta = entryDelta;
                    } else if (entryDelta == delta) {
                        identifier = '.';
                    }
                }

                charCount.merge(identifier, 1, (a, b) -> a + b);

                if (x == 0 || x == maxX || y == 0 || y == maxY) {
                    infinite.add(identifier);
                }
            }
        }

        var maxSize = 0;

        for (var entry : charCount.entrySet()) {
            if (entry.getKey() != '.' && !infinite.contains(entry.getKey())) {
                if (entry.getValue() > maxSize) {
                    maxSize = entry.getValue();
                }
            }
        }

        return maxSize;
    }

    static int part2(String[] input, int targetDistance) {

        int maxX = 0, maxY = 0;
        var key = 'A';
        var coordinates = new HashMap<Character, Pair<Integer, Integer>>();

        for (var line : input) {
            var parts = line.split(", ");
            var x = Integer.parseInt(parts[0]);
            var y = Integer.parseInt(parts[1]);

            if (x > maxX) {
                maxX = x;
            }

            if (y > maxY) {
                maxY = y;
            }

            coordinates.put(key, Pair.of(x, y));
            key++;
        }

        var area = 0;

        for (var x = 0; x <= maxX; x++) {
            for (var y = 0; y <= maxY; y++) {
                var distance = 0;

                for (var entry : coordinates.entrySet()) {
                    var xx = entry.getValue().getLeft();
                    var yy = entry.getValue().getRight();

                    distance += Math.abs(xx - x) + Math.abs(yy - y);
                }

                if (distance < targetDistance) {
                    area++;
                }
            }
        }

        return area;
    }

}
