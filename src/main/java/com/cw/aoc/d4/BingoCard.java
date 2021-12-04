package com.cw.aoc.d4;

import java.util.Arrays;

public class BingoCard {
    private final int[][] board;
    private final boolean[][] marked;
    private int lastNumberCalled;

    public BingoCard(int[][] board) {
        // ensure it is a square array
        for (int[] row : board) {
            if (row.length != board.length) {
                throw new IllegalArgumentException("Boards must be square");
            }
        }

        this.board = board;
        this.marked = new boolean[board.length][board[0].length];
    }

    public void numberCalled(int number) {
        lastNumberCalled = number;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int boardNumber = board[i][j];
                if (boardNumber == number) {
                    marked[i][j] = true;
                }
            }
        }
    }

    public boolean isWinner() {
        for (int i = 0; i < board.length; i++) {
            boolean rowWinner = true;
            for (int j = 0; j < board[i].length; j++) {
                rowWinner &= marked[i][j];
            }
            if (rowWinner) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            boolean columnWinner = true;
            for (int j = 0; j < board[i].length; j++) {
                columnWinner &= marked[j][i];
            }
            if (columnWinner) {
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!marked[i][j]) {
                    sum += board[i][j];
                }
            }
        }

        return sum * lastNumberCalled;
    }

    @Override
    public String toString() {
        return "BingoCard{" +
                "board=" + Arrays.toString(board) +
                ", marked=" + Arrays.toString(marked) +
                '}' + "; score = " + getScore();
    }
}
