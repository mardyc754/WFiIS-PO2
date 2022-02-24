/**
 * Klasa, ktora moze zawierac w sobie tylko liczby
 * wymierne z przedzialu [0,1]
 */
public class LiczbaOdZeraDoJeden extends Liczba {
    private double num;

    /**
     * Konstruktor klasy LiczbaOdZeraDoJeden
     * @param x Wartosc, jaka ma przyjac liczba. Jesli x jest wieksze
     * od 1, wtedy wartosc x wynosi 1, jesli jest mniejsza od 0, przyjmuje wartosc 0
     */
    public LiczbaOdZeraDoJeden(double x)
    {
        if (x > 1) num = 1;
        else if (x < 0) num = 0;
        else num = x;
    }

    public double toDouble() { return num;}

    public String toString()
    {
        return Double.valueOf(num).toString();
    }

}