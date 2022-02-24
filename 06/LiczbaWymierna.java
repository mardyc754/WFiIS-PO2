/**
 * Klasa opisujaca liczby wymierne w postaci licznika i mianownika
 */
public class LiczbaWymierna extends Liczba {
    private int l;
    private int m;
    public LiczbaWymierna(int a, int b)
    {
        l = a;
        m = b;
    }
    public double toDouble()
    {
        return (double) l/ (double) m;
    }

    /**
     * Metoda zwracajaca string przedstawiajacy liczbe
     * @return String, ktory opisuje liczbe
     * w postaci ulamka zwyklego
     */
    public String toString()
    {
        return "" + l + "/" + m;
    }
}