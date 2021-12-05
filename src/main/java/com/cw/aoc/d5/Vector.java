package com.cw.aoc.d5;

public class Vector {
    private final Point from;
    private final Point to;

    public Vector(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public int getDeltaX() {
        return to.getX() - from.getX();
    }

    public int getDeltaY() {
        return to.getY() - from.getY();
    }

    public double getBearing() {
        int deltaY = getDeltaX();
        int deltaX = getDeltaY();
        double tanTheta = deltaY / deltaX;
        return Math.atan(tanTheta);
    }
}
