import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class Pochodna {
    public Pochodna(Funkcja fun){
        this.fun = fun;
    }
    double wartosc(int n, double x){
        double derivative = 0;
        try{
        if(n == 1){
            derivative = (fun.wartosc(x+h/2) - fun.wartosc(x-h/2))/h;
        }
        else if(n == 2){
            derivative = (fun.wartosc(x+h) - 2*fun.wartosc(x) + fun.wartosc(x-h))/(h*h);
        }
        else{ throw new BladPochodnej(); }
        } catch (BladFunkcji e){ throw new BladPochodnej(); }
        return derivative;
    }

    public Pochodna(Calculation calc){
        this.fun = calc.create();
    }
    double[] wartosc(int n, double... vargs){
        double[] tab = new double[vargs.length];
        for(int i=0; i<vargs.length; i++){
            tab[i] = wartosc(n, vargs[i]);
        }
        return tab;
    }

    void setH(double h){ 
        if(h == 0){ throw new BladPochodnej(); }
        this.h = h; }
    Funkcja fun;
    double h = 0.001;

    private int[] params(int i){
        int[] parameters = new int[4];
        double step = 0.1;
        parameters[0] = (int) (i * step * 50); // wspolrzedna x we wsp. ekranowych
        try {
            parameters[1] = (int) (500 - (fun.wartosc(i * step - 5) + 5) * 50); // wartosc funkcji oryginalnej we wsp. ekranowych
        } catch(BladFunkcji e){
            parameters[1] = Integer.MIN_VALUE;
        }
        try {
            parameters[2] = (int) (500 - (wartosc(1, i * step - 5) + 5) * 50); // wartosc pierwszej pochodnej we wsp. ekranowych
        } catch (BladPochodnej e){
            parameters[2] = Integer.MIN_VALUE;
        }
        try {
            parameters[3] = (int) (500 - (wartosc(2, i * step - 5) + 5) * 50); // wartosc drugiej pochodnej we wsp. ekranowych
        }
        catch (BladPochodnej e){
            parameters[3] = Integer.MIN_VALUE;
        }
        return parameters;
    }

    public void drawPochodna(String filename)
    {
        int imageWidth = 500;
        int imageHeight = 500;

        BufferedImage myPicture = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, myPicture.getWidth()-1, myPicture.getHeight()-1);
        g.drawLine(0, 250, 500, 250);
        g.drawLine(250, 0, 250, 500);


        // ZALOZENIE: przedzial jest symetryczny tj. x in (-r, r), y in (-r, r)
        double r = 5; // "promien" przedzialu

        double step = 0.1;

        //przedzial (-5,5) x (-5,5)
        for(int i=0; i<99; i++){
            int[] start = params(i);
            int[] end = params(i+1);
            if(start[1] != Integer.MIN_VALUE && end[1] != Integer.MIN_VALUE) {
                g.setColor(Color.BLUE); // oryginalna funkcja
                g.drawLine(start[0], start[1], end[0], end[1]);
            }

            if(start[2] != Integer.MIN_VALUE && end[2] != Integer.MIN_VALUE) {
                g.setColor(Color.RED); // pierwsza pochodna
                g.drawLine(start[0], start[2], end[0], end[2]);
            }

            if(start[3] != Integer.MIN_VALUE && end[3] != Integer.MIN_VALUE) {
                g.setColor(Color.GREEN); // druga pochodna
                g.drawLine(start[0], start[3], end[0], end[3]);
            }
        }
        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }

    }
}

interface Calculation{
   Funkcja create();
}
