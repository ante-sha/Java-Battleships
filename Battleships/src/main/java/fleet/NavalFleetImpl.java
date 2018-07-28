package fleet;


public abstract class NavalFleetImpl implements Vessel {

    private int size;
    private int damage;

    public NavalFleetImpl(int size) {
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