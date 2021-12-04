package com.cw.aoc.d2;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day2Part2Test {
    private Day2Part2 day2Part2;

    @Before
    public void setUp() {
        day2Part2 = new Day2Part2();
    }

    @Test
    public void testWithTestData() throws IOException {
        Solver.run(day2Part2, "d2/testdata.txt");
        Position position = day2Part2.solve();
        assertEquals(900, position.getProduct());
    }

    @Test
    public void testSolution() throws IOException {
        Solver.run(day2Part2, "d2/input.txt");
        Position position = day2Part2.solve();
        assertEquals(1620141160, position.getProduct());
    }
}
