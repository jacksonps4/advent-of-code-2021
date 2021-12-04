package com.cw.aoc.d4;

import com.cw.aoc.common.Solver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Day4Part1Test {
    private Day4Part1 day4Part1;

    @Before
    public void setUp() {
        day4Part1 = new Day4Part1();
    }

    @Test
    public void testWithTestData() throws IOException {
        BingoCard card = Solver.run(day4Part1, "d4/testdata.txt");
        assertEquals(4512, card.getScore());
    }

    @Test
    public void testSolution() throws IOException {
        BingoCard card = Solver.run(day4Part1, "d4/input.txt");
        assertEquals(39984, card.getScore());
    }
}
