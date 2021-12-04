package com.cw.aoc.d4;

import java.util.Iterator;

public class Day4Part2 extends Day4Part1 {
    @Override
    public BingoCard solve() {
        BingoCard lastWinner = null;
        for (Integer number : numbers) {
            for (Iterator<BingoCard> itr = cards.iterator(); itr.hasNext(); ) {
                BingoCard card = itr.next();
                card.numberCalled(number);
                if (card.isWinner()) {
                    lastWinner = card;
                    itr.remove();
                }
            }
        }
        return lastWinner;
    }
}
