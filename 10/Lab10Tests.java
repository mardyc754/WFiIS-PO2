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

import java.beans.Transient;
import java.util.Random;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab10Tests {

    @Test
    public void testMatrix(){
        Matrix A = new Matrix(2);
        Matrix B = new Matrix(2);
        
        A.matrix[0][0] = 1.0;
        A.matrix[0][1] = 2.0;
        A.matrix[1][0] = 3.0;
        A.matrix[1][1] = 4.0;

        B.matrix[0][0] = 5.0;
        B.matrix[0][1] = 7.0;
        B.matrix[1][0] = 6.0;
        B.matrix[1][1] = 8.0;

        Matrix C = Matrix.product(A,B);
        assertEquals(C.matrix[0][0], 17.0);
        assertEquals(C.matrix[0][1], 23.0);
        assertEquals(C.matrix[1][0], 39.0);
        assertEquals(C.matrix[1][1], 53.0);

    }

    @Test
    public void testMatrixDouble(){
        MatrixDouble A = new MatrixDouble(2);
        MatrixDouble B = new MatrixDouble(2);

        A.matrix[0][0] = 1.0;
        A.matrix[0][1] = 2.0;
        A.matrix[1][0] = 3.0;
        A.matrix[1][1] = 4.0;

        B.matrix[0][0] = 5.0;
        B.matrix[0][1] = 7.0;
        B.matrix[1][0] = 6.0;
        B.matrix[1][1] = 8.0;

        MatrixDouble C = MatrixDouble.product(A,B);
        assertEquals(C.matrix[0][0], 17.0);
        assertEquals(C.matrix[0][1], 23.0);
        assertEquals(C.matrix[1][0], 39.0);
        assertEquals(C.matrix[1][1], 53.0);
    }

    @Test
    public void testMatrixGeneric(){
        MatrixGeneric<Double> A = new MatrixGeneric<>(2);
        MatrixGeneric<Double> B = new MatrixGeneric<>(2);

        A.matrix[0][0] = 1.0;
        A.matrix[0][1] = 2.0;
        A.matrix[1][0] = 3.0;
        A.matrix[1][1] = 4.0;

        B.matrix[0][0] = 5.0;
        B.matrix[0][1] = 7.0;
        B.matrix[1][0] = 6.0;
        B.matrix[1][1] = 8.0;

        MatrixGeneric<Double> C = MatrixGeneric.product(A,B);
        assertEquals(C.matrix[0][0], 17.0);
        assertEquals(C.matrix[0][1], 23.0);
        assertEquals(C.matrix[1][0], 39.0);
        assertEquals(C.matrix[1][1], 53.0);
    }
    
}