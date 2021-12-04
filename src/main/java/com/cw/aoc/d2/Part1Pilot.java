package com.cw.aoc.d2;

public class Part1Pilot implements Pilot {
    @Override
    public Position move(Position start, String command, long amount) {
        switch (command) {
            case "forward":
                return new Position(start.getLocation() + amount, start.getDepth());
            case "down":
                return new Position(start.getLocation(), start.getDepth() + amount);
            case "up":
                return new Position(start.getLocation(), start.getDepth() - amount);
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}
