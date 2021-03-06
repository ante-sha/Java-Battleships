import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;

public class TestBattleship
{
    @Test
    public void testBattleshipIsaVesselImpl()
    {
        Battleship battleship = new Battleship();
        assertThat(battleship, instanceOf(VesselImpl.class));
    }
    @Test
    public void testBattleshipSize()
    {
        VesselImpl battleship = new Battleship();
        int size = 4;
        assertEquals(size, battleship.getSize());
    }
}