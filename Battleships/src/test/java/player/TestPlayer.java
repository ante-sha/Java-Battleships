import org.junit.Test;
import static org.junit.Assert.*;
import player.Player;

public class TestPlayer
{
    Player testPlayer = new Player();
    @Test
    public void testNamesForPlayers(){
    String testPlayerName = "Minja";
    testPlayer.setName(testPlayerName);

    assertEquals(testPlayerName, testPlayer.getName());
    }
}