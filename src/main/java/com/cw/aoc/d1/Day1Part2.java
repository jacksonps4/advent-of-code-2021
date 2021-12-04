package com.cw.aoc.d1;

import com.cw.aoc.common.Solver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day1Part2 implements Solver<Long> {
    private int count = 0;
    private long increases = 0;
    private int lastSwSum = -1;
    private int[] slidingWindow = new int[3];

    @Override
    public void update(String input) {
        int value = Integer.parseInt(input);
        updateSlidingWindow(slidingWindow, value);
        count++;
        if (count < 3) {
            return;
        }
        int swSum = Arrays.stream(slidingWindow)
                .sum();
        if (lastSwSum > -1 && swSum > lastSwSum) {
            increases++;
        }
        lastSwSum = swSum;
    }

    public Long solve() {
        return increases;
    }

    static void updateSlidingWindow(int[] sw, int lineVal) {
        sw[0] = sw[1];
        sw[1] = sw[2];
        sw[2] = lineVal;
    }
}
