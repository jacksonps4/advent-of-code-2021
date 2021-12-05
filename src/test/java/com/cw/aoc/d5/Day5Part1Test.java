package com.cw.aoc.d5;

import com.cw.aoc.common.Solver;
import com.cw.aoc.d4.BingoCard;
import com.cw.aoc.d4.Day4Part1;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day5Part1Test {
    private Day5Part1 day5Part1;

    @Before
    public void setUp() {
        day5Part1 = new Day5Part1();
    }

    @Test
    public void testWithTestData() throws IOException {
        Diagram diagram = Solver.run(day5Part1, "d5/testdata.txt");
        System.out.println(diagram);
        assertEquals(5, diagram.getCount());
    }

    @Test
    public void testSolution() throws IOException {
        Diagram diagram = Solver.run(day5Part1, "d5/input.txt");
        assertEquals(6572, diagram.getCount());
    }
}
