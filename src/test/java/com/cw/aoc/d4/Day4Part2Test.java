package com.cw.aoc.d4;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day4Part2Test {
    private Day4Part2 day4Part2;

    @Before
    public void setUp() {
        day4Part2 = new Day4Part2();
    }

    @Test
    public void testWithTestData() throws IOException {
        BingoCard card = Solver.run(day4Part2, "d4/testdata.txt");
        assertEquals(1924, card.getScore());
    }

    @Test
    public void testSolution() throws IOException {
        BingoCard card = Solver.run(day4Part2, "d4/input.txt");
        assertEquals(8468, card.getScore());
    }
}
