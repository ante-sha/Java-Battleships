import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import vessel.*;

public class TestBattleship
{
    @Test
    public void testBattleshipIsaVesselImpl()
    {
        Battleship battleship = new Battleship();
        assertThat(battleship, instanceOf(VesselImpl.class));
    }
}