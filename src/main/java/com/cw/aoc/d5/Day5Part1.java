package com.cw.aoc.d5;

import com.cw.aoc.common.Solver;

public class Day5Part1 implements Solver<Diagram> {
    final Diagram diagram = new Diagram();

    @Override
    public void update(String input) {
        String[] points = input.split("->");

        Point from = getPoint(points[0]);
        Point to = getPoint(points[1]);

        diagram.addLine(new Vector(from, to));
    }

    Point getPoint(String point) {
        String xVal = point.trim();
        int x1 = Integer.parseInt(xVal.split(",")[0]);
        int x2 = Integer.parseInt(xVal.split(",")[1]);
        return new Point(x1, x2);
    }

    @Override
    public Diagram solve() {
        return diagram;
    }
}
