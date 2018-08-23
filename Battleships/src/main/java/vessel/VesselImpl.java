package vessel;
import board.*;
import java.util.*;

public abstract class VesselImpl implements Vessel {

    private int size;
    private int damage;
    private Boolean set;
    private Boolean sunk = false;
    private List<Square> fields = new ArrayList();

    public VesselImpl(int size) {
        this.size = size;
        this.damage = 0;
        this.set = false;
    }

    public void setShip(){
      this.set = true;
    }

    public Boolean isSet(){
      return this.set;
    }

    public List getFields(){
      return this.fields;
    }

    public int getSize() {
        return this.size;
    }

    public int getDamage() {
        return this.damage;
    }

    public Boolean isSunk() {
        return this.sunk;
    }


    public Boolean strike(){
      if(this.sunk){
        return true;
      } else {
        int damaged = 0;
        for(int i=0; i < this.size; i++){
          if (fields.get(i).getWasShot()) damaged++;
        }
        this.damage = damaged;
        if(this.damage == this.size) this.sunk = true;
      }
      return this.sunk;

    }

    @Override
    public String toString()
    {
        return "size: " + this.size + "\n" + "damage: " + this.damage + "\n" + "set: " + this.set;
    }
}
