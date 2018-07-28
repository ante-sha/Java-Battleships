import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import fleet.*;

public class TestDestroyer
{
    @Test
    public void testDestroyerIsaNavalFleetImpl()
    {
        Destroyer destroyer = new Destroyer();
        assertThat(destroyer, instanceOf(NavalFleetImpl.class));
    }
}