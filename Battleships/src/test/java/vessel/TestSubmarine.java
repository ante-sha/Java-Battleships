import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;


public class TestSubmarine
{
    @Test
    public void testSubmarineIsaVesselImpl()
    {
        Submarine submarine = new Submarine();
        assertThat(submarine, instanceOf(VesselImpl.class));
    }

    @Test
    public void testSubmarineSize()
    {
        VesselImpl submarine = new Submarine();
        int size = 2;
        assertEquals(size, submarine.getSize());
    }
}