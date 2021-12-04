package com.cw.aoc.d3;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Day3Part2Test {
    private Day3Part2 day3Part2;

    @Before
    public void setUp() throws IOException {
        day3Part2 = new Day3Part2();
        Solver.run(day3Part2, "d3/testdata.txt");
    }

    @Test
    public void testLifeSupportRatingWithTestData() {
        assertEquals(230L, day3Part2.solve().getLifeSupportRating());
    }

    @Test
    public void testSolution() throws IOException {
        day3Part2 = new Day3Part2();
        DiagnosticReport report = Solver.run(day3Part2, "d3/input.txt");
        assertEquals(7041258L, report.getLifeSupportRating());
    }
}
