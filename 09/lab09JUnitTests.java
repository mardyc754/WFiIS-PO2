/*

# pobranie JUnit-a
wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar

# kompilacja testów i reszty projektu
javac *.java -cp junit-platform-console-standalone-1.8.1.jar 

# uruchomienie testów
java -jar junit-platform-console-standalone-1.8.1.jar -cp .  --scan-class-path

*/


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class lab09JUnitTests {

    Random rnd = new Random();

    @Test
    public void test0() {
        class A {
            int n;
            public A(int n) { this.n = n; }
            public String toString() { return "A{"+n+"}"; }
        }
        int r = rnd.nextInt(9);
        A a1 = new A(1);
        A a2 = new A(r);
        A a3 = new A(r);
        assertEquals("A{1}", a1+"" );
        assertEquals("A{"+r+"}", a2+"" );
        assertEquals("A{"+r+"}", a3+"" );
        assertTrue(a1 != a2);
        assertTrue(a2 != a3);
        assertTrue(!a1.equals(a2));
        assertTrue(!a2.equals(a3));
    }

    
    @Test
    public void testA__3p() {
        int r = rnd.nextInt(9999);
        Dane x = new Dane(r); 
        Dane y = new Dane(r); 
        Dane z = x; 
        Dane q = new Dane(r+10000); 
        
        assertTrue( x != y );
        assertTrue( x == z );
        assertTrue( x != q );
        
        assertEquals( "object"+x, "object"+y );
        assertEquals( "object"+x, "object"+z );
        assertNotEquals( "object"+x, "object"+q );
        
        assertEquals( x, y );
        assertEquals( x, z );
        assertNotEquals( x, q );
        
        x.set(r+20000); 
        assertNotEquals( x, y );
        assertEquals( x, z );
        assertNotEquals( x, q );
    }
    
    @Test
    public void testB__2p() {
        int r = rnd.nextInt(9999);
        Dane x = new Dane(r); 
        Dane z = x; 
        assertTrue( x == z );
        assertEquals( "object"+x, "object"+z );
        assertEquals( x, z );
        
        z = (Dane)x.clone(); 
        assertTrue( x != z );
        assertEquals( "object"+x, "object"+z );
        assertEquals( x, z );
        
        Object ox = x;
        Object oz = z;
        assertTrue( ox != oz );
        assertEquals( "object"+ox, "object"+oz );
        assertEquals( ox, oz );
        
        x.set(r+20000); 
        assertNotEquals( x, z );
    }
    
    @Test
    public void testC__2p() {
        int r = rnd.nextInt(9999);
        Dane x = new Dane(r); 
        Dane y = new Dane(r); 
        
        assertEquals( x, y );
        assertEquals( x.hashCode(), y.hashCode() );
        
        int hx = x.hashCode();
        int hx2 = x.hashCode();
        assertEquals( hx, hx2 );
        x.set(r+20000); 
        assertNotEquals( x, y );
        int hx3 = x.hashCode();
        assertNotEquals( hx, hx3 );
        
        Dane z = (Dane)x.clone();
        assertEquals( x, z );
        assertEquals( x.hashCode(), z.hashCode() );
    }
    
    @Test
    public void testD__2p() {
        Exception e1 = new ZaMaloDanychException();
        Exception e2 = new UjemnyParametrException();
        
        try
        {
            Dane x = new Dane(0);
            assertThrows(ZaMaloDanychException.class, () -> { x.wynik(5); } );
            Dane y = new Dane(10);
            int yw = y.wynik(5);
            assertEquals( 5, yw );
        } 
        catch(Exception e) { }
        
        Dane z = new Dane(10);
        assertThrows(UjemnyParametrException.class, () -> { z.wynik(-5); } );
        
        Object o = new ZaMaloDanychException();
        assertThrows(ClassCastException.class, () -> {RuntimeException e = (RuntimeException)o; } );    
    }
    
    @Test
    public void testE__1p() {
        int r = rnd.nextInt(9);
        Dane x = new Dane(r);
        
        try
        {
            x.wynik(5);
        } 
        catch(Exception e) {
            assertEquals( "n="+r, e.getMessage() );
        }
        
        assertThrows(RuntimeException.class, ()->{ x.innyWynik(5);});
        
        try
        {
            x.innyWynik(5);
        } 
        catch(Exception e) {
            ZaMaloDanychException e1 = (ZaMaloDanychException) e.getCause();
            assertEquals( "ZaMaloDanychException: n="+r, e.getMessage() );
        }
    }

}
