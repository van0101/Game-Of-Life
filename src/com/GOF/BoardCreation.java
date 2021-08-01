package com.GOF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardCreation
{
    private final int GRID_SIZE = 5;
    private int[][] board;
    private int[][] pre_board;
    private int cells = 15;
    private int round_cells;

    Board b;
    Board b2;
    Points points;

    private HashMap<Integer, int[]> Cell_Location = new HashMap<>();

    public BoardCreation()
    {
        b = new Board(GRID_SIZE);
        b2 = new Board(GRID_SIZE);
        points = new Points();
    }
    //private ArrayList<int[]> Record = new ArrayList<>();

    void init()
    {
        board = b.getBoard();
        pre_board = b2.getBoard();
        Cell_Location = initMap(GRID_SIZE);
        setCells(15);
        points.setPoint(0);
        points.setCells_generated(0);
        points.setCells_died(0);
    }

    // Add values to the board
    void makeBoard(int cell_location_x,int cell_location_y)
    {
        board[cell_location_x][cell_location_y] = 1;
        pre_board[cell_location_x][cell_location_y] = 1;

        points.setPoint(points.getPoint() + 1);

    }

    //---------------------------------------------------------------------------------------------------------------------
    void setBoardState()
    {
        b2.setBoard(b.getBoard());
    }
    void setInitialBoard(BoardCreation boardCreation)
    {
        boardCreation.b2.setBoard(boardCreation.b.getBoard());
    }
    // To map numbers(1 - 25) to grid locations
    int[] getCell_Location(int cell_number)
    {
        if(cell_number > 25 || cell_number <= 0)
        {
            System.out.println("Invalid Entry");
            System.exit(0);
        }

        // Use the generated HashMap
        return Cell_Location.get(cell_number);
    }
    // Map number for user to the array locations or the grid locations
    HashMap<Integer,int[]> initMap(int grid_size)
    {
        HashMap<Integer,int[]>Cell_Number = new HashMap<>();
        int num = 1;
        int [] x_y ;

        for(int i = 0;i < grid_size;i++)
        {
            for(int j = 0;j < grid_size;j++)
            {
                x_y = new int[2];
                x_y[0] = i;// x
                x_y[1] = j;// y

                Cell_Number.put(num,x_y);
                num++;
            }
        }
        return Cell_Number;
    }
    // Getter to end record

    int getGRID_SIZE()
    {
        return GRID_SIZE;
    }
    int getCells()
    {
        return cells;
    }
    void setCells(int cells)
    {
        this.cells = cells;
    }
    void setRound_cells(int round_cells)
    {
        this.round_cells = round_cells;
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------


    // To Display rules.
    void ruleDisplay()
    {
        System.out.println("Enter numbers from 1 to 25 for grid locations");
        int x = 1;
        for(int i = 0;i < GRID_SIZE;i++)
        {
            for(int j = 0;j < GRID_SIZE;j++)
            {
                System.out.print(x+"\t");
                x++;
            }
            System.out.println();

        }
    }
    // To Display Board
    void boardDisplay()
    {
        int x = 1;
        for(int i = 0;i < GRID_SIZE;i++)
        {
            for(int j= 0;j < GRID_SIZE;j++)
            {
                System.out.print(board[i][j]+"\t");
            }

            System.out.print("\t");

            for(int k = 0;k < GRID_SIZE;k++)
            {
                System.out.print(x + "\t");
                x++;
            }
            System.out.println();
        }
        System.out.print(points.getCells_died() + " Cells Died \t" + points.getCells_generated() + " Cells Generated\t" + round_cells +" Generated in this round\n");

    }
    void displayPoints()
    {
        System.out.println("\t------Your Score------");
        System.out.println("\n->Total Generated cells: " + points.getCells_generated());
        System.out.println("->Total Cells Died: " + points.getCells_died());
        System.out.println("->Final Points: " + points.getPoint());
    }

}

