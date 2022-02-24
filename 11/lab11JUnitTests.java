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

import java.util.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class lab11JUnitTests {

    Random rnd = new Random();

    @Test
    public void test0() {
        class MyClass {
            int n;
            public MyClass(int n) { this.n = n; }
            public String toString() { return "MyClass{"+n+"}"; }
        }
        int r = rnd.nextInt(9);
        MyClass a1 = new MyClass(1);
        MyClass a2 = new MyClass(r);
        MyClass a3 = new MyClass(r);
        assertEquals("MyClass{1}", a1+"" );
        assertEquals("MyClass{"+r+"}", a2+"" );
        assertEquals("MyClass{"+r+"}", a3+"" );
        assertTrue(a1 != a2);
        assertTrue(a2 != a3);
        assertTrue(!a1.equals(a2));
        assertTrue(!a2.equals(a3));
        assertNotEquals(a2, a3);
    }

    @Test
    public void testA__2p() {
        Double x1 = 0.0;
        Double y1 = 0.0;
        Double z1 = 0.0;
        Vector3D<Double> vd = new Vector3D<>(x1,y1,z1);
        
        Integer x2 = 1;
        Integer y2 = 2;
        Integer z2 = 3;
        Vector3D<Integer> vi = new Vector3D<>(x2,y2,z2);
        
        assertEquals("(0.0,0.0,0.0)", vd+"" );
        assertEquals("(1,2,3)", vi+"" );
    }

    @Test
    public void testB__2p() {
        double x0 = 100*rnd.nextDouble();
        double y0 = 100*rnd.nextDouble();
        double z0 = 100*rnd.nextDouble();
        
        Double x1 = x0;
        Double y1 = y0;
        Double z1 = z0;
        Vector3D<Double> vd = new Vector3D<>(x1,y1,z1);
        assertEquals(x1, vd.x(), 1.0e-12);
        assertEquals(y1, vd.y(), 1.0e-12);
        assertEquals(z0, vd.z(), 1.0e-12);
        
        Integer x2 = (int)x0;
        Integer y2 = (int)y0;
        Integer z2 = (int)z0;
        Vector3D<Integer> vi = new Vector3D<>(x2,y2,z2);       
        assertEquals(x2, vi.x() );
        assertEquals(y2, vi.y() );
        assertEquals(z2, vi.z() );
        
        Vector3D<Integer> vi2 = new Vector3D<>(vi.x(), vi.y(), vi.z() );
        Object lx = (Object)vi.x();
        
        Integer xf = vi.x();
        xf = 101;
        assertEquals(x2, vi.x() );
    }
    
    @Test
    public void testC__4p() {
    
        // uwaga:
        // wystarczy ze metoda add() bedzie dzialac w dwoch ponizszych testach, nie musi byc bardziej ogolna 
    
        {
        Integer x1 = rnd.nextInt(10);
        Integer y1 = rnd.nextInt(10);
        Integer z1 = rnd.nextInt(10);
        
        Integer x2 = rnd.nextInt(10);
        Integer y2 = rnd.nextInt(10);
        Integer z2 = rnd.nextInt(10);
        
        Vector3D<Integer> v1 = new Vector3D<>(x1,y1,z1);
        Vector3D<Integer> v2 = new Vector3D<>(x2,y2,z2);
        
        Vector3D<?> v3 = v1.add(v2);
        
        assertEquals(x1+x2, v3.x() );
        assertEquals(y1+y2, v3.y() );
        assertEquals(z1+z2, v3.z() );
        }
        
        {
        Double x1 = rnd.nextDouble();
        Double y1 = rnd.nextDouble();
        Double z1 = rnd.nextDouble();
        
        Double x2 = rnd.nextDouble();
        Double y2 = rnd.nextDouble();
        Double z2 = rnd.nextDouble();
        
        Vector3D<Double> v1 = new Vector3D<>(x1,y1,z1);
        Vector3D<Double> v2 = new Vector3D<>(x2,y2,z2);
        
        Vector3D<?> v3 = v1.add(v2);
        
        assertEquals(x1+x2, v3.x() );
        assertEquals(y1+y2, v3.y() );
        assertEquals(z1+z2, v3.z() );
        }
    }
    
    
    @Test
    public void testD__2p() {
        double x0 = 100*rnd.nextDouble();
        double y0 = 100*rnd.nextDouble();
        double z0 = 100*rnd.nextDouble();
        
        Double x1 = x0;
        Double y1 = y0;
        Double z1 = z0;
        Vector3D<Double> vd = new Vector3D<>(x0,y0,z0);
        
        List<?> ld = vd.getList();
        assertEquals(x1, (Double)(ld.get(0)), 1.0e-12);
        assertEquals(y1, (Double)(ld.get(1)), 1.0e-12);
        assertEquals(z1, (Double)(ld.get(2)), 1.0e-12);
        
        Integer x2 = (int)x0;
        Integer y2 = (int)y0;
        Integer z2 = (int)z0;
        Vector3D<Integer> vi = new Vector3D<>(x2,y2,z2);  
        
        List<?> li = vi.getList();
        assertEquals(x2, (Integer)(li.get(0)) );
        assertEquals(y2, (Integer)(li.get(1)) );
        assertEquals(z2, (Integer)(li.get(2)) );

    }
}   
