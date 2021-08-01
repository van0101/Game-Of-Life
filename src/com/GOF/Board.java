package com.GOF;

class Board
{
    private int[][] board;

    public Board(int size)
    {
        board = new int[size][size];
    }

    int[][] getBoard()
    {
        return board;
    }
    void setBoard(int[][] board)
    {
        this.board = board;
    }
}
