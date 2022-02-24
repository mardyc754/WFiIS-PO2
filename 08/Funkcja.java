enum Funkcja{
    SIN{
        double wartosc(double x){ return Math.sin(x); }
    },
    ARCSIN{
        double wartosc(double x){
            if(Math.abs(x) > 1.0){
                throw new BladFunkcji();
            }
            return Math.asin(x);
        }
    },
    LN{
        double wartosc(double x){
            if(x <= 0){
                throw new BladFunkcji();
            }
            return Math.log(x);
        }
    };
    double value;

    double wartosc(double x){
        value = x;
        return value; 
    }
}
