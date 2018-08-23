package player;

public class Player {
    private String name;
    private Boolean mode;

    public Player () {
      this.mode = true;
    }

    public void setName (String name) {
    this.name = name;
    }

    public void randMode (){
      this.mode = false;
    }
    public Boolean getMode(){
      return this.mode;
    }

    public String getName () {
    return this.name;
    }
}
