package com.antonfagerberg.aoc2018.day08;

import java.util.*;

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

    public static int part2(int[] input) {
        final var metaCount = new Stack<Integer>();
        final var childCount = new Stack<Integer>();
        final var nodes = new Stack<Node>();
        final var allNodes = new ArrayList<Node>();

        for (int i = 0; i < input.length; i++) {
            if (!childCount.empty() && childCount.peek() == 0) {
                var metaEntriesRemaining = metaCount.pop();

                if (metaEntriesRemaining > 0) {
                    var node = nodes.peek();
                    node.meta[node.index] = input[i];
                    node.index++;

                    metaCount.push(metaEntriesRemaining - 1);
                } else {
                    nodes.pop();
                    childCount.pop();
                    childCount.push(childCount.pop() - 1);
                    i--;
                }
            } else {
                childCount.push(input[i]);
                metaCount.push(input[i + 1]);

                final var iFinal = i;

                new Node() {{
                    id = UUID.randomUUID().toString();
                    children = input[iFinal];
                    meta = new int[input[iFinal + 1]];

                    if (!nodes.empty()) {
                        parent = nodes.peek().id;
                    }

                    allNodes.add(this);
                    nodes.add(this);
                }};

                i++;
            }
        }

        var root = allNodes.stream()
                .filter(node -> node.parent == null)
                .findFirst()
                .get();

        return resolve(root, allNodes);
    }

    private static int resolve(Node node, ArrayList<Node> nodes) {
        var total = 0;

        if (node.children == 0) {
            for (var meta : node.meta) {
                total += meta;
            }
        } else {
            var children = nodes.stream()
                    .filter(n -> Objects.nonNull(n.parent) && n.parent.equals(node.id))
                    .toArray(Node[]::new);

            for (var meta : node.meta) {
                if (meta - 1 < children.length) {
                    total += resolve(children[meta - 1], nodes);
                }

            }
        }

        return total;
    }

}
