package com.cw.aoc.d3;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Day3Part1Test {
    private Day3Part1 day3Part1;

    @Before
    public void setUp() throws IOException {
        day3Part1 = new Day3Part1();
        Solver.run(day3Part1, "d3/testdata.txt");
    }

    @Test
    public void testCalculateCounts() {
        assertArrayEquals(new Integer[] { 7, 5, 8, 7, 5 }, day3Part1.calculateCounts(day3Part1.reportData));
    }

    @Test
    public void testCalculateGammaRate() {
        assertEquals(22L, day3Part1.calculateGammaRate(new Integer[] {7, 5, 8, 7, 5}, day3Part1.reportData.size()));
    }

    @Test
    public void testPowerConsumptionWithTestData() {
        assertEquals(198L, day3Part1.solve().getPowerConsumption());
    }

    @Test
    public void testSolution() throws IOException {
        day3Part1 = new Day3Part2();
        DiagnosticReport report = Solver.run(day3Part1, "d3/input.txt");
        assertEquals(2967914L, report.getPowerConsumption());
    }
}
