/**
 * Klasa tworząca drzewo binarne książek
 */
public class Biblioteka
{
    private Ksiazka root;

    /**
     * Getter korzenia drzewa binarnego książek
     * @return Zwraca korzen drzewa binarnego
     */
    public Ksiazka getRoot() { return root; }

    /**
     * Wstawia książkę do drzewa binarnego
     * @param k książka, która ma być wstawiona do drzewa binarnego
     */
    public void dodaj(Ksiazka k)
    {
        Ksiazka y = null;
        Ksiazka x = root;
        while(x != null)
        {
            if(k.getID() == x.getID())
            {
                return;
            }
            y = x;
            x = (k.getID() < x.getID()) ? x.getLeftChild() : x.getRightChild();
        }
        k.setParent(y);

        if(y == null)
            root = k;
        else if(k.getID() < y.getID())
        {
            y.setLeftChild(k);
        }
        else
        {
            y.setRightChild(k);
        }
    }

    /**
     * Wypisuje rekurencyjnie drzewo binarne książek
     * @param k Książka, od której ma się rozpocząć wypisywanie
     * @param indent Liczba tabulatorów występująca przed opisem książki
     */
    private void wypiszRekurencyjnie(Ksiazka k, int indent)
    {
        if(k != null)
        {
            for(int i=0; i<indent; i++)
            {
                System.out.print("\t");
            }
            k.printBookDetails();
            wypiszRekurencyjnie(k.getLeftChild(), indent+1);
            wypiszRekurencyjnie(k.getRightChild(), indent+1);
        }
    }

    /**
     * Wypisuje zawartość drzewa binarnego korzystając z rekurencji
     * @param k Książka, od której ma się rozpocząć wypisywanie
     */
    public void wypisz(Ksiazka k)
    {
        wypiszRekurencyjnie(k ,0);
        System.out.println();
    }
   /*
    /**
     * Metoda, która szuka książki po tytule przechodząc inorder po drzewie binarnym
     * @param k Książka, od której ma się rozpocząć wyszukiwanie
     * @param value Tytuł, po którym szukana jest książka
     * @return Zwraca książkę o podanym tytule lub null jeśli w drzewie binarnym nie znaleziono
     * książki o podanym tytule
     private Ksiazka bibliotekaInorder(Ksiazka k, String value)
    {
        if(k.getTitle().equals(value))
        {
            return k;
        }
        else
        {
            if(k.getLeftChild() != null)
            {
                return bibliotekaInorder(k.getLeftChild(), value);
            }
            if(k.getRightChild() != null) {
                return bibliotekaInorder(k.getRightChild(), value);
            }
            if(k.getLeftChild() == null && k.getRightChild() == null && root.getRightChild() != null )
            {
                return bibliotekaInorder(root.getRightChild(), value);
            }
        }
        return null;
    }*/

    /**
     * Szuka książki o najmniejszej wartości ID w drzewie binarnym
     * @param k Książka, od której ma się rozpocząć wyszukiwanie
     * @return Zwraca książkę o najmniejszym ID w drzewie binarnym
     */
    private Ksiazka libMinimum(Ksiazka k)
    {
        while(k.getLeftChild() != null)
        {
            k = k.getLeftChild();
        }
        return k;
    }

    /**
     * Szuka następnej książki w drzewie binarnym według kolejności inorder
     * @param k Książka, od której ma się rozpocząć wyszukiwanie
     * @return Książka, która jest następnikiem bieżącej lub null jeżeli
     * bieżąca książka jest ostatnim węzłem w drzewie binarnym
     */
    private Ksiazka bookSuccessor(Ksiazka k)
    {
        if(k.getRightChild() != null)
        {
            return libMinimum(k.getRightChild());
        }
        Ksiazka y = k.getParent();
        while(y != null && k == y.getRightChild())
        {
            k = y;
            y = y.getParent();
        }
        return y;
    }

    /**
     * Wyszukuje w drzewie binarnym książkę o podanym tytule korzystając z algorytmu poszukiwania następnika w drzewie binarnym
     * @param wartosc Tytuł, po którym poszukiwana jest książka w drzewie binarnym
     * @return Zwraca książkę o podanym tytule lub null jeśli takowej nie znaleziono
     */
    public Ksiazka wyszukajTytul(String wartosc)
    {
        long start = System.nanoTime(); // poczatek pomiaru czasu metody
        //return bibliotekaInorder(root, wartosc);
        //inna wersja - wykorzystuje poszukiwanie nastepnika w drzewie

        Ksiazka k = libMinimum(root);
        while(k != null && !k.getTitle().equals(wartosc))
        {
            k = bookSuccessor(k);
        }
        long finish = System.nanoTime(); // koniec pomiaru czasu metody
        System.out.println("Czas: " + (finish - start) + " ns");
        return k;
    }

    /**
     * Wyszukuje w drzewie binarnym książki o podanym ID
     * @param id ID, po którym szukana jest książka w drzewie binarnym
     * @return Zwraca książkę o podanym ID lub null jeśli takiej nie znaleziono
     */
    public Ksiazka wyszukajID(int id)
    {
        long start = System.nanoTime(); // poczatek pomiaru czasu metody
        Ksiazka k = root;
        while((k != null) && (k.getID() != id))
        {
            if(id < k.getID())
            {
                k = k.getLeftChild();
            }
            else
            {
                k = k.getRightChild();
            }
        }
        long finish = System.nanoTime(); // koniec pomiaru czasu metody
        System.out.println("Czas: " + (finish - start) + " ns");
        return k;
    }
}
