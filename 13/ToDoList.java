import java.io.*;
import java.util.*;

public class ToDoList implements Serializable{
    
    private ArrayList<Task> tasks = new ArrayList<>();
    private String name;
    public ToDoList(){ name =""; }
    public ToDoList(String name){ this.name = name; } 
    public void add(Task t){ tasks.add(t); }
    public void remove(int i){ tasks.remove(i); }
    public int size(){ return tasks.size(); }

    public ArrayList<Task> get(){ return tasks; }
    public String getName(){ return name; }
    public String toString(){
        tasks.sort(new TaskComparator());
        StringBuilder result = new StringBuilder();
        int i = 1;
        for(Task t: tasks ){
            result.append(i).append(") ").append(t).append("\n");
            i++;
        }
        return result.toString();
    }

}
