import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;


public class TestCarrier
{
    @Test
    public void testCarrierIsaVesselImpl()
    {
        Carrier carrier = new Carrier();
        assertThat(carrier, instanceOf(VesselImpl.class));
    }

    public void testCarrierSize()
    {
        VesselImpl carrier = new Carrier();
        int size = 5;
        assertEquals(size, carrier.getSize());
    }
}