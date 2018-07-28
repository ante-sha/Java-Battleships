package vessel;


public abstract class VesselImpl implements Vessel {

    private int size;
    private int damage;

    public VesselImpl(int size) {
        this.size = size;
        this.damage = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean isSunk() {
        if(getSize()==getDamage()){
            return true;
        }else {
            return false;
        }
    }

    public int strike(){
        ++this.damage;
        return getDamage();
    }


}