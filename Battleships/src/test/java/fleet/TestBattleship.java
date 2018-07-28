import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import fleet.*;

public class TestBattleship
{
    @Test
    public void testBattleshipIsaNavalFleetImpl()
    {
        Battleship battleship = new Battleship();
        assertThat(battleship, instanceOf(NavalFleetImpl.class));
    }
}