package game;
import fleet.*;
import board.*;

class Play
{
    public static void main(String args[])
    {
        System.out.println("Play game");
        Grid grid1 = new Grid ();
        grid1.drawGrid();

        NavalFleetImpl  carrier = new Carrier();
        NavalFleetImpl  battleship = new Battleship();
        NavalFleetImpl  cruiser = new Cruiser();
        NavalFleetImpl  submarine = new Submarine();
        NavalFleetImpl  destroyer = new Destroyer();



        System.out.println(carrier.isSunk());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.strike());
        System.out.println(carrier.isSunk());
    }
}

