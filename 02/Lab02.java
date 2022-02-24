/**
 * Główna klasa programu
 */
public class Lab02
{
    /**
     * glowna funkcja programu
     * @param args argumenty wiersza polecen
     */
    public static void main(String[] args)
    {
        Ksiazka[] books = new Ksiazka[10];

        books[0] = new Ksiazka(15, "Rok 1984");
        books[1] = new Ksiazka(2, "Dżuma");
        books[2] = new Ksiazka(23, "Idiota");
        books[3] = new Ksiazka(7, "Proces");
        books[4] = new Ksiazka(13, "Książę");
        books[5] = new Ksiazka(34, "Lalka");
        books[6] = new Ksiazka(44, "Wesele");
        books[7] = new Ksiazka(21, "Krzyżacy");
        books[8] = new Ksiazka(16, "Mały Książę");
        books[9] = new Ksiazka(19, "Hamlet");

        for(Ksiazka k: books)
        {
            k.printBookDetails();
        }
        System.out.println("Tytul: " + books[6].getTitle());
        System.out.println("ID: " + books[6].getID());
        System.out.println("Utworzono książek: " + Ksiazka.numberOfBooks());
        Biblioteka library = new Biblioteka();
        for(Ksiazka k: books)
        {
            library.dodaj(k);
        }

        System.out.println("Ksiazki w bibliotece:");
        library.wypisz(library.getRoot());

        System.out.println("Wyszukiwanie ksiazki o ID = 23");
        library.wyszukajID(23).printBookDetails();
        System.out.println("Wyszukiwanie ksiazki o tytule \"Lalka\"");
        library.wyszukajTytul("Lalka").printBookDetails();

        System.out.println("\nTest pomiaru czasu - ksiazka \"Wesele\" o id = 44");
        System.out.println("Wyszukiwanie za pomoca ID:");
        library.wyszukajID(44).printBookDetails();
        System.out.println("Wyszukiwanie za pomoca tytulu:");
        library.wyszukajTytul("Wesele").printBookDetails();

    }
}