package com.GOF;

import java.util.HashMap;
import java.util.Map;

public class Try
{
    private HashMap<Integer, int[]> Cell_Number;
    public static void main(String args[])
    {
        Try o = new Try();
//        o.Cell_Number = new HashMap<>();
//        o.func();
//        o.chkMap();
        o.counter();
    }

    private static final String emo = "\uD83D\uDE02";
    void counter()
    {
        System.out.println("emoji : "+ emo);
        System.out.println("\uD83D\uDE00");
    }
    void func()
    {
        int num = 1;
        int [] x_y ;
        int grid_size = 5;

        for(int i = 0;i < grid_size;i++)
        {



            for(int j = 0;j < grid_size;j++)
            {
                x_y = new int[2];
                x_y[0] = i;// x
                x_y[1] = j;// y
                System.out.println(x_y[0]);
                System.out.print(x_y[1]);
                Cell_Number.put(num,x_y);
                num++;
            }
            System.out.println();
        }
    }
    void chkMap()
    {
        for (Map.Entry<Integer,int[]> entry : Cell_Number.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue()[0] + " " + entry.getValue()[1]);

    }
}
