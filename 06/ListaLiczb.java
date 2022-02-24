//import java.util.ArrayList;

/**
 * Klasa implementujaca liste jednokierunkowa obiektow klas dziedziczacych po klasie liczba
 */
public class ListaLiczb extends Lista{
    /**
     * Konstruktor domyslny klasy ListaLiczb implementujacy konstruktor klasy nadrzednej Lista
     */
    public ListaLiczb() {
        super();
    }

    /**
     * Konstruktor klasy ListaLiczb, tworzy liste o wezle poczatkowym podanym
     * jako argument konstruktora
     * @param a Obiekt klasy Liczba, ktory ma byc wezlem poczatkowym listy
     */
    public ListaLiczb(Liczba a) {
        super(a);
    }

    /**
     * Przeslonieta metoda insert() z klasy nadrzednej, ktora ma zapobiegac wstawianiu
     * obiektow niebedacych obiektami klas dziedziczacych po klasie Liczba
     * @param obj Obiekt, ktory ma byc wstawiony do listy jednokierunkowej
     */
    public void insert(Object obj){
        /*throw new UnsupportedOperationException("ListaLiczb przyjmuje tylko " +
                "obiekty z rodziny Liczba");*/
        System.out.println("Nie mozna wstawic " + obj + " - ListaLiczb przyjmuje jedynie obiekty z rodziny Liczba");
    }

    /**
     * Wstawia obiekt klasy dziedziczacej po klasie Liczba na koniec listy jednokierunkowej
     * @param num Liczba, ktora ma byc wstawiona do listy jednokierunkowej
     */
    public void insert(Liczba num) { super.insert(num); }

    /**
     * Wyszukuje wezel posiadajacy liczbe przechowujaca podana wartosc z pewna dokladnoscia.
     * W przypadku nieznalezienia takiego wezla, zwraca null
     * @param value Wartosc, na podstawie ktorej poszukiwany jest wezel
     * @return Wezel posiadajacy obiekt klasy Liczba przechowujacy podana wartosc
     * lub null jesli takowego nie ma
     */
    private Node findNodeWithLiczbaByValue(double value)
    {
        Node current = head;
        if(head != null) {
            while (current != null) {
                Liczba currentLiczba = (Liczba) current.getValue();
                if (Math.abs(currentLiczba.toDouble() - value) < 1e-6) break;
                current = current.next();
            }
        }
        return current;
    }

    /**
     * Znajduje obiekt klasy Liczba posiadajacy liczbe o podanej wartosci
     * @param value Wartosc, na podstawie ktorej poszukiwany jest element
     * @return Obiekt klasy Liczba posiadajacy liczbe o podanej wartosci
     */
    private Liczba findLiczbaByValue(double value)
    {
        Node foundNode = findNodeWithLiczbaByValue(value);
        if (foundNode != null) return (Liczba) foundNode.getValue();
        return null;
    }

    /*private Node findNodeWithMinNumber()
    {
        Node current = head;
        if(head != null)
        {
            Liczba currentLiczba = (Liczba) current.getValue();
            double value = currentLiczba.toDouble();
            while(current != null) {
                currentLiczba = (Liczba) current.getValue();
                value = Math.min(currentLiczba.toDouble(), value);
                current = current.next();
            }
            return findNodeWithLiczbaByValue(value);
        }
        return null;
    }*/


    /**
     * Wyszukuje obiekt klasy Liczba przechowujacy najmniejsza liczbe z listy
     * @return Obiekt klasy Liczba przechowujacy najmniejsza liczbe z listy
     * lub null jesli lista jest pusta
     */
    public Liczba findMinNumber(){
        Node current = head;
        if(head != null)
        {
            Liczba currentLiczba = (Liczba) current.getValue();
            double value = currentLiczba.toDouble();
            while(current != null) {
                currentLiczba = (Liczba) current.getValue();
                value = Math.min(currentLiczba.toDouble(), value);
                current = current.next();
            }
            return findLiczbaByValue(value);
        }
        return null;
    }

    /**
     * Wyszukuje obiekt klasy Liczba przechowujacy najwieksza liczbe z listy
     * @return Obiekt klasy Liczba przechowujacy najwieksza liczbe z listy
     * lub null jesli lista jest pusta
     */
    public Liczba findMaxNumber(){
        Node current = head;
        if(head != null)
        {
            Liczba currentLiczba = (Liczba) current.getValue();
            double value = currentLiczba.toDouble();
            while(current != null) {
                currentLiczba = (Liczba) current.getValue();
                value = Math.max(currentLiczba.toDouble(), value);
                current = current.next();
            }
            return findLiczbaByValue(value);
        }
        return null;
    }

    /**
     * Metoda zwracajaca tablice double liczb opakowanych w obiekty klasy Liczba
     * @return Tablica liczb znajdujacych sie w obiektach klasy Lista
     */
    public double[] listOfNumbers() {
        // wersja wykorzystujaca ArrayList
        /*ArrayList<Double> container = new ArrayList<Double>();
        Node current = head;
        if(head != null)
        {
            while(current != null) {
                Liczba temp = (Liczba) current.getValue();
                container.add(temp.toDouble());
                current = current.next();
            }
            return container.stream().mapToDouble(i -> i).toArray();
        }
        return null;
    }*/
        int containerLength = 0;
        double[] container = new double[containerLength];
        Node current = head;
        if (head != null) {
            while (current != null) {
                Liczba currentLiczba = (Liczba) current.getValue();
                double value = currentLiczba.toDouble();
                double[] tempContainer = new double[containerLength + 1];
                if (containerLength >= 0) System.arraycopy(container, 0, tempContainer, 0, containerLength);
                tempContainer[containerLength] = value;
                container = tempContainer;
                containerLength++;
                current = current.next();
            }
        }
        return container;
    }

    /**
     * Oblicza srednia z liczb znajdujacych sie w liscie jednokierunkowej
     * @return Srednia arytmetyczna z liczb znajdujacych sie w liscie jednokierunkowej
     */
    public double average(){
        double[] numbers = listOfNumbers();
        double sum = 0;
        for(double num: numbers) sum += num;
        return sum / (double) numbers.length;
    }

    /**
     * Sortuje liczby z listy rosnaco za pomoca sortowania babelkowego
     */
    public void sortList()
    {
        Node current = head;
        if(head != null) {
            while(current.next() != null) {
                Node temp = current.next();
                Liczba currentLiczba = (Liczba) current.getValue();
                double currentValue = currentLiczba.toDouble();
                while(temp != null) {
                    Liczba tempLiczba = (Liczba) temp.getValue();
                    double tempValue = tempLiczba.toDouble();
                    if(tempValue < currentValue) Node.swapContents(current, temp);
                    temp = temp.next();
                }
                current = current.next();
            }
        }
    }

}
