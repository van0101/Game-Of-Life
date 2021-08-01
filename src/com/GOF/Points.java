package com.GOF;

import java.util.ArrayList;

public class Points
{
    // Final points based number of cells alive finally and number of alive streaks

    private int point = 0;
    private int cells_generated = 0;
    private int cells_died = 0;
    int round_cells = 0;

    public int getCells_died() {
        return cells_died;
    }
    public void setCells_died(int cells_died) {
        this.cells_died = cells_died;
    }


    int getPoint()
    {
        return cells_generated - cells_died;
    }
    void setPoint(int point)
    {
        this.point = point;
    }


    public int getCells_generated() {
        return cells_generated;
    }
    public void setCells_generated(int cells_generated) {
        this.cells_generated = cells_generated;
    }
}
