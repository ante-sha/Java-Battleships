import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;


public class TestCruiser
{
    @Test
    public void testCruiserIsaVesselImpl()
    {
        Cruiser cruiser = new Cruiser();
        assertThat(cruiser, instanceOf(VesselImpl.class));
    }

    @Test
    public void testCruiserSize()
    {
        VesselImpl cruiser = new Cruiser();
        int size = 3;
        assertEquals(size, cruiser.getSize());
    }
}