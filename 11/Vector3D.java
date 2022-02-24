import java.util.ArrayList;
import java.util.List;

public class Vector3D<T> {
    private T x;
    private T y;
    private T z;
    
    public Vector3D(){}

    public Vector3D(T a){ x = a; }

    public Vector3D(T a, T b, T c){
        x = a;
        y = b;
        z = c;
    }

    public String toString(){
        return "(" + x + "," + y + "," + z + ")";
    }

    public T x(){ return x; }
    public T y(){ return y; }
    public T z(){ return z; }

    public Vector3D<T> add(Vector3D<T> v2){
        Number new_x, new_y, new_z;
        if (v2.x() instanceof Integer) {
            new_x = (Integer) x + (Integer) v2.x();
            new_y = (Integer) y + (Integer) v2.y();
            new_z = (Integer) z + (Integer) v2.z();
        }
        else {
            new_x = (Double) x + (Double) v2.x();
            new_y = (Double) y + (Double) v2.y();
            new_z = (Double) z + (Double) v2.z();
        }
        return new Vector3D<T>((T) new_x, (T) new_y, (T) new_z);
    }

    List<T> getList(){
        ArrayList<T> coords = new ArrayList<>();
        coords.add(x);
        coords.add(y);
        coords.add(z);
        return coords;
    }
}
