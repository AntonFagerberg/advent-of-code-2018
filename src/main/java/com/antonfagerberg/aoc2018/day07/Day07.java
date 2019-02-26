package com.antonfagerberg.aoc2018.day07;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Day07 {

    public static String part1(String[] input) {
        var edges = Arrays.stream(input)
                .map(sentence -> {
                    var words = sentence.split(" ");
                    var from = words[1];
                    var to = words[7];
                    return Pair.of(from, to);
                })
                .collect(Collectors.toList());


        var available = edges.stream()
                .filter(edge -> edges.stream().noneMatch(e -> e.getRight().equals(edge.getLeft())))
                .map(Pair::getLeft)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));

        var result = "";

        while (true) {
            final var finalResult = result;

            var newAvailable = edges.stream()
                    .filter(edge -> !finalResult.contains(edge.getRight()))
                    .map(Pair::getRight)
                    .distinct()
                    .filter(node ->
                            edges.stream()
                                    .filter(edge -> edge.getRight().equals(node))
                                    .allMatch(edge -> finalResult.contains(edge.getLeft()))
                    )
                    .sorted()
                    .collect(Collectors.toCollection(TreeSet::new));

            available.addAll(newAvailable);

            if (available.isEmpty()) {
                return result;
            } else {
                result += available.pollFirst();
            }
        }
    }

}
