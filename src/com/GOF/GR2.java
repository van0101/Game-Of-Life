//package com.GOF;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class GR2 {
//    private BoardCreation boardCreation;
//    private HashMap<Integer, int[]> Record;
//
//    void chkRule(BoardCreation boardCreation)
//    {
//        this.boardCreation = boardCreation;
//        this.Record = boardCreation.getRecord();
//
//        chkcellStatus();
//    }
//
//    void chkcellStatus()
//    {
//        int[][] board = boardCreation.b.getBoard();
//        int x_y[] = new int[2];
//        int size = boardCreation.getGRID_SIZE();
//
//        //HashMap <Integer,int[]> cases = new HashMap<>();
//
//        for (Map.Entry<Integer, int[]> cell : Record.entrySet())
//        {
//            System.out.println("Key = " + cell.getKey() + ", Value = " + cell.getValue());
//
//            x_y = cell.getValue();
//
//            int x = x_y[0];
//            int y = x_y[1];
//
//
//            // Inner Board
//            if(x >= 1 && x < size - 1 && y >= 1 && y < size - 1)
//            {
//                // 4 neighbours
//                int sum = board[x + 1][y] + board[x - 1][y] + board[x][y + 1] + board[x][y - 1];
//
//                if(sum < 2 || sum > 3)
//                {
//                    // Dead
//                    board[x][y] = 0;
//                }
//            }
//            int sum = 0;
//
//            // Outer Edge 1
//            if(x >= 1 && x < size - 1)
//            {
//
//                // 3 neighbours top horizontal row
//                if(y == 0)
//                    sum = board[x][y + 1] + board[x + 1][y] + board[x - 1][y];
//                // 3 neighbours bottom horizontal row
//                else if(y == size - 1)
//                    sum = board[x + 1][y] + board[x - 1][y] + board[x][y - 1];
//
//                if(sum < 2 || sum > 3)
//                {
//                    // Dead
//                    board[x][y] = 0;
//                }
//            }
//            // Outer Edge 2
//            if( y >= 1 && y < size - 1)
//            {
//                // 3 neighbours left vertical row
//                if(x == 0)
//                    sum = board[x][y + 1] + board[x][y - 1] + board[x + 1][y];
//                // 3 neighbours right vertical row
//                else if(x == size - 1)
//                    sum = board[x][y + 1] + board[x][y - 1] + board[x - 1][y];
//
//                if(sum < 2 || sum > 3)
//                {
//                    // Dead
//                    board[x][y] = 0;
//                }
//
//                // REPRODUCTION ADD HERE
//
//            }
//
//
//
//
//        }
//
//
//    }
//}