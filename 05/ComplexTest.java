import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {
    
    @Test
    public void testGetRe1()
    {
        Complex c = new Complex(4, 3);
        assertEquals(4, c.getRe());
    }

    @Test
    public void testGetRe2()
    {
        Complex c = new Complex(5, 3);
        assertEquals(5, c.getRe());
    }

    @Test
    public void testGetIm1()
    {
        Complex c = new Complex(5, 3);
        assertEquals(3, c.getIm());
    }

    @Test
    public void testGetIm2()
    {
        Complex c = new Complex(5, 6);
        assertEquals(6, c.getIm());
    }

    @Test
    public void testSetRe1()
    {
        Complex c = new Complex(5, 6);
        c.setRe(7);
        assertEquals(7, c.getRe());
    }

    @Test
    public void testSetRe2()
    {
        Complex c = new Complex(7, 6);
        c.setRe(2);
        assertEquals(2, c.getRe());
    }

    @Test
    public void testSetIm1()
    {
        Complex c = new Complex(7, 6);
        c.setIm(2);
        assertEquals(2, c.getIm());
    }

    @Test
    public void testSetIm2()
    {
        Complex c = new Complex(7, 10);
        c.setIm(4);
        assertEquals(4, c.getIm());
    }

    @Test
    public void testSet1()
    {
        Complex c = new Complex(1, 2);
        c.set(3, 4);
        assertEquals(3, c.getRe());
        assertEquals(4, c.getIm());
    }

    @Test
    public void testSet2()
    {
        Complex c = new Complex(7, 10);
        c.set(1, 2);
        assertEquals(1, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    public void testAddCC1(){
        Complex z = new Complex(1,2);
        Complex w = new Complex(3,4);
        Complex c = Complex.add(z,w);
        //assertEquals(new Complex(4,6), Complex.add(z,w)); // porownuje referencje!!! nie zawartosc
        assertEquals(4, c.getRe());
        assertEquals(6, c.getIm());
    }

    @Test
    public void testSubtractCC1(){
        Complex z = new Complex(1,2);
        Complex w = new Complex(3,4);
        Complex c = Complex.subtract(z,w);
        assertEquals(-2, c.getRe());
        assertEquals(-2, c.getIm());
    }

    @Test
    public void testMultiplyCC1(){
        Complex z = new Complex(1,2);
        Complex w = new Complex(3,4);

        Complex c = Complex.multiply(z,w);
        assertEquals(-5, c.getRe());
        assertEquals(10, c.getIm());
    }

    @Test
    public void testDivideCC1(){
        Complex z = new Complex(4,8);
        Complex w = new Complex(2,2);

        Complex c = Complex.divide(z,w);
        assertEquals(3, c.getRe());
        assertEquals(1, c.getIm());

    }

    @Test
    public void testAddCd1(){
        Complex z = new Complex(1,2);
        double y = 3;

        Complex c = Complex.add(z,y);
        assertEquals(1, c.getRe());
        assertEquals(5, c.getIm());
    }

    @Test
    public void testSubstractCd1(){
        Complex z = new Complex(1,2);
        double y = 3;

        Complex c = Complex.subtract(z,y);
        assertEquals(1, c.getRe());
        assertEquals(-1, c.getIm());
    }

    @Test
    public void testMultiplyCd1(){
        Complex z = new Complex(1,2);
        double y = 3;

        Complex c = Complex.multiply(z,y);
        assertEquals(3, c.getRe());
        assertEquals(6, c.getIm());
    }

    @Test
    public void testDivideCd1(){
        Complex z = new Complex(6,9);
        double y = 3;

        Complex c = Complex.divide(z,y);
        assertEquals(2, c.getRe());
        assertEquals(3, c.getIm());

    }

    @Test
    public void testAddDC1(){
        double x = 3;
        Complex w = new Complex(1,2);

        Complex c = Complex.add(x,w);
        assertEquals(4, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    public void testSubtractDC1(){
        double x = 3;
        Complex w = new Complex(1,2);

        Complex c = Complex.subtract(x,w);
        assertEquals(-2, c.getRe());
        assertEquals(-2, c.getIm());
    }

    @Test
    public void testMultiplyDC1(){
        double x = 3;
        Complex w = new Complex(1,2);

        Complex c = Complex.multiply(x,w);
        assertEquals(3, c.getRe());
        assertEquals(6, c.getIm());
    }

    @Test
    public void testDivideDC1(){
        double x = 13;
        Complex w = new Complex(2,3);

        Complex c = Complex.divide(x,w);
        assertEquals(2, c.getRe());
        assertEquals(-3, c.getIm());
    }


    @Test
    public void testAddCC2(){
        Complex z = new Complex(5,2);
        Complex w = new Complex(3,4);
        Complex c = Complex.add(z,w);

        assertEquals(8, c.getRe());
        assertEquals(6, c.getIm());
    }

    @Test
    public void testSubstractCC2(){
        Complex z = new Complex(9,4);
        Complex w = new Complex(3,4);

        Complex c = Complex.subtract(z,w);
        assertEquals(6, c.getRe());
        assertEquals(0, c.getIm());
    }

    @Test
    public void testMultiplyCC2(){
        Complex z = new Complex(3,5);
        Complex w = new Complex(2,1);

        Complex c = Complex.multiply(z,w);
        assertEquals(1, c.getRe());
        assertEquals(13, c.getIm());
    }

    @Test
    public void testDivideCC2(){
        Complex z = new Complex(12,24);
        Complex w = new Complex(3,3);

        Complex c = Complex.divide(z,w);
        assertEquals(6, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    public void testAddCd2(){
        Complex z = new Complex(1,2);
        double y = -4;

        Complex c = Complex.add(z,y);
        assertEquals(1, c.getRe());
        assertEquals(-2, c.getIm());
    }

    @Test
    public void testSubstractCd2(){
        Complex z = new Complex(6,9);
        double y = 5;

        Complex c = Complex.subtract(z,y);
        assertEquals(6, c.getRe());
        assertEquals(4, c.getIm());
    }

    @Test
    public void testMultiplyCd2(){
        Complex z = new Complex(4,-2);
        double y = -2;

        Complex c = Complex.multiply(z,y);
        assertEquals(-8, c.getRe());
        assertEquals(4, c.getIm());
    }

    @Test
    public void testDivideCd2(){
        Complex z = new Complex(-2,4);
        double y = 2;

        Complex c = Complex.divide(z,y);
        assertEquals(-1, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    public void testAddDC2(){
        double x = 7;
        Complex w = new Complex(-2,2);

        Complex c = Complex.add(x,w);
        assertEquals(5, c.getRe());
        assertEquals(2, c.getIm());
    }

    @Test
    public void testSubtractDC2(){
        double x = 4;
        Complex w = new Complex(-4,3);

        Complex c = Complex.subtract(x,w);
        assertEquals(-8, c.getRe());
        assertEquals(-3, c.getIm());
    }

    @Test
    public void testMultiplyDC2(){
        double x = -2;
        Complex w = new Complex(1,2);

        Complex c = Complex.multiply(x,w);
        assertEquals(-2, c.getRe());
        assertEquals(-4, c.getIm());
    }

    @Test
    public void testDivideDC2(){
        double x = 4;
        Complex w = new Complex(2,-2);

        Complex c = Complex.divide(x,w);
        assertEquals(1, c.getRe());
        assertEquals(1, c.getIm());
    }

}
