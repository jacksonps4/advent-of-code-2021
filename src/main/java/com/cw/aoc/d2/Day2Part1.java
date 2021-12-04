package com.cw.aoc.d2;

import com.cw.aoc.common.Solver;

import java.util.StringTokenizer;

public class Day2Part1 implements Solver<Position> {
    private Position position;

    public Day2Part1() {
        position = new Position();
    }

    @Override
    public void update(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String command = st.nextToken();
        String value = st.nextToken();
        long movement = Long.parseLong(value);

        Part1Pilot pilot = new Part1Pilot();
        position = pilot.move(position, command, movement);
    }

    @Override
    public Position solve() {
        return position;
    }
}
