// Checks GOL rules
// After every move the board is parsed and a reward(cell generation) is calculated.
package com.GOF;

import java.util.ArrayList;

public class GameRule
{
    private BoardCreation boardCreation;
    private Points points;
    private ArrayList<int[]> Record;


    void chkRule(BoardCreation boardCreation)
    {

        this.boardCreation = boardCreation;
        this.points = boardCreation.points;
        points.round_cells = 0;
        //int board[][] = boardCreation.b2.getBoard();

        cellStatus(0);
        cellStatus(1);
        boardCreation.setRound_cells(points.round_cells);
        //boardCreation.b.setBoard(board);
    }

    void cellStatus(int cell_value)
    {
        int[][] board = boardCreation.b.getBoard();


        int size = boardCreation.getGRID_SIZE();
        int sum = 0;


        for(int i = 0;i < size;i++)
        {
            for(int j = 0;j < size;j++)
            {
                if(board[i][j] == cell_value)
                {
                    sum = getSum(boardCreation,i,j);
                    boolean status = cellCondition(board[i][j],sum);

                    if(status && cell_value == 0)
                    {
                        // New Cell
                        //System.out.println("p "+ points.getPoint() + (boardCreation.getCells() + 1));
                        board[i][j] = 1;
                        boardCreation.setCells(boardCreation.getCells() + 1);
                        points.setCells_generated(points.getCells_generated() + 1);
                        points.round_cells++;
                        //System.out.println("Cell Regenerated!");
                    }
                    else if(status && cell_value == 1)
                    {
                        // Alive
                        board[i][j] = 1;
                    }
                    else
                    {
                        // Dead
                        board[i][j] = 0;
                    }
                }
            }
        }

    }
    boolean cellCondition(int cell_value,int sum)
    {
        // Dead Cell
        if(cell_value == 0)
        {
            // Alive
            //System.out.println("sum : "+sum);
            return sum == 3;
        }
        // Alive Cell
        else
        {
           // Dead
            if(sum >= 4 || sum < 2)
            {
                boardCreation.setCells(boardCreation.getCells() - 1);
                boardCreation.points.setCells_died(boardCreation.points.getCells_died() + 1);
                //System.out.println("Cell Died ");
            }

           return !(sum >= 4 || sum < 2);
        }

    }

    int getSum(BoardCreation boardCreation,int x,int y)
    {

        // Using previous state
        // Add new states to the present board b
        int[][] board = boardCreation.b2.getBoard();
        int size = boardCreation.getGRID_SIZE();
        int sum = 0;

        //System.out.println(" Co ordinates = "+ x +","+y);


        // Inner Board
        if (x >= 1 && x < size - 1 && y >= 1 && y < size - 1)
        {
            // 8 neighbours
            sum = board[x + 1][y] + board[x - 1][y] + board[x][y + 1] + board[x][y - 1] + board[x - 1][y - 1] + board[x + 1][y - 1]
            + board[x + 1][y + 1] + board[x - 1][y + 1];

        }
        // Outer Edge 1
        else if (x >= 1 && x < size - 1)
        {

            // 5 neighbours top horizontal row
            if (y == 0)
                sum = board[x][y + 1] + board[x + 1][y] + board[x - 1][y] + board[x - 1][y + 1] + board[x + 1][y + 1];
            // 5 neighbours bottom horizontal row
            else if (y == size - 1)
                sum = board[x + 1][y] + board[x - 1][y] + board[x][y - 1] + board[x - 1][y - 1] + board[x + 1][y - 1];

        }
        // Outer Edge 2
        else if (y >= 1 && y < size - 1)
        {
            // 5 neighbours left vertical row
            if (x == 0)
                sum = board[x][y + 1] + board[x][y - 1] + board[x + 1][y] + board[x + 1][y - 1] + board[x + 1][y + 1];
            // 5 neighbours right vertical row
            else if (x == size - 1)
                sum = board[x][y + 1] + board[x][y - 1] + board[x - 1][y] + board[x - 1][y + 1] + board[x - 1][y - 1];
        }

        // The 4 Corners
        // top left 1
        // 3 neighbours
        else if (x == 0 && y == 0)
        {
            sum = board[x + 1][y] + board[x][y + 1] + board[x + 1][y + 1];
        }
        // top right 2
        else if (x == size - 1 && y == 0)
        {
            sum = board[x - 1][y] + board[x][y + 1] + board[x - 1][y + 1];
        }
        // bottom right 3
        else if (x == size - 1 && y == size - 1)
        {
            sum = board[x - 1][y] + board[x][y - 1] + board[x - 1][y - 1];
        }
        // bottom left 4
        else if (x == 0 && y == size - 1)
        {
            sum = board[x][y - 1] + board[x + 1][y] + board[x + 1][y - 1];
        }

        return sum;
    }
}

