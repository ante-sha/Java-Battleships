import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import vessel.*;


public class TestVesselImpl {

   /* @Test
    public void testStrike()
    {
        Carrier testvesselimpl = new Carrier();

        int damage = 1;
        assertEquals(damage, testvesselimpl.strike());

    }*/

 /*   @Test
    public void testSize()
    {
        Carrier testvesselimpl = new Carrier();

        int size = 5;
        assertEquals(size, testvesselimpl.getSize());

    }*/

    @Test
    public void testIsSunk()
    {
        Carrier testvesselimpl = new Carrier();

        boolean sunk = false;
        assertEquals(sunk, testvesselimpl.isSunk());

        testvesselimpl.strike();
        testvesselimpl.strike();
        testvesselimpl.strike();
        testvesselimpl.strike();
        testvesselimpl.strike();

        sunk = true;
        assertEquals(sunk, testvesselimpl.isSunk());

    }



}