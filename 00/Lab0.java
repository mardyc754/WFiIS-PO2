/* Plik Lab0.java */

 public class Lab0 
 {
	public static void main (String[] args) 
	{
        
        TablicaLiczb tab = new TablicaLiczb(50,20);
        tab.print("tab");
        
        System.out.println("Wartosc srednia: " + tab.average());
        System.out.println("Wartosc najmniejsza: " + tab.min_val());
        System.out.println("Wartosc najwieksza: " + tab.max_val());
        System.out.println("Histogram:");
        tab.histogram();
	}
 }



class TablicaLiczb 
{
    
    private double numbers[];
    private int size;
    private int numOfValues;
    
    public TablicaLiczb(int n, int k)
    {
        size = n;
        numOfValues = k;
        numbers = new double[size];
        for(int i=0; i<size; i++)
        {
            numbers[i] = 0.0;
            for(int j=0; j<k; j++)
            {
                numbers[i] += Math.random(); 
            }
        }
    }
    
    public void print(String name)
    {
        for(int i=0; i<size; i++)
        {
            System.out.println(name + "[" + i + "] =" + numbers[i]);
        }
    }
    
    public double average()
    {
        double sum = 0.0;
        for(double el : numbers)
        {
            sum += el;
        }
        return sum/size;
    }
    
    public double min_val()
    {
        double temp = Double.MAX_VALUE;
        for(double el : numbers)
        {
            temp = temp > el ? el : temp;
        }
        return temp;
    }
    
    public double max_val()
    {
        double temp = Double.MIN_VALUE;
        for(double el : numbers)
        {
            temp = temp < el ? el : temp;
        }
        return temp;
    }
    
    public void histogram()
    {
        double min_el = min_val();
        double max_el = max_val();
        int hist[];
        hist = new int[numOfValues];
        for(int i=0; i<numOfValues; i++){
            hist[i] = 0;
        } 
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<numOfValues; j++)
            {
                if(numbers[i] - j < 1.0 && numbers[i] - j > - 1.0)
                {
                hist[j]++;
                }
            } 
        }
        for(int i=0; i<numOfValues; i++)
        {
        System.out.println(hist[i]);
        int temp = hist[i];
        for(int j=0; j<temp; j++)
        {
            System.out.print("*");
        }
            System.out.print("\n"); 
        }
    }
}
 

