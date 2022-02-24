import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class Lab01
{
    public static void makeEquations(double a, double b, double c, double d, double e, double f)
    {
        Equation eq = new Equation(a, b, c, d, e, f);
        eq.printEquations();
        System.out.println("W = " + eq.W());
        System.out.println("W_x = " + eq.W_x());
        System.out.println("W_y = " + eq.W_y());
        eq.displayResult();
    }

    public static void main(String[] args)
    {
        //makeEquations(7,2,1,3,4,2);
        makeEquations(2,1,4,1,2,5);
        makeEquations(1,1,1,1,1,1);
        makeEquations(6,3,4,2,1,1);
        //makeEquations(0,2,2,3,0,6);
    }

}

class Equation
{
    private final double a, b, c, d, e, f;

    public Equation(double x, double y, double z,
                    double u, double v, double w)
    {
        a = x;
        b = y;
        c = z;
        d = u;
        e = v;
        f = w;
    }

    public void printEquations()
    {
        System.out.println(a + "x + " + b + "y = " + c);
        System.out.println(d + "x + " + e + "y = " + f);
    }

    public double W()
    {
        return a * e - b * d;
    }

    public double W_x()
    {
        return c * e - b * f;
    }

    public double W_y()
    {
        return a * f - c * d;
    }

    public double[] solveEquation()
    {
        if(Math.abs(W()) < 1e-5)
        {
            return null;
        }
        else
        {
            double[] result = new double[2];
            result[0] = W_x()/W();
            result[1] = W_y()/W();
            return result;
        }
    }

    public void displayResult()
    {
        double[] eqResult = solveEquation();
        if(eqResult != null)
        {
            System.out.println("x = " + eqResult[0] + ", y = " + eqResult[1] + "\n");
            drawEquations();
        }
        else
        {
            System.out.println("Brak lub nieskonczona liczba rozwiazan\n");
        }
    }

    public void drawEquations()
    {
        int imageWidth = 500;
        int imageHeight = 500;
        String filename = "graph.png";

        BufferedImage myPicture = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);

        double[] result = solveEquation();
        if(result != null)
        {
            // ZALOZENIE: przedzial jest symetryczny tj. x in (-r, r), y in (-r, r)
            double r = 5; // "promien" przedzialu

            int interceptABC = - (int) (c/b * (250-10)/r); // wyraz wolny pierwszego rownania we wspolrzednych ekranowych
            int interceptDEF = - (int) (f/e * (250-10)/r); // wyraz wolny drugiego rownania we wspolrzednych ekranowych
            g.drawLine(0, 250, 500, 250);
            g.drawLine(250, 0, 250, 500);
            g.setColor(Color.RED);
            //g.drawLine(10, 250 - (int) (-a/b * 250 * -10/10) + (int) (c/b * 250/10), myPicture.getWidth()- 20, 250 - (int) (-a/b * 250 * 10/10) + (int) (c/b *(250 - 10)/10));
            g.drawLine(10, 250 + (int) (-a/b * 250) + interceptABC, myPicture.getWidth() - 10, 250 - (int) (-a/b * 250) + interceptABC);
            g.setColor(Color.GREEN);
            //g.drawLine(10, 250 - (int) (-d/e * 250 * -10/10) + (int) (f/e *(250 - 10)/10), myPicture.getWidth()- 20, 250 - (int) (-d/e * 250 * 10/10) + (int) (f/e *(250 - 10)/10));
            g.drawLine(10, 250 + (int) (-d/e * 250) + interceptDEF, myPicture.getWidth() - 10, 250 - (int) (-d/e * 250) + interceptDEF);
            //g.drawLine(10, (int) (-d/e * 2 + f/e) * (-250) + 250, myPicture.getWidth() - 10, (int) (-d/e * 2 * 10 + f/e) * 250 + 250);
        }

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }

    }
}