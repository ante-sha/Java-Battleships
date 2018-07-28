package game;
import vessel.*;
import board.*;

class Play
{
    public static void main(String args[])
    {
        System.out.println("Play game");
        Grid grid1 = new Grid ();
        grid1.drawGrid();

        VesselImpl  carrier = new Carrier();
        VesselImpl  battleship = new Battleship();
        VesselImpl  cruiser = new Cruiser();
        VesselImpl  submarine = new Submarine();
        VesselImpl  destroyer = new Destroyer();



        System.out.println(carrier.isSunk());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.isSunk());
    }
}

