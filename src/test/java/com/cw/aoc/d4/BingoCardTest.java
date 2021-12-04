package com.cw.aoc.d4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BingoCardTest {
    private BingoCard bingoCard;

    @Before
    public void setUp() {
        bingoCard = new BingoCard(new int[][]{
                { 22, 13, 17, 11, 0 },
                { 8, 2, 23, 4, 24 },
                { 21, 9, 14, 16, 7 },
                { 6, 10, 3, 18, 5 },
                { 1, 12, 20, 15, 19 }
        });
    }

    @Test
    public void testLine1Winner() {
        bingoCard.numberCalled(22);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(13);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(17);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(11);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(0);
        assertTrue(bingoCard.isWinner());
    }

    @Test
    public void testColumn1Winner() {
        bingoCard.numberCalled(22);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(8);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(21);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(6);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(1);
        assertTrue(bingoCard.isWinner());
    }

    @Test
    public void testLine2Winner() {
        bingoCard.numberCalled(8);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(2);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(23);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(4);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(24);
        assertTrue(bingoCard.isWinner());
    }

    @Test
    public void testColumn2Winner() {
        bingoCard.numberCalled(13);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(2);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(9);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(10);
        assertFalse(bingoCard.isWinner());
        bingoCard.numberCalled(12);
        assertTrue(bingoCard.isWinner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        BingoCard b = new BingoCard(new int[][]{
                { 3, 3, 3 },
                { 2, 2, 2 },
        });
    }
}
