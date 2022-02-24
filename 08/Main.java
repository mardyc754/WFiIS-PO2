

public class Main {
    public static void main(String[] args) {
        Pochodna d1 = new Pochodna(Funkcja.SIN);
        d1.drawPochodna("sin.png");
        Pochodna d2 = new Pochodna(Funkcja.ARCSIN);
        d2.drawPochodna("arcsin.png");
        Pochodna d3 = new Pochodna(Funkcja.LN);
        d3.drawPochodna("ln.png");
    }
}
