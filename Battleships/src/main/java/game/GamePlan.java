package game;
import player.*;
import java.util.Scanner;
import board.*;
import vessel.*;
import java.util.*;
import game.*;

public class GamePlan {
    private Player player1;
    private Player player2;
    private AIData data1;
    private AIData data2;
    public GamePlan() {
    }
    public void playGame() {


        setPlayers();
        // float good = 0;
        // for(int p =0; p<100;p++){
        int numByShip[] = {1,1,1,1,1};
        int numShips = 0;
        for(int i=0;i<5;i++) numShips+=numByShip[i];
        HashMap<String, ArrayList> collection1 = new HashMap<String, ArrayList>();
        HashMap<String, ArrayList> collection2 = new HashMap<String, ArrayList>();

        Fleet fleet = new Fleet();

        Grid grid1 = new Grid();
        Grid grid2 = new Grid();

        fleet.createFleet(collection1, numByShip);
        fleet.createFleet(collection2, numByShip);


        fleet.placeFleet(collection1, numByShip, grid1, player1.getMode());
        fleet.placeFleet(collection2, numByShip, grid2, player2.getMode());

        grid1.drawBoatGrid();
        grid2.drawBoatGrid();

        drawGame();

        int[] data;
        // player.mode == true if player is human but we want to pass to the
        // function if the shooting is random or not
        data = startShooting(collection1, collection2, grid1, grid2, numShips, !player1.getMode(), !player2.getMode());
        // good+=data[1];
        drawEnd();

        if(data[0] == 1){
          grid1.drawPlayGrid();
          System.out.println(player1.getName() + " wins!\nStrikes: " + data[1]);
        }
        else {
          grid2.drawPlayGrid();
          System.out.println(player2.getName() + " wins!\nStrikes: " + data[1]);
        }
        // }
        // System.out.println("Average win strikes: " + (good/100));
    }

    private String enterName(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + playerNumber + ", choose your name");
        return scanner.nextLine();
    }
    private void drawGame(){
      for(int p=0;p<10;p++) System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
      System.out.println("PLAY+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
      System.out.println("    xxxxxx       xxxxxxx      xxx      xx       xxxxxxxxxxx");
      System.out.println("  xxx   xxxx    xxx   xx     xxxxx    xxx      xxx         ");
      System.out.println(" xxx           xxx    xx    xxx xxx xx xx     xxxxxxx     ");
      System.out.println(" xxx   xxxxx  xxxxxxxxxx   xxx  xxxxx  xx    xxxxxx      ");
      System.out.println(" xxx    xxx  xxx      xx  xxx          xx   xxx         ");
      System.out.println("  xxxxxxxx  xxx       xx xxx           xx  xxxxxxxxxxxx");
      for(int p=0;p<10;p++) System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }

    private void drawEnd(){
      for(int p=0;p<10;p++) System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
      System.out.println("THE-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
      System.out.println("      xxxxxxxxxxxxx    xxxx        xxxx    xxxxxxxxx   ");
      System.out.println("     xxxx             xxxxxx      xxxx    xxxxx  xxxxx ");
      System.out.println("    xxxxxxx          xxxx  xx    xxxx    xxxxx    xxxxx");
      System.out.println("   xxxxxx           xxxx    xx  xxxx    xxxxx     xxxxx");
      System.out.println("  xxx              xxxx     xx xxxx    xxxxx    xxxxx  ");
      System.out.println(" xxxxxxxxxxxx     xxxx       xxxxx    xxxxxxxxxxx      ");
      for(int p=0;p<10;p++) System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
    }

    private void setPlayers(){
      int num;
      Scanner scanner = new Scanner(System.in);
      do {

        System.out.println("Enter the number of players(0, 1, 2)");
        num = scanner.nextInt();
      } while (num>2 || num<0);

      this.player1 = new Player();
      this.player2 = new Player();
      if(num == 2){

        player1.setName(enterName(1));
        System.out.println("Hello " + player1.getName());

        player2.setName(enterName(2));
        System.out.println("Hello " + player2.getName());
      } else if(num == 1){

        player1.setName(enterName(1));
        System.out.println("Hello " + player1.getName());

        player2.randMode();
        player2.setName("Explorer Krimp");
        this.data2 = new AIData();
      } else {

        player1.randMode();
        player1.setName("Pirate Joji");
        this.data1 = new AIData();

        player2.randMode();
        player2.setName("Lieutenant Johnson");
        this.data2 = new AIData();
      }
    }



    public static Boolean check (String value){
      int n = value.length();
      if (n < 2 || n > 3) return false;
      else {
        try{
          char c = value.charAt(n-1);
          int p = Integer.parseInt(value.substring(0, n-1));
          if((c >= 'A' && c<='J') && (p>=1 && p <= 10)) return true;
          return false;
        } catch (Exception e) {
          return false;
        }

      }
    }

    private int[] startShooting(HashMap collection1, HashMap collection2, Grid grid1, Grid grid2, int numShips, Boolean rand1, Boolean rand2){
      int[] data = {0,0};
      while(true){
        data[1]++;
        if(boom(collection1, grid1, numShips, rand1, 1, data[1])){
          data[0] = 1;
          return data;
        }
        /*else if(boom(collection2, grid2, numShips, rand2, 2, data[1])){
          data[0] = 2;
          return data;
        }*/
      }
    }

    private Boolean boom(HashMap collection, Grid grid, int numShips, boolean random, int player, int sCounter){
      if(player == 1)System.out.println(player1.getName() + " plays");
      else System.out.println(player2.getName() + " plays");

      Scanner scanner = new Scanner(System.in);
      List<VesselImpl> tmpList = new ArrayList();
      String position;
      int k;
      int x;
      int y;
      int[] base;
      int[] last;
      char orientation;
      int count = 0;
      Random rand = new Random();

      if(random) {
        do{
          if(count >= 5 || player == 1 && data1.getBase()[0] == 0 || player == 2 && data2.getBase()[0] == 0){
            if(sCounter < 30 && false){
              x = rand.nextInt(10) + 1;
              y = rand.nextInt(10) + 1;
            } else {
            base = grid.calculateNextStep(sCounter);
            x = base[0];
            y = base[1];
            }
            if(player == 1){
              data1.restart();
            } else {
              data2.restart();
            }
          } else if(player == 1 && data1.getLast()[0] == 0 || player == 2 && data2.getLast()[0] == 0){
              char charToPass;
              if(player == 1){
                  base = data1.getBase();
                  charToPass = grid.predictRestOfTheShip(base);
                  data1.setOrientation(charToPass);
                  if (charToPass == 'N') {
                    x = base[0] - 1;
                    y = base[1];
                  } else if (charToPass == 'S'){
                    x = base[0] + 1;
                    y = base[1];
                  } else if (charToPass == 'E') {
                    x = base[0];
                    y = base[1] + 1;
                  } else {
                    x = base[0];
                    y = base[1] - 1;
                  }
              } else {
                base = data2.getBase();
                charToPass = grid.predictRestOfTheShip(base);
                data2.setOrientation(charToPass);
                if (charToPass == 'N') {
                  x = base[0] - 1;
                  y = base[1];
                } else if (charToPass == 'S'){
                  x = base[0] + 1;
                  y = base[1];
                } else if (charToPass == 'E') {
                  x = base[0];
                  y = base[1] + 1;
                } else {
                  x = base[0];
                  y = base[1] - 1;
                }
              }

              if(x < 1 || x > 10 || y < 1 || y > 10) {
                count++;
                continue;
              }
          } else {
            // znamo da postoji i baza i smjer
            if(player == 1){
              base = data1.getBase();
              orientation = data1.getOrientation();
              last = data1.getLast();
              if(orientation == 'V'){
                if(base[0] - last[0] > 0) x = last[0] - 1;
                else x = last[0] + 1;
                y = last[1];
              } else {
                if(base[1] - last[1] > 0) y = last[1] - 1;
                else y = last[1] + 1;
                x = last[0];
              }
            } else {
              base = data2.getBase();
              orientation = data2.getOrientation();
              last = data2.getLast();
              if(orientation == 'V'){
                if(base[0] - last[0] > 0) x = last[0] - 1;
                else x = last[0] + 1;
                y = last[1];
              } else {
                if(base[1] - last[1] > 0) y = last[1] - 1;
                else y = last[1] + 1;
                x = last[0];
              }
            }

            if(x < 1 || x > 10 || y < 1 || y > 10){
              if(player == 1){
                if(data1.dirChanged()){
                  data1.restart();
                  continue;
                } else {
                  data1.rotate();
                  continue;
                }
              } else {
                if(data2.dirChanged()){
                  data2.restart();
                  continue;
                } else {
                  data2.rotate();
                  continue;
                }
              }
            }
            if(grid.getGrid().get((x-1)*10+y).getWasShot()) {
              if(grid.getGrid().get((x-1)*10+y).getHasShip()){
                if(player == 1){
                  data1.setLast(x,y);
                } else {
                  data2.setLast(x,y);
                }
                continue;
              } else {
                if(player == 1) {
                  if(data1.dirChanged()) data1.restart();
                  else data1.rotate();
                }
                else {
                  if(data2.dirChanged()) data2.restart();
                  else data2.rotate();
                }
                continue;
              }
            }

          }

          if(grid.getGrid().get((x - 1)*10+y).getWasShot()) {
            count++;
            continue;
          }
          break;

        }while(true);
        count = 0;
        //  end of CPU striking methods
      } else {
        grid.drawPlayGrid();
        do{
          System.out.println("Enter valid field");
          position = scanner.nextLine();
          if(!check(position)) continue;
          y = position.charAt(position.length() - 1) - 'A' + 1;
          x = Integer.parseInt(position.substring(0,position.length() - 1));
          if(grid.getGrid().get((x - 1)*10+y).getWasShot()) continue;
          break;
        } while(true);
      }

      grid.getGrid().get((x - 1)*10+y).setWasShot(true);
      grid.drawPlayGrid();

      if(grid.getGrid().get((x - 1)*10+y).getHasShip()){
        //  We need to update AIData only if the player is CPU
        if (random) {
          if(player == 1){
            if(data1.getBase()[0] == 0){
              data1.setBase(x,y);
              data1.setNewDir();
              data1.setOrientation('E');
            } else {
              if(data1.getLast()[0] == 0) {
                if(data1.getOrientation() == 'E' || data1.getOrientation() == 'W') data1.setOrientation('H');
                else data1.setOrientation('V');
              }
              data1.setLast(x,y);
            }
          } else {
            if(data2.getBase()[0] == 0){
              data2.setBase(x,y);
              data2.setNewDir();
              data2.setOrientation('E');
            } else {
              if(data2.getLast()[0] == 0) {
                if(data2.getOrientation() == 'E' || data2.getOrientation() == 'W') data2.setOrientation('H');
                else data2.setOrientation('V');
              }
              data2.setLast(x,y);
            }
          }
        }

        tmpList = (ArrayList)collection.get(VesselName.CARRIER.getName());
        k = tmpList.size();
        for(int i = 0; i < k; i++){
          //  at least one boat is not dead
          if (!(tmpList.get(i).strike())) {
            return false;
          }
        }

        tmpList = (ArrayList)collection.get(VesselName.BATTLESHIP.getName());
        k = tmpList.size();
        for(int i = 0; i < k; i++){
          //  at least one boat is not dead
          if (!(tmpList.get(i).strike())) {
            return false;
          }
        }

        tmpList = (ArrayList)collection.get(VesselName.CRUISER.getName());
        k = tmpList.size();
        for(int i = 0; i < k; i++){
          //  at least one boat is not dead
          if (!(tmpList.get(i).strike())) {
            return false;
          }
        }

        tmpList = (ArrayList)collection.get(VesselName.SUBMARINE.getName());
        k = tmpList.size();
        for(int i = 0; i < k; i++){
          //  at least one boat is not dead
          if (!(tmpList.get(i).strike())) {
            return false;
          }
        }

        tmpList = (ArrayList)collection.get(VesselName.DESTROYER.getName());
        k = tmpList.size();
        for(int i = 0; i < k; i++){
          //  at least one boat is not dead
          if (!(tmpList.get(i).strike())) {
            return false;
          }
        }

        return true;
      } else {
        //  We need to update AIData only if the player is CPU
        if (random) {
          if(player == 1){
            if(data1.getBase()[0] != 0){
              if(data1.dirChanged()) {
                data1.restart();
                return false;
              }
              if(data1.getOrientation() == 'H' || data1.getOrientation() == 'V') data1.rotate();
            }
            return false;
          } else {
            if(data2.getBase()[0] != 0){
              if(data2.dirChanged()) {
                data2.restart();
                return false;
              }
              if(data2.getOrientation() == 'H' || data2.getOrientation() == 'V') data2.rotate();
            }
            return false;
          }
        } else return false;

      }
    }
}
