/**
    * klasa odpowiedzialna za konto bankowe
 */
public class Konto
{
    private String id;
    private Kwota k;
    private Konto next;

    /**
        * konstruktor klasy Konto
        * @param i id konta
        * @param kw kwota na koncie
     */
    public Konto(String i, Kwota kw)
    {
        id = i;
        k = new Kwota(kw.getZlotowki(), kw.getGrosze());
        next = null;
    }

    /**
        * Reprezentacja obiektu klasy Konto w postaci stringu 
    */
    public String toString()
    {
        return "[" + id + "]" + " " + k;
    }

    /**
        * Getter stanu konta 
    */
    public Kwota getStan()
    {
        return new Kwota(k.getZlotowki(), k.getGrosze());
    }

    /**
        * Setter stanu konta 
        * @param kwota kwota na podstawie ktorej ustawiany jest stan konta
    */
    public void setStan(Kwota kwota)
    {
        k.setZlotowki(kwota.getZlotowki());
        k.setGrosze(kwota.getGrosze());
    }

    /**
        * Getter id konta 
    */
    public String getId(){ return id; }
    /**
        * Zwraca nastepne konto na liscie 
    */
    public Konto getNext(){ return next; }
    /**
        * Ustawia nastepne konto w liscie
        * @param k konto, ktore ma byc nastepne w liscie 
    */
    public void setNext(Konto k){ next = k; }
}