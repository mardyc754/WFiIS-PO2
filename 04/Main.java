import java.io.*;

/**
 * glowna klasa programu
 */
public class Main
{
    /**
     * glowna funkcja programu
     * @param args argumenty wiersza polecen
     */
    public static void main(String[] args)
    {
        FileContentHandler file = new FileContentHandler("lab04-heart-of-darkness.txt");

        file.printFirstAndLastNLines(3);
        System.out.println("Liczba słów w pliku: " + file.getWordCount());

        file.sortDuration();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Podaj indeks elementu w posortowanej tablicy słów (od 0 do " + (file.getWordCount()-1)+"): ");
        try
        {
            String s = stdin.readLine();
            System.out.println("Słowo o podanym indeksie to: " + file.getWordByIndex(Integer.parseInt(s)));
        }
        catch(Throwable e){ System.out.println("Błąd!"); }


        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Podaj liczbe n (od 0 do " + (file.getDifferentWordCount()-1)+")," +
                "a program wyświetli N najczęściej występujących słów:");
        try
        {
            String s = stdin.readLine();
            System.out.println("Top " + s + " najczesciej występujących słów w pliku:");
            file.printNMostFrequentWords(Integer.parseInt(s));
        }
        catch(Throwable e){ System.out.println("Błąd!"); }

    }
}