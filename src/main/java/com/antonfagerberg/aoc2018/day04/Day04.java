package com.antonfagerberg.aoc2018.day04;

import java.util.*;

public class Day04 {

    public static ParsedInput[] parseAndSortInput(String[] input) {
        return Arrays
                .stream(input)
                .map(ParsedInput::new)
                .sorted()
                .toArray(ParsedInput[]::new);
    }

    public static long part1(ParsedInput[] input) {
        var minutesPerGuard = new HashMap<Integer, Long>();
        var minuteSleepCountPerGuard = new HashMap<Integer, HashMap<Integer, Integer>>();

        var calendar = GregorianCalendar.getInstance();

        int guardId = -1;
        Date sleep = null;

        for (var entry : input) {
            switch (entry.getEventType()) {
                case GUARD:
                    guardId = entry.getGuardId();
                    sleep = entry.getDate();
                    break;

                case SLEEP:
                    sleep = entry.getDate();
                    break;

                case WAKE:
                    Objects.requireNonNull(guardId);
                    Objects.requireNonNull(sleep);

                    var sleepEpoch = sleep.getTime() / (60 * 1000);
                    var awakeEpoch = entry.getDate().getTime() / (60 * 1000);
                    minutesPerGuard.merge(guardId, awakeEpoch - sleepEpoch, (a, b) -> a + b);

                    calendar.setTime(sleep);
                    var startMinute = calendar.get(Calendar.MINUTE);

                    calendar.setTime(entry.getDate());
                    var endMinute = calendar.get(Calendar.MINUTE);

                    for (var minute = startMinute; minute < endMinute; minute = (minute + 1) % 60) {
                        var minuteSleepCount = minuteSleepCountPerGuard.getOrDefault(guardId, new HashMap<>());
                        minuteSleepCount.merge(minute, 1, (a, b) -> a + b);
                        minuteSleepCountPerGuard.put(guardId, minuteSleepCount);
                    }

                    break;

                default:
                    throw new IllegalStateException();
            }
        }

        guardId = -1;

        var max = -1L;

        for (var entry : minutesPerGuard.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                guardId = entry.getKey();
            }
        }

        if (max == -1) {
            throw new IllegalStateException();
        }

        max = -1L;
        var minute = -1l;

        for (var entry : minuteSleepCountPerGuard.get(guardId).entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                minute = entry.getKey();
            }
        }

        if (guardId == -1 || minute == -1 || max == -1L) {
            throw new IllegalStateException();
        }

        return guardId * minute;
    }

    public static int part2(ParsedInput[] input) {
        var minuteSleepCountPerGuard = new HashMap<Integer, HashMap<Integer, Integer>>();

        var calendar = GregorianCalendar.getInstance();

        int guardId = -1;
        Date sleep = null;

        for (var entry : input) {
            switch (entry.getEventType()) {
                case GUARD:
                    guardId = entry.getGuardId();
                    sleep = entry.getDate();
                    break;

                case SLEEP:
                    sleep = entry.getDate();
                    break;

                case WAKE:
                    Objects.requireNonNull(guardId);
                    Objects.requireNonNull(sleep);

                    calendar.setTime(sleep);
                    var startMinute = calendar.get(Calendar.MINUTE);

                    calendar.setTime(entry.getDate());
                    var endMinute = calendar.get(Calendar.MINUTE);

                    for (var minute = startMinute; minute < endMinute; minute = (minute + 1) % 60) {
                        var minuteSleepCount = minuteSleepCountPerGuard.getOrDefault(guardId, new HashMap<>());
                        minuteSleepCount.merge(minute, 1, (a, b) -> a + b);
                        minuteSleepCountPerGuard.put(guardId, minuteSleepCount);
                    }

                    break;

                default:
                    throw new IllegalStateException();
            }
        }

        guardId = -1;
        var sleepMinute = -1;
        var maxSleep = -1;

        for (var guardEntry : minuteSleepCountPerGuard.entrySet()) {
            for (var sleepCount : guardEntry.getValue().entrySet()) {
                if (sleepCount.getValue() > maxSleep) {
                    guardId = guardEntry.getKey();
                    sleepMinute = sleepCount.getKey();
                    maxSleep = sleepCount.getValue();
                }
            }
        }

        if (guardId == -1 || sleepMinute == -1 || maxSleep == -1) {
            throw new IllegalStateException();
        }

        return guardId * sleepMinute;
    }


}
