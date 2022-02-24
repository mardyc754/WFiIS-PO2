import java.io.*;
import java.util.ArrayList;

public class ToDoListManager {
    ArrayList<ToDoList> toDoLists;

    public ToDoListManager(ArrayList<ToDoList> toDoLists){
        this.toDoLists = toDoLists;
    }
    ArrayList<ToDoList> getToDoLists(){ return toDoLists; }

    public void mainMenuLoop() {
        while (true) {
            try {
                System.out.println("Menu glowne");
                System.out.println("a) Utworz nowa liste zadan");
                System.out.println("b) Wybierz jedna z list");
                System.out.println("c) Zakoncz");
                System.out.println("d) Zapisz liste do pliku tekstowego");
                System.out.println("e) Wczytaj liste z pliku tekstowego");

                int n;
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                char c = (char) (n = stdin.read());
                if (c == 'a') {
                    createNewToDoList();
                } else if (c == 'b') {
                    listManagenentSubmenu();
                } else if (c == 'c') {
                    break;
                }
                else if (c == 'd'){
                    saveListToTextFileSubmenu();
                }
                else if(c == 'e'){
                    loadListFromTextFileSubmenu();
                }
            } catch (IOException e) {
                System.out.println("IOException!");
            }
        }
    }

    public void createNewToDoList() throws IOException{
        String line;
        BufferedReader listNameStdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwe listy");
        if ((line = listNameStdin.readLine()) != null) {
            ToDoList newToDoList = new ToDoList(line);
            toDoLists.add(newToDoList);
            System.out.println("Utworzono nowa liste");
            System.out.println("Twoje listy: ");
            System.out.println(toDoLists);
        }
    }

    public void listManagenentSubmenu() throws IOException{
        String line;
        BufferedReader listChoiceStdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wybierz liste: ");
        for (int i = 1; i <= toDoLists.size(); i++) {
            System.out.println("" + i + ") " + toDoLists.get(i - 1).getName());
        }
        int index;
        ToDoList chosenToDoList = null;
        try {
            if ((line = listChoiceStdin.readLine()) != null) {
                index = Integer.parseInt(line);
                --index;
                if (index >= toDoLists.size() || index < 0) {
                    System.out.println("Liczba z poza zakresu!");
                }
                else {
                    chosenToDoList = toDoLists.get(index);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("To nie liczba!");
        }

        if (chosenToDoList != null) {
            toDoListSubmenu(chosenToDoList);
        }

    }

    public void toDoListSubmenu(ToDoList chosenToDoList){
        label:
        while (true) {
            System.out.println("b) Wybrana lista");
            System.out.println(chosenToDoList);
            System.out.println("i) Nowe zadanie");
            System.out.println("ii) Usun zadanie");
            System.out.println("iii) Powrot do menu glownego");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            int n;
            try {
                String line =  stdin.readLine();
                switch (line) {
                    case "i":
                        addTaskToToDoList(chosenToDoList);
                        break;
                    case "ii":
                        removeTaskFromToDoList(chosenToDoList);
                        break;
                    case "iii":
                        break label;
                }
            } catch(IOException e){
                System.out.println("IOException!");
            }
        }
    }

    public void addTaskToToDoList(ToDoList chosenToDoList) throws IOException{
        String line;
        String taskDescription = "";
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj opis zadania:");
        if ((line = stdin.readLine()) != null) {
            taskDescription = line;
        }

        while(true) {
            System.out.println("Podaj priorytet zadania [1-10]:");
            try {
                if ((line = stdin.readLine()) != null) {
                    int priority = Integer.parseInt(line);


                    if (priority > 0 && priority < 11) {
                        Task newTask = new Task(priority, taskDescription);
                        chosenToDoList.add(newTask);
                        System.out.println("Pomyslnie dodano zadanie");
                        break;
                    } else {
                        System.out.println("Podana liczba nie miesci sie w zakresie");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie liczba. Sprobuj ponownie");
            }
        }
    }

    public void removeTaskFromToDoList(ToDoList chosenToDoList) throws IOException {
        String line;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Wybierz zadanie do usuniecia:");
            System.out.println(chosenToDoList);
            try {
                if ((line = stdin.readLine()) != null) {
                    int taskNumber = Integer.parseInt(line);

                    if (taskNumber > 0 && taskNumber <= chosenToDoList.size()) {
                        chosenToDoList.remove(taskNumber - 1);
                        System.out.println("Pomyslnie usunieto zadanie");
                        break;
                    } else {
                        System.out.println("Podana liczba nie miesci sie w zakresie");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie liczba. Sprobuj ponownie");
            }
        }
    }

    public void saveListToTextFileSubmenu(){
        String line;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Wybierz listę do zapisania: ");
            for (int i = 1; i <= toDoLists.size(); i++) {
                System.out.println("" + i + ") " + toDoLists.get(i - 1).getName());
            }

            try {
                if ((line = stdin.readLine()) != null) {
                    int toDoListNumber = Integer.parseInt(line);

                    if (toDoListNumber > 0 && toDoListNumber <= toDoLists.size()) {
                        saveListToTextFile(toDoLists.get(toDoListNumber-1));

                        System.out.println("Pomyslnie zapisano liste do pliku");
                        break;
                    } else {
                        System.out.println("Podana liczba nie miesci sie w zakresie");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("To nie liczba. Sprobuj ponownie");
            } catch (IOException e){
                System.out.println("Blad przy zapisywaniu pliku!");
            }
        }
    }

    public void saveListToTextFile(ToDoList chosenToDoList) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(chosenToDoList.getName() + ".txt"));

        for(Task t: chosenToDoList.get()){
            out.write(t.getPriority() + " " + t.getDescription() + "\n");
        }
        out.close();
    }

    public void loadListFromTextFileSubmenu(){
        String line;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj nazwe pliku, z ktorego ma byc pobrana lista: ");
        System.out.println("FORMAT PLIKU: na poczatku kazdej linii musi byc liczba okreslajaca priorytet, " +
                "a nastepnie po spacji ma znajdowac sie opis zadania");
        try {
            if ((line = stdin.readLine()) != null
                    && line.split("\\.", 2 ).length == 2
                    && line.split("\\.", 2 )[1].equals("txt")){
                loadListFromTextFile(line);
            }
            else{
                System.out.println("Niewlasciwa nazwa pliku: musi miec on rozszerzenie .txt");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku o podanej nazwie");
        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }

    public void loadListFromTextFile(String filename) throws IOException{
        BufferedReader file = new BufferedReader( new FileReader(filename));

        String line;

        ToDoList newToDoList = new ToDoList(filename.split("\\.", 2 )[0]);
        int i = 0;
        while((line=file.readLine()) != null){
            i++;
            try {
                String[] segments = line.split(" ", 2);
                int priority = Integer.parseInt(segments[0]);

                if(priority > 0 && priority <= 10) {
                    Task t = new Task(priority, segments[1]);
                    newToDoList.add(t);
                }
                else{
                    System.out.println("W linii nr " + i + " podano niewlasciwy priorytet");
                }
            } catch(NumberFormatException e){
                System.out.println("Niewlasciwy format linii");
            }
        }
        toDoLists.add(newToDoList);
        System.out.println("Pomyslnie dodano liste");
    }

}
