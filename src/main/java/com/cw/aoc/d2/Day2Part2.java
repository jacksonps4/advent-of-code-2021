package com.cw.aoc.d2;

import com.cw.aoc.common.Solver;

import java.util.StringTokenizer;

public class Day2Part2 implements Solver<Position> {
    private Position position;

    public Day2Part2() {
        position = new Position();
    }

    @Override
    public void update(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String command = st.nextToken();
        String value = st.nextToken();
        long movement = Long.parseLong(value);

        Part2Pilot part2Pilot = new Part2Pilot();
        position = part2Pilot.move(position, command, movement);
    }

    @Override
    public Position solve() {
        return position;
    }
}
