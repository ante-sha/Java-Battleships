import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;

public class TestDestroyer
{
    @Test
    public void testDestroyerIsaVesselImpl()
    {
        Destroyer destroyer = new Destroyer();
        assertThat(destroyer, instanceOf(VesselImpl.class));
    }

    @Test
    public void testDestroyerSizeisOne()
    {
        VesselImpl destroyer = new Destroyer();
        int size = 1;
        assertEquals(size, destroyer.getSize());
    }
}