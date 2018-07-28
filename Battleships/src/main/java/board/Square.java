package board;
import java.io.*;
import java.util.*;

public class Square {

    private Boolean isHit = false;
    private Boolean hasShip = false;
    private String xPosition;
    private int yPosition;


    public Square (String xPosition , int yPosition ) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    @Override
    public String toString(){
        return this.xPosition + this.yPosition;
    }


    public void setHit(Boolean hit) {
        this.isHit = hit;
    }

    public Boolean getHit() {
        return this.isHit;
    }

    public void setHasShip(Boolean hasShip) {
        this.hasShip = hasShip;
    }

    public Boolean getHasShip() {
        return this.hasShip;
    }
}