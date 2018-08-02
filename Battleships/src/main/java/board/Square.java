package board;

import java.io.*;
import java.util.*;

/**
 * This class contains the attributes of a square.
 * Squares have fixed attributes (cooridnates) and variable
 * attributes which change during the game.
 * @author     Ivan Uglik
 * @author     Minja Malovic
 * @version    1.0 - 02.08.2018
 * @since      1.0
 */
public class Square
{
    private Boolean wasShot = false;
    private Boolean hasShip = false;
    private final String xPosition;
    private final int yPosition;

    /**
     * The constructor requires the coordinates as those are fixed once we've
     * created the object.
     * @param xPosition     The x-coordinate of the square.
     * @param yPosition     The y-coordinate of the square.
     */
    public Square (String xPosition , int yPosition )
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Changes the status if the square has been shot at.
     *
     * @param wasShot Set it to true if a player shot at it.
     */
    public void setWasShot(Boolean wasShot)
    {
        this.wasShot = wasShot;
    }

    /**
     * Returns true if the square was shot at.
     *
     * @return true or false
     */
    public Boolean getWasShot()
    {
        return this.wasShot;
    }

    /**
     * Changes the status if the square is part of a vessel.
     *
     * @param hasShip Set it to true if a vessel was placed on this square.
     */
    public void setHasShip(Boolean hasShip)
    {
        this.hasShip = hasShip;
    }

    /**
     * Returns true if the square has a ship on it.
     *
     * @return true or false
     */
    public Boolean getHasShip()
    {
        return this.hasShip;
    }

    @Override
    public String toString()
    {
        return "Square{"
             + "xPosition=" + this.xPosition
             + ", yPosition=" + this.yPosition
             + ", hasShip=" + this.hasShip
             + ", wasShot=" + this.wasShot
             + "}";
    }
}
