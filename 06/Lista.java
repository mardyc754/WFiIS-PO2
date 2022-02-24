/**
 * Klasa implementujaca liste jednokierunkowa obiektow
 * dowolnego typy
 */
public class Lista
{
    /**
     * Pierwszy wezel listy jednokierunkowej
     */
    protected Node head;
    /**
     * Rozmiar listy jednokierunkowej
     */
    protected int size;

    /**
     * Konstruktor domyslny klasy Lista, tworzy pusta liste
     */
    public Lista() {
        head = null; 
    }

    /**
     * Konstruktor klasy Lista, tworzy liste o wezle poczatkowym podanym
     * jako argument konstruktora
     * @param obj Obiekt, ktory ma byc wezlem poczatkowym listy
     */
    public Lista(Object obj) { 
        head = new Node(obj); 
        size = 1;
    }

    /**
     * Metoda zwracajaca zawartosc listy w postaci stringu
     * @return Zawartosc listy wypisana jako string
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder("head -> ");
        Node current = head;
        while(current != null)
        {
            str.append(current.getValue().toString()).append(" -> ");
            current = current.next();
        }
        str.append("null");
        return str.toString();
    }

    /**
     * Wstawia obiekt na koniec listy jednokierunkowej
     * @param obj Obiekt, ktory ma byc wstawiony do listy jednokierunkowej
     */
    public void insert(Object obj)
    {
        if(head == null)
        {
            head = new Node(obj);
            head.setNextNode(null);
        }
        else
        {
            Node current = head;
            while(current.next() != null)
            {
                current = current.next();
            }
            current.setNextNode(new Node(obj));
        }

        size++;
    }

    /**
     * Metoda zwracajaca rozmiar listy jednokierunkowej
     * @return Rozmiar listy jednokierunkowej
     */
    public int size(){ return size; }

    /**
     * Metoda zwracajaca pierwszy element listy jednokierunkowej
     * @return Pierwszy element listy jednokierunkowej
     */
    public Object getFirst(){ return head.getValue(); }

    /**
     * Metoda zwracajaca ostatni element listy jednokierunkowej
     * @return Ostatni element listy jednokierunkowej
     */
    public Object getLast(){ 
        Node current = head;
        while(current.next() != null)
        {
            current = current.next();
        }
        return current.getValue();
    }

    /**
     * Funkcja zwracajaca i-ty element w kolejnosci z listy jednokierunkowej
     * @param i Numer elementu na liscie
     * @return I-ty element z listy
     */
    public Object getIElement(int i)
    {
        Node current = head;
        for(int j=1; j<i; j++)
        {
            current = current.next();
        }
        return current.getValue();
    }

    /**
     * Usuwa element z listy bedacy na i-tej pozycji
     * @param i Pozycja elementu, ktory ma byc usuniety
     */
    public void deleteIElement(int i)
    {
        Node previous = head;
        Node current = head;
        Node next = current.next();

        if(head != null)
        {
            for(int j=1; j<i; j++)
            {
                previous = current;
                current = current.next();
                next = current.next();
            }
            previous.setNextNode(null);
            previous.setNextNode(next);
            size--;
        }
    }

    /**
     * Metoda usuwajaca cala zawartosc listy
     */
    public void clear()
    {
        Node current = head;
        Node next;
        while(current != null)
        {
            next = current.next();
            current.setValue(null);
            current = null;
            current = next;
        }
        head = null;
        size = 0;
    }
}

