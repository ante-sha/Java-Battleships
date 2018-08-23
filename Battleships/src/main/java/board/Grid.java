/**
 * Copyright (c) 2018 Barrage d.o.o.
 *
 * The sole purpose of this code is to make Michael happy.
 * For everyone else it's just about discovering other tools and technologies.
 * Have fun and code!
 */

package board;

import java.io.*;
import java.util.*;

/**
 * This class creates a grid (10 x 10 squares) for the battleship game.
 *
 * <p>The grid contains a hundred squares and each square has its own unique number
 * between 1 to 100. The x-axis of the grid contains letters A to J, the y-axis has
 * numbers 1 to 10.
 * <p>
 * <img src="./doc-files/Grid-1.png" alt="Empty grid">
 *
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
     * When creating a new object the constructor creates an empty grid in form
     * of a HashMap.
     *
     * <p>The keys are unique numbers (1 to 100) and values are Square objects.
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
     * This method draws a grid on the command line (terminal).
     *
     * <p>We are using a simple <code>System.out.print</code>.
     *
     * <p>This method won't be needed when we move to a GUI.
     */
    public void drawBoatGrid()
    {
        drawGridHeader();
        for (int i=0; i<10; i++){
          if(i<9) System.out.print(" " + (i+1));
          else System.out.print(i+1);
          for(int j=0; j<10; j++){
            if(this.grid.get(i*10+j+1).getHasShip()) System.out.print(" @");
            else System.out.print("  ");

          }
          System.out.println();
        }

    }
    public void drawPlayGrid(){
      drawGridHeader();
      for (int i=0; i<10; i++){
        if(i<9) System.out.print(" " + (i+1));
        else System.out.print(i+1);
        for(int j=0; j<10; j++){
          if(this.grid.get(i*10+j+1).getWasShot() && this.grid.get(i*10+j+1).getHasShip()) System.out.print(" X");
          else if(this.grid.get(i*10+j+1).getWasShot()) System.out.print(" ~");
          else System.out.print("  ");

        }
        System.out.println();
      }
    }

    private void drawGridHeader()
    {
        String header = "  ";
        String headerLine = "";
        for (String column : this.xAxis)
        {
            header = header + " " + column ;
            // headerLine = headerLine + "+—";

            if (this.xAxis[this.xAxis.length-1] == column)
            {
                header = header + " " ;
                // headerLine = headerLine + "+—+";
            }
        }
        System.out.println(header);
        // System.out.println(headerLine);
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

    public char predictRestOfTheShip(int[] struckPoint){
      // boolean lastHitHor = true;
      // boolean lastHitVer = true;
      int north = 0;
      int east = 0;
      int south = 0;
      int west = 0;
      int i;
      int j;
      // north
      // stuckPoint - 1 is position of the hit if it is 0-based matrix
      for(i = struckPoint[0] - 2, j = struckPoint[1] - 1; i >= 0 && !(this.grid.get(i*10+j+1).getWasShot());i--) north+=3;
      for(i = struckPoint[0] , j = struckPoint[1] - 1; i < 10 && !(this.grid.get(i*10+j+1).getWasShot());i++) south+=3;
      for(i = struckPoint[0] - 1, j = struckPoint[1] - 2; j >= 0 && !(this.grid.get(i*10+j+1).getWasShot());j--) west+=3;
      for(i = struckPoint[0] - 1, j = struckPoint[1]; j < 10 && !(this.grid.get(i*10+j+1).getWasShot());j++) east+=3;

      //north - row above the stuckPoint
      if (north > 0) {
        for(i = struckPoint[0] - 2, j = struckPoint[1] - 1; j >= 0 && !(this.grid.get(i*10+j+1).getWasShot()); j--) north++;
        for(i = struckPoint[0] - 2, j = struckPoint[1]; j < 10 && !(this.grid.get(i*10+j+1).getWasShot()); j++) north++;
      }
      //south - row under the struckPoint
      if (south > 0) {
        for(i = struckPoint[0], j = struckPoint[1] - 1; j >= 0 && !(this.grid.get(i*10+j+1).getWasShot()); j--) south++;
        for(i = struckPoint[0], j = struckPoint[1]; j < 10 && !(this.grid.get(i*10+j+1).getWasShot()); j++) south++;
      }
      //west - column left of the struckPoint
      if (west > 0) {
        for(i = struckPoint[0] - 1, j = struckPoint[1] - 2; i >= 0 && !(this.grid.get(i*10+j+1).getWasShot()); i--) west++;
        for(i = struckPoint[0], j = struckPoint[1] - 2; i < 10 && !(this.grid.get(i*10+j+1).getWasShot()); i++) west++;
      }
      // east - column right of the struckPoint
      if (east > 0) {
        for(i = struckPoint[0] - 1, j = struckPoint[1]; i >= 0 && !(this.grid.get(i*10+j+1).getWasShot()); i--) east++;
        for(i = struckPoint[0], j = struckPoint[1]; i < 10 && !(this.grid.get(i*10+j+1).getWasShot()); i++) east++;
      }

      // if (north + south >= west + east){
      //   if (north >= south) return 'N';
      //   else return 'S';
      // } else {
      //   if (west >= east) return 'W';
      //   else return 'E';
      // }
      // returning maximum value
      if (north >= east && north >= south && north >= west) return 'N';
      else if (east >= south && east >= west) return 'E';
      else if (south >= west) return 'S';
      else return 'W';
    }

    public int[] calculateNextStep(int counter){
      Random rand = new Random();
      int[] multi = new int[3];
      //  we dont want to have centralised shoots in late game
      if(counter<40){
        multi[0] = 1;
        multi[1] = 1;
        multi[2] = 3;
      } else {
        multi[0] = 1;
        multi[1] = 1;
        multi[2] = 0;
      }


      int maksPrior = 0;
      int[] startIndex = {0,0};
      int[] finishIndex = {0,0};
      boolean lastHitVer = true;
      boolean lastHitHor = true;
      int[] ret = {0,0};
      int[][] priority = new int[10][10];

      // initialization of the priority matrix
      for(int i=0; i<10;i++){
        for(int j=0; j<10;j++){
          priority[i][j] = 0;
        }
      }

      // adding horizontal priorities
      for(int i=0; i < 10; i++){
        startIndex[0] = 0;
        finishIndex[0] = 0;
        lastHitHor = true;
        for(int j=0; j < 10; j++){
          // var i is in this case stands for row
          if(this.grid.get((i*10) + j + 1).getWasShot()){
            if(!lastHitHor) {
              lastHitHor = true;
              for(int k = startIndex[0]; k < finishIndex[0];k++)
                priority[i][k]+=multi[0]*(finishIndex[0]-startIndex[0]);
              finishIndex[0] = 0;
              startIndex[0] = 0;
            }
          } else {
            finishIndex[0] = j + 1;
            if(lastHitHor) startIndex[0] = j;
            lastHitHor = false;
          }
          if(j==9){
            for(int k = startIndex[0]; k < finishIndex[0];k++)
              priority[i][k]+=multi[0]*(finishIndex[0]-startIndex[0]);
          }
        }
      }
      // adding vertical priorities
      for(int i = 0; i < 10;i++){
        startIndex[1] = 0;
        finishIndex[1] = 0;
        lastHitVer = true;
        for(int j = 0; j < 10; j++){
          // vertical check
          if(this.grid.get((j*10)+i+1).getWasShot()){
            if(!lastHitVer){
              lastHitVer = true;
              for(int k=startIndex[1];k<finishIndex[1];k++)
                priority[k][i]+=multi[1]*(finishIndex[1]-startIndex[1]);
              finishIndex[1]=0;
              startIndex[1]=0;
            }
          } else {
            finishIndex[1]= j + 1;
            if(lastHitVer){
              startIndex[1] = j;
            }
            lastHitVer = false;
          }
          if(j==9){
            for(int k=startIndex[1];k<finishIndex[1];k++)
              priority[k][i]+=multi[1]*(finishIndex[1]-startIndex[1]);
          }
        }
      }
      //priorities that depends on quadrants

      int[] quadrant = new int[9];
      Arrays.fill(quadrant,0);
      for(int i = 0; i < 10; i++){
        for(int j = 0; j < 10; j++){
          if(this.grid.get((i * 10) + j + 1).getWasShot());
          else{
            if(i < 3){
              if(j < 3) quadrant[0]++;
              else if(j < 7) quadrant[1]++;
              else quadrant[2]++;
            } else if(i < 7){
              if(j < 3) quadrant[3]++;
              else if(j < 7) quadrant[4]++;
              else quadrant[5]++;
            } else {
              if(j < 3) quadrant[6]++;
              else if(j < 7) quadrant[7]++;
              else quadrant[8]++;
            }
          }
        }
      }
      for(int i=0; i < 10; i++){
        for(int j=0; j < 10; j++){
          if(this.grid.get((i * 10) + j + 1).getWasShot()){
          } else {
            if(i < 3){
              if(j < 3) priority[i][j]+=multi[2]*quadrant[0];
              else if(j < 7) priority[i][j]+=multi[2]*quadrant[1];
              else priority[i][j]+=multi[2]*quadrant[2];
            } else if(i < 7){
              if(j < 3) priority[i][j]+=multi[2]*quadrant[3];
              else if(j < 7) priority[i][j]+=multi[2]*quadrant[4];
              else priority[i][j]+=multi[2]*quadrant[5];
            } else {
              if(j < 3) priority[i][j]+=multi[2]*quadrant[6];
              else if(j < 7) priority[i][j]+=multi[2]*quadrant[7];
              else priority[i][j]+=multi[2]*quadrant[8];
            }
          }
        }
      }

      // prebrajanje prioriteta
      int i = rand.nextInt(10);
      int j = rand.nextInt(10);
      int nearByStruck;
      for(int k=0; k<10;k++,i++){
        i = i % 10;
        for(int l=0; l<10;l++,j++){
          // checking how many squares has been struck around this once
          // and than changing its value depended on nearByStruck
          j = j % 10;
          if(priority[i][j] != 0) {
            nearByStruck = 0;
            if(i == 0 || priority[i-1][j] == 0) nearByStruck++;
            if(i == 9 || priority[i+1][j] == 0) nearByStruck++;
            if(j == 0 || priority[i][j-1] == 0) nearByStruck++;
            if(j == 9 || priority[i][j+1] == 0) nearByStruck++;

            if(nearByStruck == 4) priority[i][j] = 1;
            else if(nearByStruck > 0){
              if(nearByStruck == 3) priority[i][j] = Math.round(priority[i][j]/3);
              else if(nearByStruck == 2) priority[i][j] = Math.round(priority[i][j]*2/3);
              else if(nearByStruck == 1) priority[i][j] = Math.round(priority[i][j]*3/4);

              if(priority[i][j] < 6/nearByStruck) priority[i][j] = 6/nearByStruck;
            }
            else if (nearByStruck == 0) {
              if(priority[i][j] < 10) priority[i][j] = 10;
            }
          }

          if(maksPrior < priority[i][j]){
            maksPrior = priority[i][j];
            ret[0] = i + 1;
            ret[1] = j + 1;
          }
        }
        // System.out.println();
      }

      // just printing out priority map
      System.out.println();
      System.out.println("  " + " A B C D E F G H I J");
      for(i=0;i<10;i++){
        if(i!=9) System.out.print(" ");
        System.out.print(i+1);
        for(j=0;j<10;j++){
          System.out.print("\u001b[38;5;");
          if(priority[i][j] == 0) System.out.print("255");
          else if(priority[i][j] == 1) System.out.print("216");
          else if(priority[i][j] <= 10) System.out.print("45");
          else if(priority[i][j] <= 20) System.out.print("50");
          else if(priority[i][j] <= 30) System.out.print("52");
          else if(priority[i][j] <= 45) System.out.print("235");
          else System.out.print("11");
          // else System.out.print("\u001b[31m" + priority[i][j]);
          System.out.print("m" + " +" + "\u001b[0m");
        }
        System.out.println();
      }
      System.out.println();
      return ret;
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
