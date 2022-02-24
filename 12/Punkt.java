import java.util.Comparator;

public class Punkt {

    private double x;
    private double y;

    public Punkt(){
        x = y = 0.0;
    }

    public Punkt(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public String toString(){
        return x + " " + y;
    }

    public static void sort(){}
}

class PunktXComparator implements Comparator<Punkt>{
    public int compare(Punkt a, Punkt b){
        return Double.compare(a.getX(), b.getX());
    }
}

class PunktYComparator implements Comparator<Punkt>{
    public int compare(Punkt a, Punkt b){
        return Double.compare(a.getY(), b.getY());
    }
}