import java.util.*;

public class Matrix{
    private int N;
    double[][] matrix;
    
    public Matrix(int n){
        matrix = new double[n][n];
        N = n;
        fill();
    }

    public int getN(){ return N; }
    public double[][] getMatrix(){ return matrix; }
    public void fill(){
        Random r = new Random();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j] = r.nextDouble();
            }
        }
    }

    public static Matrix product(Matrix A, Matrix B){
        Matrix C = new Matrix(A.N);
        for(int i=0; i<C.N; i++){
            for(int j=0; j<C.N; j++){
                C.matrix[i][j] = 0.0;
            }
        }

        for(int i=0; i<C.N; i++){
            for(int j=0; j<C.N; j++){
                for(int k=0; k<C.N; k++){
                    C.matrix[i][j] += A.matrix[i][k] * B.matrix[k][j];
                }
            }
        }
        return C;
    }
    
    public void printMatrix(){
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
