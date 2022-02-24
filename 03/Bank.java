/**
    * Klasa odpowiedzialna za bank, ktory przechowuje konta w postaci listy jednokierunkowej
 */
public class Bank
{
    private Konto head;
    public Bank()
    {
        head = null;
    } 

    public String toString()
    {

        String result = "";
        int i = 0;
        if(head != null)
        {
            Konto k = head;
            while(k != null)
            {
                result += k + " ; ";
                k = k.getNext();
            }
        }
        return result;
    }
    
    /**
        * tworzy nowe konto
        * @param id id, ktore ma miec nowe konto
     */
    public void utworzKonto(String id)
    {
        Konto k = head;
        if(head != null)
        {
            while(k.getNext() != null)
            {
                k = k.getNext();
            }
        k.setNext(new Konto(id, new Kwota(0, 0)));    
        }
        else
        {
            head = new Konto(id, new Kwota(0, 0));
        }
        
    }

    /**
        * Wplaca kwote na konto o podanym id
        * @param id id konta, na ktore ma byc wplacona kwota
        * @param k kwota, ktora ma byc wplacona
     */
    public void wplataNaKonto(String id, Kwota k)
    {
        Konto kw = head;
        if(head != null)
        {
            while(kw != null)
            {
                if(kw.getId().equals(id))
                {
                    break;
                }
                kw = kw.getNext();
            }   
        }

        kw.setStan(Kwota.dodaj(kw.getStan(), k));
    }

    /**
        * Wyplaca kwote z konta o podanym id
        * @param id id konta, z ktorego ma byc wyplacona kwota
        * @param k kwota, ktora ma byc wyplacona
     */
    public void wyplataZKonta(String id, Kwota k)
    {
        Konto kw = head;
        if(head != null)
        {
            while(kw != null)
            {
                if(kw.getId().equals(id))
                {
                    break;
                }
                kw = kw.getNext();
            }   
        }
        kw.setStan(Kwota.odejmij(kw.getStan(), k));
    }

    /**
        * Zwraca kwote, ktora jest na koncie
        * @param id id konta
        * @return kwota, ktora jest na koncie
     */
    public Kwota stanKonta(String id)
    {
        Konto kw = head;
        if(head != null)
        {
            while(kw != null)
            {
                if(kw.getId().equals(id))
                {
                    break;
                }
                kw = kw.getNext();
            }   
        }
        return kw.getStan();
    }
}