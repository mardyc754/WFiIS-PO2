import java.util.*;

public class MatrixGeneric<T> {
    private int N;
    Object[][] matrix;
    
    public MatrixGeneric(int n){
        matrix = new Object[n][n];
        N = n;
        fill();
    }

    public int getN(){ return N; }
    public Object[][] getMatrix(){ return matrix; }
    public void fill(){
        Random r = new Random();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                matrix[i][j] = (Double) r.nextDouble();
            }
        }
    }

    public static MatrixGeneric<Double> product(MatrixGeneric<Double> A, MatrixGeneric<Double> B){
        MatrixGeneric<Double> C = new MatrixGeneric<Double>(A.N);
        for(int i=0; i<C.N; i++){
            for(int j=0; j<C.N; j++){
                C.matrix[i][j] = 0.0;
            }
        }
            for(int i=0; i<C.N; i++){
                for(int j=0; j<C.N; j++){
                    for(int k=0; k<C.N; k++){
                        C.matrix[i][j] = (Double) C.matrix[i][j] + (Double) A.matrix[i][k] * (Double) B.matrix[k][j];
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
