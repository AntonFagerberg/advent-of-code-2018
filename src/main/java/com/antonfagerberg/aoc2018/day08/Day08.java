package com.antonfagerberg.aoc2018.day08;

import java.util.Stack;

public class Day08 {

    public static int part1(int[] input) {
        final var metaCount = new Stack<Integer>();
        final var childCount = new Stack<Integer>();

        var total = 0;

        for (int i = 0; i < input.length; i++) {
            if (!childCount.empty() && childCount.peek() == 0) {
                var metaEntriesRemaining = metaCount.pop();

                if (metaEntriesRemaining > 0) {
                    total += input[i];
                    metaCount.push(metaEntriesRemaining - 1);
                } else {
                    childCount.pop();
                    childCount.push(childCount.pop() - 1);
                    i--;
                }
            } else {
                childCount.push(input[i]);
                metaCount.push(input[i + 1]);
                i++;
            }
        }

        return total;
    }

}
