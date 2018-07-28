import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import fleet.*;

public class TestCarrier
{
    @Test
    public void testCarrierIsaNavalFleetImpl()
    {
        Carrier carrier = new Carrier();
        assertThat(carrier, instanceOf(NavalFleetImpl.class));
    }

    public void testCarrierSize()
    {
        NavalFleetImpl carrier = new Carrier();
        int size = 5;
        assertEquals(size, carrier.getSize());
    }
}