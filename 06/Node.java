/**
 * Klasa pomocnicza, ktora stanowi reprezentacje wezla listy jednokierunkowej
 * opakowujacego obiekt znajdujacy sie w liscie jednokierunkowej
 */
public class Node
{
    private Object value;
    private Node next;

    /**
     * Konstruktor domyslny klasy Node, tworzy pusty wezel
     */
    public Node()
    {
        value = null;
        next = null;
    }

    /**
     * Konstruktor klasy Node, tworzy wezel o podanej wartosci
     * @param obj Obiekt, ktory ma byc przechowywany przez wezel
     */
    public Node(Object obj)
    {
        value = obj;
        next = null;
    }

    /**
     * Getter obiektu przechowywanego przez wezel
     * @return Obiekt przechowywany przez wezel
     */
    public Object getValue(){ return value; }

    /**
     * Setter obiektu przechowywanego przez wezel
     * @param obj Obiekt, ktory ma byc przechowywany przez wezel
     */
    public void setValue(Object obj){ value = obj; }

    /**
     * Zwraca nastepny wezel w liscie jednokierunkowej
     * @return Mastepny wezel w liscie jednokierunkowej
     */
    public Node next(){ return next; }

    /**
     * Wezel podany jako argument metody ustawia jako nastepny w liscie
     * @param n Wezel, ktory ma byc nastepnym w liscie po biezacym
     */
    public void setNextNode(Node n){ next = n; }

    /**
     * Zamienia ze soba zawartosci wezlow
     * @param a Pierwszy wezel
     * @param b Drugi wezel
     */
    public static void swapContents(Node a, Node b){
        Node dummy = new Node(a.getValue());
        a.setValue(b.getValue());
        b.setValue(dummy.getValue());
    }
}