package game;

import java.util.*;
import vessel.*;
import board.*;

public class Fleet {
  public Fleet(){}
  public void createFleet(HashMap col, int[] numByShip) {
    int i=0;
    col.put(VesselName.CARRIER.getName(),  new ArrayList());
    col.put(VesselName.BATTLESHIP.getName(),  new ArrayList());
    col.put(VesselName.CRUISER.getName(),  new ArrayList());
    col.put(VesselName.SUBMARINE.getName(),  new ArrayList());
    col.put(VesselName.DESTROYER.getName(),  new ArrayList());

    //  Array which is parameter in this function controls the number of the
    // ships by their aliasNum --> see function placeFleet()
    for(i=0; i < numByShip[0] ; i++) ((ArrayList)col.get(VesselName.CARRIER.getName())).add(new Carrier());

    for(i=0; i < numByShip[1]; i++) ((ArrayList)col.get(VesselName.BATTLESHIP.getName())).add(new Battleship());

    for(i=0; i < numByShip[2]; i++) ((ArrayList)col.get(VesselName.CRUISER.getName())).add(new Cruiser());

    for(i=0; i < numByShip[3]; i++) ((ArrayList)col.get(VesselName.SUBMARINE.getName())).add(new Submarine());

    for(i=0; i < numByShip[4]; i++) ((ArrayList)col.get(VesselName.DESTROYER.getName())).add(new Destroyer());
  }

  public void placeFleet(HashMap col, int[] schemeShip, Grid grid, Boolean playerInput){
    int[] numByShip = schemeShip.clone();
    boolean allSet = false;
    Scanner scanner = new Scanner(System.in);
    String nameOfShip;
    String position;
    char direction;
    int aliasNum;
    List<VesselImpl> tmpList = new ArrayList();
    int posInList;
    int check;
    int i = 0;
    Random rand = new Random();
    outer:
    do{
      if (playerInput) {
        System.out.println("Enter the name of the ship you want to place: ");
        nameOfShip = scanner.nextLine();
        if(nameOfShip.equals(VesselName.CARRIER.getName())) aliasNum = 0;
        else if(nameOfShip.equals(VesselName.BATTLESHIP.getName())) aliasNum = 1;
        else if(nameOfShip.equals(VesselName.CRUISER.getName())) aliasNum = 2;
        else if(nameOfShip.equals(VesselName.SUBMARINE.getName())) aliasNum = 3;
        else if(nameOfShip.equals(VesselName.DESTROYER.getName())) aliasNum = 4;
        else {
          System.out.println("Invalid name of the ship, try again!");
          continue outer;
        }
      } else {
        //  random choice to pick a ship
        aliasNum = rand.nextInt(5);
        if(aliasNum == 0) nameOfShip = VesselName.CARRIER.getName();
        else if(aliasNum == 1) nameOfShip = VesselName.BATTLESHIP.getName();
        else if(aliasNum == 2) nameOfShip = VesselName.CRUISER.getName();
        else if(aliasNum == 3) nameOfShip = VesselName.SUBMARINE.getName();
        else nameOfShip = VesselName.DESTROYER.getName();
      }
      // validate if there is any ship with this name you can place
      if(numByShip[aliasNum] < 1){
        System.out.println("There is no available ship of that type, use another!");
        continue outer;
      }
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      // Scanning of the ship head point
      if (playerInput) {
        System.out.println("Enter the first point of the ship (number|UpperCase letter): ");
        position = scanner.nextLine();
        while(!check(position)){
          System.out.println("Field doesn't exist, try again!");
          position = scanner.nextLine();
        }
      } else {
        position = "" + (rand.nextInt(10) + 1) + (char)(rand.nextInt(10) + 'A');
      }
      // Scanning the direction in which we want to place ship
      if (playerInput) {
        System.out.println("Enter the direction of the ship  H/V: ");
        direction = scanner.next().charAt(0);
        while(direction != 'H' && direction != 'V'){
          System.out.println("Only H and V are valid inputs...\n Try again!");
          direction = scanner.next().charAt(0);
        }
      } else {
        if(rand.nextInt(2) == 1) direction = 'H';
        else direction = 'V';
      }

      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      // Taking out the whole ArrayList of that "class"
      tmpList = (ArrayList)col.get(nameOfShip);
      for(i = 0; tmpList.get(i).isSet() ; i++);
      posInList = i;
      int n = tmpList.get(posInList).getSize();
      //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
      int y = position.charAt(position.length() - 1) - 'A' + 1;
      int x = Integer.parseInt(position.substring(0,position.length() - 1));
      List<Square> fields = new ArrayList();
      if(direction == 'H'){
        //  check if there is already ships on that fields or we go out of the grid
        if((y+n-1) > 10) {
          System.out.println("Ship can\'t hang outside of the grid, try again!");
          continue outer;
        }
        for(i=0; i < n; i++){
          if(grid.getGrid().get((x - 1)*10+(y+i)).getHasShip()){
            System.out.println("Not posible to place the ship, try again!");
            continue outer;
          }
        }
        // check passed, placing the ship
        for(i=0; i < n; i++){
          grid.getGrid().get((x - 1)*10+(y+i)).setHasShip(true);
          tmpList.get(posInList).getFields().add(grid.getGrid().get((x - 1)*10+(y+i)));
        }
      } else {
        //  check if there is already ships on that fields or we go out of the grid
        for(i=0; i < n; i++){
          if((x+i) > 10 || grid.getGrid().get((x - 1 + i)*10+y).getHasShip()){
            System.out.println("Not posible to place the ship, try again!");
            continue outer;
          }
        }
        // check passed, placing the ship
        for(i=0; i < n; i++){
          grid.getGrid().get((x - 1 + i)*10+y).setHasShip(true);
          tmpList.get(posInList).getFields().add(grid.getGrid().get((x - 1 + i)*10+y));
        }
      }
      //  check if player placed all of his ships
      tmpList.get(posInList).setShip();
      numByShip[aliasNum]--;
      check = 0;
      for(i=0;i<5;i++){
        check += numByShip[i];
      }
      if(playerInput) grid.drawBoatGrid();
      if(check == 0) allSet=true;
    }while(!allSet);

  }

  public static Boolean check (String value){
    int n = value.length();
    try {
      char c = value.charAt(n-1);
      int p = Integer.parseInt(value.substring(0, n-1));
      if((c >= 'A' && c<='J') && (p>=1 && p <= 10)) return true;
      return false;
    } catch (Exception e) {
      return false;
    }


  }
}
