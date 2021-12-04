package com.cw.aoc.d2;

public class Part2Pilot implements Pilot {
    @Override
    public Position move(Position start, String command, long amount) {
        switch (command) {
            case "forward":
                return new Position(start.getLocation() + amount,
                        start.getDepth() + (start.getAim() * amount),
                        start.getAim());
            case "down":
                return new Position(start.getLocation(), start.getDepth(),
                        start.getAim() + amount);
            case "up":
                return new Position(start.getLocation(), start.getDepth(),
                        start.getAim() - amount);
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}
