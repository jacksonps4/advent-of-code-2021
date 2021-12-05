package com.cw.aoc.d5;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day5Part2Test {
    private Day5Part2 day5Part2;

    @Before
    public void setUp() {
        day5Part2 = new Day5Part2();
    }

    @Test
    public void testWithTestData() throws IOException {
        Diagram diagram = Solver.run(day5Part2, "d5/testdata.txt");
        System.out.println(diagram);
        assertEquals(12, diagram.getCount());
    }

    @Test
    public void testSolution() throws IOException {
        Diagram diagram = Solver.run(day5Part2, "d5/input.txt");
        assertEquals(21466L, diagram.getCount());
    }
}
