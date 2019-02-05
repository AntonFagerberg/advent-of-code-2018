package com.antonfagerberg.aoc2018.day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ParsedInput implements Comparable<ParsedInput> {

    private String input;
    private EventType eventType;
    private Date date;
    private int guardId = -1;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Pattern pattern = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})\\] (Guard #\\d+|falls asleep|wakes up)");

    public ParsedInput(String input) {
        var matcher = pattern.matcher(input);
        matcher.find();

        this.input = input;

        try {
            date = dateFormat.parse(matcher.group(1));
            var event = matcher.group(2);

            if (event.startsWith("Guard")) {
                eventType = EventType.GUARD;
                guardId = Integer.parseInt(event.substring("Guard #".length()));
            } else if (event.equals("falls asleep")) {
                eventType = EventType.SLEEP;
            } else if (event.equals("wakes up")) {
                eventType = EventType.WAKE;
            } else {
                throw new IllegalStateException();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return input;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Date getDate() {
        return date;
    }

    public int getGuardId() {
        return guardId;
    }

    @Override
    public int compareTo(ParsedInput other) {
        return date.compareTo(other.date);
    }
}
