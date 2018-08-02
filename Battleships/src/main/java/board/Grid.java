package board;

import java.io.*;
import java.util.*;

/**
 * This class creates a grid (10 x 10 squares) for the battleship game.
 * The grid contains a hundred squares and each square has its own unique number
 * between 1 to 100.
 * The x-axis of the grid contains letters A to J, the y-axis has
 * numbers 1 to 10.
 * <p>
 * <img src="./doc-files/Grid-1.png" alt="Empty grid">
 * @author     Minja Malovic
 * @author     Ivan Uglik
 * @version    1.0 - 02.08.2018
 * @since      1.0
 */
public class Grid
{
    private String[] xAxis = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private int[] yAxis = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private HashMap<Integer, Square> grid = new HashMap<>();

    /**
     * The constructor creates an empty grid in form
     * of a HashMap where the keys are unique numbers (1 to 100) and values
     * are Square objects.
     */
    public Grid()
    {
        createGrid();
    }

    private void createGrid()
    {
        int counter = 0;
        for (int i = 0; i < this.xAxis.length; i++)
        {
            for (int j = 0; j < this.yAxis.length; j++)
            {
                counter++;
                this.grid.put(counter, new Square(this.xAxis[i], this.yAxis[j]));
            }
        }
    }

    /**
     * This method draws a simple grid for the command line using <code>System.out.print</code>.
     */
    public void drawGrid()
    {
        drawGridHeader();
        int counter = 0;
        int row = 0;
        for (Map.Entry squareAttr : this.grid.entrySet())
        {
            if (counter >= 9)
            {
                System.out.println("| |");
                counter = 0;
                row++;
            }
            else
            {
                if (counter == 0)
                {
                    if (this.yAxis[row] < 10)
                    {
                        System.out.print(this.yAxis[row] + " | ");
                    }
                    else
                    {
                        System.out.print(this.yAxis[row] + "| ");
                    }
                }
                else
                {
                    System.out.print("| ");
                }
                counter++;
            }
        }
    }

    private void drawGridHeader()
    {
        String header = "  ";
        String headerLine = "";
        for (String column : this.xAxis)
        {
            header = header + "|" + column ;
            headerLine = headerLine + "+—";

            if (this.xAxis[this.xAxis.length-1] == column)
            {
                header = header + "|" ;
                headerLine = headerLine + "+—+";
            }
        }
        System.out.println(header);
        System.out.println(headerLine);
    }

    /**
     * Returns the grids x-axis.
     *
     * @return <code>["A", "B", "C", ...]</code>
     */
    public String[] getxAxis()
    {
        return this.xAxis;
    }

    /**
     * Returns the grids y-axis.
     *
     * @return <code>[1, 2, 3, ...]</code>
     */
    public int[] getyAxis()
    {
        return this.yAxis;
    }

    /**
     * Returns the grid.
     *
     * @return <code>{ 1: {xAxis: "A", yAxis: 1, ...}, 2: {xAxis: "B", yAxis: 1, ...} ...}</code>
     */
    public HashMap<Integer, Square> getGrid()
    {
        return this.grid;
    }

    @Override
    public String toString()
    {
        return "Grid{" +
                "xAxis=" + Arrays.toString(this.xAxis) +
                ", yAxis=" + Arrays.toString(this.yAxis) +
                ", grid=" + this.grid +
                "}";
    }
}
