import java.io.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Mnozenie macierzy");

        Matrix A = new Matrix(200);
        Matrix B = new Matrix(200);

        long start = System.currentTimeMillis();
        Matrix C = Matrix.product(A, B);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("double: " + timeElapsed + "ms");

        MatrixDouble D = new MatrixDouble(200);
        MatrixDouble E = new MatrixDouble(200);

        start = System.currentTimeMillis();
        MatrixDouble F = MatrixDouble.product(D, E);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;

        System.out.println("Double: " + timeElapsed + "ms");


        MatrixGeneric<Double> G = new MatrixGeneric<>(200);
        MatrixGeneric<Double> H = new MatrixGeneric<>(200);

        start = System.currentTimeMillis();
        MatrixGeneric<Double> I = MatrixGeneric.product(G, H);
        finish = System.currentTimeMillis();
        timeElapsed = finish - start;

        System.out.println("<Double>: " + timeElapsed + "ms");

        System.out.println(new Lab10A(1, "abc"));
        java.lang.reflect.Method[] m = W7X3E.class.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }
        W7X3E obj = new W7X3E();

        char a = obj.apwefn(53);
        System.out.println(a);

        byte b = obj.fuireew(a);
        System.out.println(b);

        obj.quw23e(b);

        try {
            Class c = Class.forName("B9Q9R");
            Object obj1 = c.getConstructor().newInstance();
            java.lang.reflect.Field[] f = B9Q9R.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i].getName() + " " + f[i].get(obj1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
