package com.cw.aoc.d5;

public class Diagram {
    private int[][] map;
    private int maxX;
    private int maxY;

    public Diagram() {
        this.map = new int[1000][];

        // initialise the square array with zeroes
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                map[i] = new int[map.length];
            }
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
    }

    public void addLine(Vector line) {
        addLine(line, false);
    }

    public void addLine(Vector line, boolean allowDiagonals) {
        Point from = line.getFrom();
        Point to = line.getTo();

        if (!(from.getX() == to.getX() || from.getY() == to.getY())) {
            // ignore lines that are not horizontal or vertical
            if (!allowDiagonals) {
                return;
            }
        }
        updateMinMax(from, to);

        int x = from.getX();
        int y = from.getY();
        while (true) {
            map[y][x]++;
            if (line.getDeltaY() > 0) {
                y++;
                if (y > to.getY()) {
                    break;
                }
            } else if (line.getDeltaY() < 0) {
                y--;
                if (y < to.getY()) {
                    break;
                }
            }

            if (line.getDeltaX() > 0) {
                x++;
                if (x > to.getX()) {
                    break;
                }
            } else if (line.getDeltaX() < 0) {
                x--;
                if (x < to.getX()) {
                    break;
                }
            }
        }
    }

    private void updateMinMax(Point from, Point to) {
        if (from.getX() > maxX) {
            maxX = from.getX();
        }
        if (to.getX() > maxX) {
            maxX = to.getX();
        }
        if (from.getY() > maxY) {
            maxY = from.getY();
        }
        if (to.getY() > maxY) {
            maxY = to.getY();
        }
    }

    public long getCount() {
        long count = 0L;
        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {
                if (map[x][y] > 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        StringBuilder mv = new StringBuilder();
        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {
                int val = map[x][y];
                if (val > 0) {
                    mv.append(val);
                } else {
                    mv.append(".");
                }
            }
            mv.append("\n");
        }
        mv.append(String.format("Count = %d\n", getCount()));
        return mv.toString();
    }
}
