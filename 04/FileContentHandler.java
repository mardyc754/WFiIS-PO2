import java.io.*;
import java.util.*;

/**
 * klasa odpowiedzialna za obsluge pliku tekstowego
 */
public class FileContentHandler
{
    private int lineCount;

    /**
     * getter liczby slow w pliku
     * @return zwraca liczbe slow w pliku
     */
    public int getWordCount() {
        return wordCount;
    }

    private int wordCount;

    private String[] lines;

    private String[] words;

    /**
     * getter unikatowej liczby slow
     * @return zwraca liczbe unikatowych slow
     */
    public int getDifferentWordCount() {
        return differentWordCount;
    }

    private int differentWordCount;
    private boolean isSorted;
    private int[][] wordFrequencies;
    private String[] differentWords;

    /**
     * Konstruktor klasy FileContentHandler
     * @param filename nazwa pliku tekstowego, z ktorego ma byc pobrana tresc
     */
    public FileContentHandler(String filename) {
        try {
            BufferedReader f = new BufferedReader(new FileReader(filename));
            String s;
            while ((s = f.readLine()) != null) {
                lineCount++;
            }
            f.close();
        } catch (Throwable e) {
            System.out.println("Błąd odczytu pliku!");
        }
        createLines(filename);
        setWordCount();
        createWords();
        countDifferentWords();
    }

    /**
     * rozdziela zawartosc pliku na linie
     * @param filename nazwa pliku tekstowego, z ktorego ma byc pobrana tresc
     */
    private void createLines(String filename)
    {
        lines = new String[lineCount];
        try
        {
            BufferedReader f = new BufferedReader(new FileReader(filename));
            String s;
            int i = 0;
            while ((s = f.readLine()) != null)
            {
                lines[i] = s;
                i++;
            }
            f.close();
        } catch (Throwable e)
        {
            System.out.println("Błąd odczytu pliku!");
        }
    }

    /**
     * ustawia liczbe slow
     */
    private void setWordCount()
    {
        for (String line : lines)
        {
            String[] wordsLine = line.split("\\s");
            for (String s : wordsLine)
            {
                if (s != null)
                    wordCount++;
            }
        }
    }

    /**
     * Tworzy tablice slow na podstawie talicy linii
     */
    private void createWords()
    {
        words = new String[wordCount];
        int k = 0;
        for (int i = 0; i < lineCount; i++)
        {
            String[] line = lines[i].split("\\s");
            for (String s : line)
            {
                if (s != null)
                {
                    words[k] = s;
                    k++;
                }
            }
        }
    }

    /**
     * Funkcja obliczajaca liczbe unikatowych slow w pliku tekstowym
     */
    private void countDifferentWords()
    {
        String[] sortedWords = isSorted ? words : getSortedWords();
        String temp = "";
        for(String s: sortedWords)
        {
            if(!temp.equals(s))
            {
                differentWordCount++;
                temp = s;
            }
        }
    }

    /**
     * Wypisuje wszystkie linie pliku na ekran
     */
    public void printAllLines()
    {
        for (String s : lines)
        {
            System.out.println(s);
        }
    }

    /**
     * Wypisuje pierwsze i ostatnie n linii pliku
     * @param n okresla ile pierwszych i ostatnich linii ma byc wypisane
     */
    public void printFirstAndLastNLines(int n)
    {
        System.out.println("Pierwsze " + n + " linii:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(lines[i]);
        }

        System.out.println("Ostatnie " + n + " linii:");
        for (int i = n - 1; i >= 0; i--)
        {
            System.out.println(lines[lineCount - 1 - i]);
        }
    }

    /**
     * Wypisuje slowa na ekran
     */
    public void printWords()
    {
        for (String s : words)
        {
            System.out.print(s + " ");
        }
    }

    /**
     * Porownuje dwie metody Javy sortowania tablic - normalna i rownolegla
     */
    public void sortDuration()
    {
        String[] wordsCopy = new String[words.length];
        for(int i=0; i<words.length; i++)
        {
            wordsCopy[i] = words[i];
        }

        long start = System.currentTimeMillis();
        Arrays.sort(words);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Sortowanie zwykłe: " + timeElapsed + "ms");

        start = System.currentTimeMillis();
        Arrays.parallelSort(wordsCopy);

        finish = System.currentTimeMillis();
        timeElapsed = finish - start;
        System.out.println("Sortowanie równoległe: " + timeElapsed + "ms");
        isSorted = true;
    }

    /**
     * Tworzy posortowana kopie tablicy slow
     * @return Zwraca posortowana kopie tablicy slow
     */
    public String[] getSortedWords()
    {
        String[] wordsCopy = new String[words.length];
        for(int i=0; i<words.length; i++)
        {
            wordsCopy[i] = new String(words[i]);
        }

        Arrays.sort(wordsCopy);
        return wordsCopy;
    }

    /**
     * Funkcja zwracajaca slowo o podanym indeksie
     * @param i Indeks szukanego slowa
     * @return Zwraca slowo z tablicy words o podanym indeksie
     */
    public String getWordByIndex(int i)
    {
        return words[i];
    }

    /**
     * Wyznacza unikatowe slowa w pliku i czestosc ich wystepowania
     */
    private void wordFrequency()
    {
        // tablica zlozona z 2-elementowych tablic, gdzie
        // 1 element - id unikatowego stringu
        // 2 element - liczba wystapien danego stringu
        wordFrequencies = new int[differentWordCount][2];
        differentWords = new String[differentWordCount];

        String temp = "";
        int i = -1;
        for(String s: words)
        {

            if(!s.equals(temp))
            {
                i++;
                differentWords[i] = new String(s);
                temp = s;
                wordFrequencies[i][0] = i;

            }
            if(i > -1) wordFrequencies[i][1]++;
        }
        Arrays.sort(wordFrequencies, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return -Integer.compare(a[1], b[1]);
            }
        });
    }

    /**
     * Wyswietla N najczesciej wystepujacych slow w pliku
     * @param N Okresla liczbe slow najczescie wystepujacych
     */
    public void printNMostFrequentWords(int N)
    {
        wordFrequency();
        for(int i = 0; i<N; i++)
        {
            System.out.println(differentWords[wordFrequencies[i][0]] + " - " + wordFrequencies[i][1]);
        }
    }

}

