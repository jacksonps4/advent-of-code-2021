package com.cw.aoc.d2;

public class Position {
    private final long location;
    private final long depth;
    private final long aim;

    public Position() {
        this.location = 0;
        this.depth = 0;
        this.aim = 0;
    }

    public Position(long location, long depth) {
        this.location = location;
        this.depth = depth;
        this.aim = 0;
    }

    public Position(long location, long depth, long aim) {
        this.location = location;
        this.depth = depth;
        this.aim = aim;
    }

    public long getLocation() {
        return location;
    }

    public long getDepth() {
        return depth;
    }

    public long getAim() {
        return aim;
    }

    public long getProduct() {
        return location * depth;
    }

    @Override
    public String toString() {
        return "Position{" +
                "location=" + location +
                ", depth=" + depth +
                "}; product = " + getProduct();
    }
}
