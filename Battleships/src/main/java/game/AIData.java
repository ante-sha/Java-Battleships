package game;

import java.util.*;
import vessel.*;
import board.*;

public class AIData {
  private int[] basePosition = {0,0};
  private int[] lastPosition = {0,0};
  private char orientation = 'E';
  private Boolean dirChanged = false;
  public AIData (){

  }
  public int[] getBase(){
    return this.basePosition;
  }
  public int[] getLast(){
    return this.lastPosition;
  }
  public char getOrientation(){
    return this.orientation;
  }
  public Boolean dirChanged(){
    return this.dirChanged;
  }
  public void setNewDir(){
    this.dirChanged = false;
  }

  public void changeDir(){
    this.dirChanged = true;
  }
  public void restart(){
    this.basePosition[0] = 0;
    this.basePosition[1] = 0;
    this.lastPosition[0] = 0;
    this.lastPosition[1] = 0;
    this.orientation = 'E';
    this.dirChanged = false;
  }
  public int getLength(){
    if(this.basePosition[0] == this.lastPosition[0]) return Math.abs(this.basePosition[1] - this.lastPosition[1]) + 1;
    else return Math.abs(this.basePosition[0] - this.lastPosition[0]) + 1;
  }

  public void rotate(){
    int[] dummy;
    dummy = this.basePosition.clone();
    this.basePosition = this.lastPosition.clone();
    this.lastPosition = dummy.clone();
    changeDir();
  }

  public void setBase(int x, int y){
    int[] dummy = {0,0};
    dummy[0] = x;
    dummy[1] = y;
    this.basePosition = dummy.clone();
  }
  public void setLast(int x, int y){
    int[] dummy = {0,0};
    dummy[0] = x;
    dummy[1] = y;
    this.lastPosition = dummy.clone();
  }
  public void setOrientation(char ort){
    this.orientation = ort;
  }
  @Override
  public String toString()
  {
      return "AIData{"
           + "Base=" + this.basePosition[0] + "|" + this.basePosition[1]
           + ", Last=" + this.lastPosition[0] + "|" + this.lastPosition[0]
           + ", Orientation=" + this.orientation
           + ", dirChanged=" + this.dirChanged
           + "}";
  }
}
