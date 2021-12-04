package com.cw.aoc.d4;

import com.cw.aoc.common.Solver;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Day4Part1 implements Solver<BingoCard> {
    final List<Integer> numbers = new LinkedList<>();
    final List<BingoCard> cards = new LinkedList<>();
    private List<int[]> nextBoard = new LinkedList<>();

    @Override
    public void update(String input) {
        if (numbers.size() == 0) {
            StringTokenizer st = new StringTokenizer(input, ",");
            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                numbers.add(number);
            }
            return;
        }

        StringTokenizer st = new StringTokenizer(input);
        int[] r = new int[5];
        int i = 0;
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            r[i++] = number;
        }
        nextBoard.add(r);

        if (nextBoard.size() == 5) {
            cards.add(new BingoCard(convertToIntArray(nextBoard)));
            nextBoard = new LinkedList<>();
        }
    }

    private int[][] convertToIntArray(List<int[]> board) {
        int[][] b = new int[board.size()][];
        for (int i = 0; i < board.size(); i++) {
            b[i] = board.get(i);
        }
        return b;
    }

    @Override
    public BingoCard solve() {
        for (Integer number : numbers) {
            for (BingoCard card : cards) {
                card.numberCalled(number);
                if (card.isWinner()) {
                    return card;
                }
            }
        }
        return null;
    }
}
