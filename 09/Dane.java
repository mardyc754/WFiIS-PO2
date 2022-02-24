public class Dane{
    private int num;
    
    public Dane clone() {
        return new Dane(num);
    }

    public Dane(int num){
        this.num = num;
    }

    public void set(int x){ num = x; }
    public int get() { return num; }

    public boolean equals(Object other){
        Dane obj = (Dane) other;
        return obj.get() == num;
    }

    public String toString(){
        return "" + num;
    }

    public int hashCode(){ return num; }

    public int wynik(int x) throws ZaMaloDanychException{ 
        if(num < 10){
            throw new ZaMaloDanychException(num);
        }
        if(x < 0){
            throw new UjemnyParametrException();
        }
        return x;
    }

    public int innyWynik(int x){
        if(x == 5){
            throw new RuntimeException("ZaMaloDanychException: n=" + num);
        }
        return x;
    }

}

class UjemnyParametrException extends ArithmeticException { }


class ZaMaloDanychException extends Exception {
    int x;
    public String getMessage(){ return "n=" + x; }
    public ZaMaloDanychException(){}
    public ZaMaloDanychException(int x){ this.x = x; }
}