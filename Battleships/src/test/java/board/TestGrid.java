// GridTest.java
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
    public void testStringOutput(){

        String expectOutput = "Grid{xAxis=[A, B, C, D, E, F, G, H, I, J], yAxis=[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], grid={1=A1, 2=A2, 3=A3, 4=A4, 5=A5, 6=A6, 7=A7, 8=A8, 9=A9, 10=A10, 11=B1, 12=B2, 13=B3, 14=B4, 15=B5, 16=B6, 17=B7, 18=B8, 19=B9, 20=B10, 21=C1, 22=C2, 23=C3, 24=C4, 25=C5, 26=C6, 27=C7, 28=C8, 29=C9, 30=C10, 31=D1, 32=D2, 33=D3, 34=D4, 35=D5, 36=D6, 37=D7, 38=D8, 39=D9, 40=D10, 41=E1, 42=E2, 43=E3, 44=E4, 45=E5, 46=E6, 47=E7, 48=E8, 49=E9, 50=E10, 51=F1, 52=F2, 53=F3, 54=F4, 55=F5, 56=F6, 57=F7, 58=F8, 59=F9, 60=F10, 61=G1, 62=G2, 63=G3, 64=G4, 65=G5, 66=G6, 67=G7, 68=G8, 69=G9, 70=G10, 71=H1, 72=H2, 73=H3, 74=H4, 75=H5, 76=H6, 77=H7, 78=H8, 79=H9, 80=H10, 81=I1, 82=I2, 83=I3, 84=I4, 85=I5, 86=I6, 87=I7, 88=I8, 89=I9, 90=I10, 91=J1, 92=J2, 93=J3, 94=J4, 95=J5, 96=J6, 97=J7, 98=J8, 99=J9, 100=J10}}";

         assertEquals(expectOutput,this.testGrid.toString());

    }

}