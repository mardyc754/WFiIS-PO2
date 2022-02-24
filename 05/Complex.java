public class Complex {
    private double a;
    private double b;
    
    public Complex(){
        a = b = 0;
    }

    public Complex(double x){
        a = x;
    }

    public Complex(double x, double y){
        a = x;
        b = y;
    }

    
    public String toString(){
        return a + " + " + b + "i";
    }

    public void set(double x, double y){
        a = x;
        b = y;
    }
    public void setRe(double x)
    {
        a = x;
    }
    public void setIm(double y){
        b = y;
    }
    public double getRe(){
        return a;
    }
    public double getIm(){
        return b;
    }

    public static Complex add(Complex z, Complex w){
        return new Complex(z.getRe() + w.getRe(), z.getIm() + w.getIm());
    }

    public static Complex subtract(Complex z, Complex w){
        return new Complex(z.getRe() - w.getRe(), z.getIm() - w.getIm());
    }

    public static Complex multiply(Complex z, Complex w){
        double a1 = z.getRe();
        double a2 = w.getRe();
        double b1 = z.getIm();
        double b2 = w.getIm();
        return new Complex(a1*a2 - b1*b2, a1*b2 + a2*b1);
        
    }
    public static Complex divide(Complex z, Complex w){
        double a1 = z.getRe();
        double a2 = w.getRe();
        double b1 = z.getIm();
        double b2 = w.getIm();
        return new Complex((a1*a2 + b1*b2)/(a2*a2+b2*b2), (a2*b1-a1*b2)/(a2*a2+b2*b2));
        
    }

    public static Complex add(Complex z, double y){
        return new Complex(z.getRe(), z.getIm() + y);
    }

    public static Complex subtract(Complex z, double y){
        return new Complex(z.getRe(), z.getIm() - y);
    }

    public static Complex multiply(Complex z, double y){
        return new Complex(z.getRe() * y, z.getIm() * y);
    }
    public static Complex divide(Complex z, double y){
        return new Complex(z.getRe() / y, z.getIm() / y); 
    }

    public static Complex add(double x, Complex w){
        return new Complex(w.getRe() + x, w.getIm());
    }

    public static Complex subtract(double x, Complex w){
        return new Complex(w.getRe() -x, -w.getIm());
    }

    public static Complex multiply(double x, Complex w){
        return new Complex(w.getRe() * x, w.getIm() * x); 
    }
    public static Complex divide(double x, Complex w){
        double a2 = w.getRe();
        double b2 = w.getIm();
        return new Complex((x*a2)/(a2*a2+b2*b2), (-x*b2)/(a2*a2+b2*b2));
         
    }

}
