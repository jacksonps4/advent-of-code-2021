package com.cw.aoc.d1;

import com.cw.aoc.common.Solver;

public class Day1Part1 implements Solver<Long> {
    private int previous = Integer.MIN_VALUE;
    private long count = 0;

    @Override
    public void update(String input) {
        int value = Integer.parseInt(input);
        if (previous > Integer.MIN_VALUE && value > previous) {
            count++;
        }
        previous = value;
    }

    public Long solve() {
        return count;
    }
}
