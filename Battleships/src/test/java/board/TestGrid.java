import org.junit.Test;
import static org.junit.Assert.*;
import board.Grid;

public class TestGrid
{
    Grid testGrid = new Grid();

    @Test
    public void testCorrectSizeOfTheGrid()
    {
        int gridSize = 100;
        assertEquals(gridSize, this.testGrid.getGrid().size());
    }

    @Test
    public void testStringOutput()
    {
        String expectOutput = "Grid{xAxis=[A, B, C, D, E, F, G, H, I, J], yAxis=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], grid={1=Square{xPosition=A, yPosition=1, hasShip=false, wasShot=false},";

        assertEquals(expectOutput, this.testGrid.toString().substring(0, 153));
    }
}
