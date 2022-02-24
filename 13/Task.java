import java.io.Serializable;
import java.util.Comparator;

public class Task implements Serializable{
    private int priority;
    private String description;

    public Task(int priority, String description){
        this.priority = priority;
        this.description = description;
    }

    public int getPriority(){ return priority; }
    public String getDescription(){ return description; }
    public String toString(){ return "" + description + " " + priority; }

}

class TaskComparator implements Comparator<Task>{
    public int compare(Task a, Task b){
        return -Integer.compare(a.getPriority(), b.getPriority());
    }
}
