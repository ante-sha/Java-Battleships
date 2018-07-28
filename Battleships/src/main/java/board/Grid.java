package board;

import java.io.*;
import java.util.*;

public class Grid {

    // Instance Variables

    private String[] xAxis = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private int[] yAxis = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private HashMap<Integer, Square> grid = new HashMap<Integer, Square>();
    // Constructor

    public Grid() {
        createGrid();
    }

    // Method
    private void createGrid() {
        int counter = 0;
        for (int i = 0; i < this.xAxis.length; i++) {

            for (int j = 0; j < this.yAxis.length; j++) {
                counter++;
                this.grid.put(counter, new Square(this.xAxis[i], this.yAxis[j]));
            }
        }
    }

    public void drawGrid() {
        drawGridHeader();
        int counter = 0;
        int row = 0;
        for (Map.Entry squareAtt : this.grid.entrySet()) {

            if (counter >= 9) {
                System.out.println("| |");
                counter = 0;
                row++;
            } else {
                if(counter == 0){
                    if(this.yAxis[row]<10){
                        System.out.print( this.yAxis[row] + " | ");
                    }else {
                        System.out.print( this.yAxis[row] + "| ");
                    }

                }else {
                    System.out.print("| ");
                }
                counter++;
            }
        }
    }

    private void drawGridHeader() {
        String header = "  ";
        String headerDelimiter = "";
        for (String headerAtt : this.xAxis) {
            header = header + "|" + headerAtt ;
            headerDelimiter = headerDelimiter + "+—";
            if(this.xAxis[this.xAxis.length-1]==headerAtt){
                header = header + "|" ;
                headerDelimiter = headerDelimiter + "+—+";
            }

        }
        System.out.println(header);
        System.out.println(headerDelimiter);

    }

    public String[] getxAxis() {
        return xAxis;
    }

    public int[] getyAxis() {
        return yAxis;
    }

    public HashMap<Integer, Square> getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "xAxis=" + Arrays.toString(xAxis) +
                ", yAxis=" + Arrays.toString(yAxis) +
                ", grid=" + grid +
                '}';
    }
}

