/**
 * Glowna klasa programu
 */
public class Main
{
    /**
     * Glowna funkcja programu
     * @param args Argumenty wiersza polecen
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insert(1);
        lista.insert("abc");
        lista.insert(1.2);
        lista.insert(2);
        lista.insert(new int[]{1, 2, 3});
        lista.insert("xyz");
        System.out.println(lista);
        System.out.println("Rozmiar listy: " + lista.size());
        System.out.println("Pierwszy element listy: " + lista.getFirst());
        System.out.println("Ostatni element listy: " + lista.getLast());
        System.out.println("Trzeci element z listy: " + lista.getIElement(3));
        System.out.println("Usuwamy trzeci element z listy: ");
        lista.deleteIElement(3);
        System.out.println(lista);
        System.out.println("Usuwamy cala liste:");
        lista.clear();
        System.out.println(lista);

        System.out.println("Lista liczb:");
        ListaLiczb numbers = new ListaLiczb();
        numbers.insert(new LiczbaWymierna(1, 2));
        numbers.insert(new LiczbaOdZeraDoJeden(0.4));
        numbers.insert(new LiczbaOdZeraDoJeden(3.14));
        numbers.insert(new LiczbaWymierna(3,4));
        numbers.insert( 0.2); //test
        numbers.insert( "xyz"); //test
        numbers.insert(new LiczbaWymierna(10,8));
        numbers.insert(new LiczbaOdZeraDoJeden(0.34));
        System.out.println(numbers);

        System.out.println("Najwiekszy element z listy: " + numbers.findMaxNumber());
        System.out.println("Najmniejszy element z listy: " + numbers.findMinNumber());
        System.out.println("Elementy z listy liczb:");
        double[] numbersArr = numbers.listOfNumbers();
        for(double x: numbersArr)
        {
            System.out.print(x + ", ");
        }
        System.out.print("\n");

        System.out.println("Srednia z elementow z listy liczb: " + numbers.average());
        System.out.println("Sortowanie listy: ");
        numbers.sortList();
        System.out.println(numbers);
    }
}