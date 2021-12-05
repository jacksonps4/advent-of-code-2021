package com.cw.aoc.d5;

public class Day5Part2 extends Day5Part1 {
    @Override
    public void update(String input) {
        String[] points = input.split("->");

        Point from = getPoint(points[0]);
        Point to = getPoint(points[1]);

        diagram.addLine(new Vector(from, to), true);
    }
}
