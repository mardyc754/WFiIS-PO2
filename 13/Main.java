import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList("Biezace");
        toDoList.add(new Task(2, "Zrobic pranie"));
        toDoList.add(new Task(7, "Zaliczyc kolokwium"));
        toDoList.add(new Task(8, "Zdac egzamin"));
        toDoList.add(new Task(6, "Posprzatac pokoj"));

        ToDoList anotherList = new ToDoList("Marzenia");
        toDoList.add(new Task(6, "Pojechac dookola swiata"));
        toDoList.add(new Task(9, "Wygrac 6 w totolotka"));
        toDoList.add(new Task(1, "Poleciec na Marsa"));
        
        ArrayList <ToDoList> toDoLists = new ArrayList<>();
        toDoLists.add(toDoList);
        toDoLists.add(anotherList);

        ToDoListManager toDoListManager = null;

        try{
            FileInputStream objFile = new FileInputStream("todolists.obj");

            ObjectInputStream is = new ObjectInputStream(objFile);
            toDoLists = (ArrayList<ToDoList>) is.readObject();
            is.close();
            objFile.close();

            ObjectOutputStream osBackup = new ObjectOutputStream(
                    new FileOutputStream("todolists.obj.bak") );
            osBackup.writeObject(toDoLists);
            osBackup.close();

            char c;
            int n;
            toDoListManager = new ToDoListManager(toDoLists);
            toDoListManager.mainMenuLoop();
        } catch (FileNotFoundException e){
            System.out.println("Plik todolist.obj nie istnieje");
        }   catch (Exception e){
            System.out.println("Blad przy odczytywaniu pliku!");
        }

        try{
            ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream("todolists.obj") );
            if(toDoListManager != null) {
                os.writeObject(toDoListManager.getToDoLists());
            }
            os.close();
        } catch(IOException e){
            System.out.println("Blad!");
        }

    }   
}
