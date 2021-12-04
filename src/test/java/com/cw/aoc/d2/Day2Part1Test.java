package com.cw.aoc.d2;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day2Part1Test {
    private Day2Part1 day2Part1;

    @Before
    public void setUp() {
        day2Part1 = new Day2Part1();
    }

    @Test
    public void testWithTestData() throws IOException {
        Solver.run(day2Part1, "d2/testdata.txt");
        Position position = day2Part1.solve();
        assertEquals(150, position.getProduct());
    }

    @Test
    public void testSolution() throws IOException {
        Solver.run(day2Part1, "d2/input.txt");
        Position position = day2Part1.solve();
        assertEquals(1451208, position.getProduct());
    }
}
