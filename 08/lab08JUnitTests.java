import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class lab08JUnitTests {
    
    @Test
    public void testFunkcja(){
        double x = Funkcja.SIN.wartosc(Math.PI/2);
        double y = Funkcja.ARCSIN.wartosc(1);
        double z = Funkcja.LN.wartosc(Math.E);

        assertEquals(x, 1);
        assertEquals(y, Math.PI/2);
        assertEquals(z, 1);
    }

    @Test
    public void testFunkcjaExceptions(){
        assertThrows(BladFunkcji.class, () -> { double x = Funkcja.ARCSIN.wartosc(-2); } );
        assertThrows(BladFunkcji.class, () -> { double y = Funkcja.LN.wartosc(-3); } );
    }

    @Test    
    public void testPochodna(){
        Pochodna d1 = new Pochodna(Funkcja.SIN);
        Pochodna d2 = new Pochodna(Funkcja.ARCSIN);
        Pochodna d3 = new Pochodna(Funkcja.LN);

        d1.setH(1e-6);
        d2.setH(1e-6);
        d3.setH(1e-6);

        assertEquals(d1.wartosc(1, Math.PI/2), 0, 0.001);
        assertEquals(d2.wartosc(1, 0), 1, 0.001);
        assertEquals(d3.wartosc(1, 1), 1, 0.001);

        double[] tabSin = d1.wartosc(2, Math.PI/2, Math.PI, 0);
        double[] expectedValuesSin = {-1, 0, 0};
        for(int i=0; i< 3; i++){
            assertEquals(tabSin[i], expectedValuesSin[i], 0.001);
        }
    }

    @Test    
    public void testPochodnaExceptions(){
        Pochodna d1 = new Pochodna(Funkcja.SIN);
        Pochodna d2 = new Pochodna(Funkcja.ARCSIN);
        Pochodna d3 = new Pochodna(Funkcja.LN);

        assertThrows(BladPochodnej.class, () -> { double d = d1.wartosc(3, 2); });
        assertThrows(BladPochodnej.class, () -> { double d = d2.wartosc(1, 2); });
    }

    @Test
    public void testPochodnaLambda(){
        Pochodna d1 = new Pochodna(() -> Funkcja.SIN);
        assertEquals(d1.wartosc(1, Math.PI/2), 0, 0.001);
    }
}
