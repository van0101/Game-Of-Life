package com.GOF;

import java.io.IOException;
import java.util.Scanner;

class GameFlow
{
    GameRule gameRule = new GameRule();
    // Initial Stage one
    // User has to enter 3 cell location
    BoardCreation getValue(BoardCreation boardCreation,int chances)
    {

        Scanner sc = new Scanner(System.in);

        // Store the x y coordinates
        // x_y[0] -> x
        // x_y[1] -> y

        int[] x_y;

        // Update values entered by the user on the board
        for(int i = 0;i < chances;i++)
        {
            int cell = sc.nextInt();

            x_y = boardCreation.getCell_Location(cell);
            boardCreation.makeBoard(x_y[0],x_y[1]);
        }

        System.out.println("--------------------------------------------------------------");
        boardCreation.boardDisplay();
        System.out.println("--------------------------------------------------------------");

        gameRule.chkRule(boardCreation);

        System.out.println("***************************************************************");
        boardCreation.boardDisplay();
        System.out.println("***************************************************************");

        return boardCreation;
    }

    void beginGame(BoardCreation boardCreation,int move)
    {


        // User will have only a few chances to cover maximum cells before the cells die
        int cells = boardCreation.getCells();

        while(cells >= 0)
        {
            System.out.println("Cells Left: " + cells);

            boardCreation = getValue(boardCreation,move);

            boardCreation.setBoardState();

            boardCreation.setCells(boardCreation.getCells() - move);
            cells = boardCreation.getCells();

            move = 2;
        }

        gameRule.chkRule(boardCreation);
        System.out.println("Cells Left: " + cells);

        boardCreation.boardDisplay();
    }
}
