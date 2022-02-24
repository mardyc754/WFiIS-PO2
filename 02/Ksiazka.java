/**
 * Klasa, ktora opisuje daną ksiazke
 * bedaca wezlem drzewa binarnego, ktorym jest klasa Biblioteka
 */
public class Ksiazka
{
    private final int ID;
    private final String title;
    private static int counter;
    private Ksiazka left;
    private Ksiazka right;
    private Ksiazka parent;

    /**
     * Konstruktor klasy Ksiazka
     * @param id Numer ID identyfikujący daną ksiazkę i położenie jej w drzewie binarnym
     * @param t Tytuł książki
     */
    public Ksiazka(int id, String t)
    {
        ID = id;
        title = t;
        counter++;
        left = right = parent = null;
    }

    /**
     * Getter ID
     * @return Zwraca ID książki
     */
    public int getID() { return ID; }

    /**
     * Getter tytułu
     * @return Zwraca tytuł książki
     */
    public String getTitle() { return title; }

    /**
     * Wypisuje informacje na temat książki (tytuł i jej ID)
     */
    public void printBookDetails() { System.out.println("Tytul: " + title + ", ID = " + ID); }

    /**
     * Getter licznika
     * @return zwraca liczbę utworzonych książek w programie
     */
    public static int numberOfBooks() { return counter; }

    /**
     * Getter lewego potomka
     * @return Zwraca książkę, która jest lewym potomkiem bieżącej w drzewie binarnym
     */
    public Ksiazka getLeftChild() { return left; }
    /**
     * Getter prawego potomka
     * @return Zwraca książkę, która jest prawym potomkiem bieżącej w drzewie binarnym
     */
    public Ksiazka getRightChild() { return right; }
    /**
     * Getter rodzica
     * @return Zwraca książkę, która jest rodzicem bieżącej w drzewie binarnym
     */
    public Ksiazka getParent() { return parent; }

    /**
     * Setter, który ustawia lewego potomka dla bieżącej książki
     * @param lc Książka, która ma być lewym potomkiem
     */
    public void setLeftChild(Ksiazka lc) { left = lc; }
    /**
     * Setter, który ustawia prawego potomka dla bieżącej książki
     * @param rc Książka, która ma być prawym potomkiem
     */
    public void setRightChild(Ksiazka rc) { right = rc; }
    /**
     * Setter, który ustawia rodzica dla bieżącej książki
     * @param p Książka, która ma być rodzicem potomkiem
     */
    public void setParent(Ksiazka p) { parent = p; }
}
