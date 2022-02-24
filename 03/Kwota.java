/**
    * Klasa przechowujaca informacje o kwocie - zlotowki i grosze
*/
public class Kwota
{
    private int zlotowki;
    private int grosze;
    /**
        * konstruktor klasy Kwota
        * @param z - ilosc zlotowek
        * @param g - ilosc groszy
     */
    public Kwota(int z, int g)
    {
        zlotowki = z;
        grosze = g;
    }
    /**
        * Reprezentacja obiektu klasy Kwota w postaci stringu 
    */
    public String toString()
    {
        return zlotowki + "zl " + grosze + "gr ";     
    }

    /**
        * Dodaje do siebie dwie kwoty
        * @param left - pierwszy skladnik
        * @param right - drugi skladnik
        * @return nowa kwote
     */
    public static Kwota dodaj(Kwota left, Kwota right)
    {
        int new_zl = left.zlotowki + right.zlotowki;
        int new_gr = left.grosze + right.grosze;
        if(new_gr > 99)
        {
            new_zl++;
            new_gr -= 100;
        }
        Kwota k = new Kwota(new_zl, new_gr);
        return k;
    }

    /**
        * Odejmuje od siebie dwie kwoty
        * @param left - odjemna
        * @param right - odjemnik
        * @return nowa kwote
     */
    public static Kwota odejmij(Kwota left, Kwota right)
    {
        int new_zl = left.zlotowki - right.zlotowki;
        int new_gr = left.grosze - right.grosze;
        if(new_gr < 0)
        {
            new_zl--;
            new_gr = 100 - right.grosze + left.grosze;
        }
        Kwota k = new Kwota(new_zl, new_gr);
        return k;
    }

    /**
        * Ustawia wartosc kwoty
        * @param zl - zlotowki
        * @param right - grosze
     */
    public void set(int zl, int gr)
    {
        zlotowki = zl;
        grosze = gr;
    }

    /**
        * getter parametru zlotowki
    */
    public int getZlotowki(){ return zlotowki; }
    /**
        * getter parametru grosze
    */
    public int getGrosze(){ return grosze; }

    /**
        * setter parametru zlotowki
    */
    public void setZlotowki(int zl){ zlotowki = zl; }
    /**
        * setter parametru grosze
    */
    public void setGrosze(int gr){ grosze = gr; }

}