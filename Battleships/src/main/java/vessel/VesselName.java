package vessel;

public enum VesselName
{
   // Carrier name
   CARRIER("Carrier"),       // calls the constructor with value Carrier

   // Cruisur name
   CRUISER("Cruiser"),       // calls the constructor with value Cruiser

   // Destroyer name
   DESTROYER("Destroyer"),   // calls the constructor with value Destroyer

   // Submarine name
   SUBMARINE("Submarine"),   // calls the constructor with value Submarine

   // Battleship name
   BATTLESHIP("Battleship")  // calls the constructor with value Battleship
   ;

   // Instance variable
   private String name;

   // Constructor
   private VesselName(String name)
   {
       this.name = name;
   }

   // Getter
   public String getName()
   {
       return this.name;
   }
}
