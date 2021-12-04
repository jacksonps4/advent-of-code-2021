package com.cw.aoc.d1;

import com.cw.aoc.common.Solver;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day1Part1Test {
    @Test
    public void testWithTestData() throws IOException {
        Day1Part1 puzzle1Part1 = new Day1Part1();
        Solver.run(puzzle1Part1, "d1/testdata1.txt");
        assertEquals(Long.valueOf(7), puzzle1Part1.solve());
    }

    @Test
    public void testSolution() throws IOException {
        Day1Part1 puzzle1Part1 = new Day1Part1();
        Solver.run(puzzle1Part1, "d1/input1.txt");
        assertEquals(Long.valueOf(1665), puzzle1Part1.solve());
    }
}
