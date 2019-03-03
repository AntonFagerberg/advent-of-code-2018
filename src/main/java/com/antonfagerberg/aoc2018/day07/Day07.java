package com.antonfagerberg.aoc2018.day07;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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


    public static int part2(String[] input, int workers, int duration) {
        var edges = Arrays.stream(input)
                .map(sentence -> {
                    var words = sentence.split(" ");
                    var from = words[1];
                    var to = words[7];
                    return Pair.of(from.charAt(0), to.charAt(0));
                })
                .collect(Collectors.toList());


        var available = edges.stream()
                .filter(edge -> edges.stream().noneMatch(e -> e.getRight().equals(edge.getLeft())))
                .map(Pair::getLeft)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));

        var result = "";
        var elapsedTime = 0;

        var workTimers = new int[workers];
        var workerAllocation = new HashMap<Integer, Character>();
        var used = new HashSet<Character>();

        while (true) {
            String finalResult = result;

            var newAvailable = edges.stream()
                    .filter(edge -> !used.contains(edge.getRight()))
                    .map(Pair::getRight)
                    .distinct()
                    .filter(node ->
                            edges.stream()
                                    .filter(edge -> edge.getRight().equals(node))
                                    .allMatch(edge -> finalResult.indexOf(edge.getLeft()) != -1)
                    )
                    .sorted()
                    .collect(Collectors.toCollection(TreeSet::new));

            available.addAll(newAvailable);

            if (available.isEmpty() && workerAllocation.isEmpty()) {
                return elapsedTime;
            } else {
                for (int i = 0; i < workTimers.length; i++) {
                    if (workTimers[i] > 0) {
                        workTimers[i] -= 1;
                    }

                    if (workTimers[i] == 0) {
                        var done = workerAllocation.remove(i);

                        if (done != null) {
                            result += done;
                        }

                        var allocation = available.pollFirst();

                        if (allocation != null) {
                            used.add(allocation);
                            workerAllocation.put(i, allocation);
                            workTimers[i] = allocation + duration - 'A';
                        }
                    }
                }

                elapsedTime += 1;
            }

        }
    }

}
