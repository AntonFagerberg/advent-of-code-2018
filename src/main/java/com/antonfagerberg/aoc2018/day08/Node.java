package com.antonfagerberg.aoc2018.day08;

import java.util.Arrays;

class Node {
    String id;
    int children;
    int[] meta;
    int index;
    String parent;

    public String toString() {
        return id + "\n-----\n" + parent + "\nchildren: " + children + "\n" + Arrays.toString(meta);
    }
}