package com.cw.aoc.d1;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.cw.aoc.d1.Day1Part2.updateSlidingWindow;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Day1Part2Test {
    private Day1Part2 puzzle1Part2;

    @Before
    public void setUp() {
        puzzle1Part2 = new Day1Part2();
    }

    @Test
    public void testUpdateSlidingWindow() {
        int[] before = new int[] { 3, 5, 7 };
        updateSlidingWindow(before, 9);
        assertArrayEquals(new int[] { 5, 7, 9 }, before);
    }

    @Test
    public void testWithTestData() throws IOException {
        puzzle1Part2 = new Day1Part2();
        Solver.run(puzzle1Part2, "d1/testdata1.txt");
        assertEquals(Long.valueOf(5), puzzle1Part2.solve());
    }

    @Test
    public void testSolution() throws IOException {
        puzzle1Part2 = new Day1Part2();
        Solver.run(puzzle1Part2, "d1/input1.txt");
        assertEquals(Long.valueOf(1702), puzzle1Part2.solve());
    }
}
