import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

       /*
		//testowe - dla zad 1
	   ArrayList<Punkt> pointsTest = new ArrayList<>();

        BufferedReader stdin = new BufferedReader(
                new InputStreamReader( System.in ) );
        String line;
        double x = 0.0;

        System.out.print( "Podaj punkt: " );
        while(true) {
            try {
                if ((line = stdin.readLine()) != null && !line.isEmpty()) {
                    //x = Double.valueOf(line);
                    if(line.charAt(0) == '.'){
                        break;
                    }
                    String[] numbers = line.split(" ");

                    if(numbers.length == 2) {
                        Punkt p = new Punkt(Double.valueOf(numbers[0]), Double.valueOf(numbers[1]));
                        pointsTest.add(p);
                    }
                    else{
                        System.out.println("Za mało lub za dużo danych");
                    }
                }
                //System.out.println("sqrt(x)=" + Math.sqrt(x));
                //System.out.println("sqrt(x)=" + Math.sqrt(x));
            } catch (EOFException e) {
                break;
            }
            catch (IOException e) {
                System.err.println("IOException!");
            }
            catch (NumberFormatException e) {
                System.err.println("Niewłaściwe dane!");
            }
        }

        System.out.println("Podales punkty: ");
        for(Punkt p: pointsTest){
            System.out.println(p);
        }*/
	
		// od zad 2
        ArrayList<Punkt> points = new ArrayList<>();

        BufferedReader stdin = new BufferedReader(
                new InputStreamReader( System.in ) );

        String line;
        double x = 0.0;

        int totalLines = 0;
        int ignoredLines = 0;
        int readLines = 0;
        System.out.println( "Podaj punkty: " );
        while(true) {
            try {
                if ((line = stdin.readLine()) != null && !line.isEmpty()) {
                    if(line.charAt(0) == '.'){
                        break;
                    }

                    int startCommentIndex = line.indexOf("#");
                    if(startCommentIndex != -1){
                        line = line.substring(0, startCommentIndex);
                    }

                    String[] numbers = line.split(" ");

                    if(numbers.length >= 2) {
                        Punkt p = new Punkt(Double.valueOf(numbers[0]), Double.valueOf(numbers[1]));
                        points.add(p);
                        readLines++;
                    }
                    else {
                        System.out.println("Za mało danych");
                    }
                }
            } catch (EOFException e) {
                break;
            }
            catch (IOException e) {
                System.err.println("IOException!");
            }
            catch (NumberFormatException e) {
                System.err.println("Niewłaściwe dane!");
            }
            totalLines++;
        }

        System.out.println("Podales punkty: ");
        for(Punkt p: points){
            System.out.println(p);
        }
        ignoredLines = totalLines - readLines;

        System.out.println("Lacznie linii: " + totalLines);
        System.out.println("Wczytano punktow: " + readLines);
        System.out.println("Zignorowano linii: " + ignoredLines);

        Collections.sort(points, new PunktXComparator());

        System.out.println("Punkty po posortowaniu: ");
        for(Punkt p: points){
            System.out.println(p);
        }

        double xMin = Collections.min(points, new PunktXComparator()).getX();
        double xMax = Collections.max(points, new PunktXComparator()).getX();
        System.out.println("Najmniejsza wartosc x: " + xMin);
        System.out.println("Najwieksza wartosc x: " + xMax);

        double yMin = Collections.min(points, new PunktYComparator()).getY();
        double yMax = Collections.max(points, new PunktYComparator()).getY();
        System.out.println("Najmniejsza wartosc y: " + yMin);
        System.out.println("Najwieksza wartosc y: " + yMax);

        double xAvg = 0.0;
        double yAvg = 0.0;
        for(Punkt p: points){
            xAvg += p.getX();
            yAvg += p.getY();
        }

        xAvg /= points.size();
        yAvg /= points.size();

        double D = 0;
        for(Punkt p: points){
            D += Math.pow(p.getX() - xAvg, 2);
        }

        double a = 0;
        for (Punkt p: points){
            a += p.getY() * (p.getX() - xAvg);
        }

        a /= D;

        double b = yAvg - a*xAvg;

        double Sy = 0.0;
        for (Punkt p: points){
            Sy += Math.pow(p.getY() - (a*p.getX() + b),2);
        }
        Sy /= points.size()-2;
        Sy = Math.sqrt(Sy);

        double uA = Sy/Math.sqrt(D);
        double uB = Sy + Math.sqrt(1.0/points.size() + xAvg*xAvg/D);

        System.out.println("Parametry dopasowanej prostej: ");
        System.out.printf("a = %.3f\n", a);
        System.out.printf("b = %.3f\n", b);
        System.out.printf("u(a) = %.3f\n", uA);
        System.out.printf("u(b) = %.3f\n", uB);


        int imageWidth = 500;
        int imageHeight = (int) (500 * Math.abs((yMax-yMin)/(xMax-xMin)));

        String filename = "wykres.png";

        BufferedImage myPicture = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, myPicture.getWidth(), myPicture.getHeight());

        // prosta
        g.setColor(Color.BLUE);

        double y1 = a*xMin + b;
        double y2 = a*xMax + b;
        int y1Screen = (int) (imageHeight - (y1-yMin)*imageHeight/(yMax-yMin));
        int y2Screen = (int) (imageHeight - (y2-yMin)*imageHeight/(yMax-yMin));

        g.drawLine(0, y1Screen, 500, y2Screen);

        // punkty
        g.setColor(Color.RED);

        for(Punkt p: points){
            int pointXScreen = (int) (imageWidth - (xMax-p.getX())*imageWidth/(xMax-xMin));
            int pointYScreen = (int) (imageHeight - (p.getY()-yMin)*imageHeight/(yMax-yMin));
            g.drawLine(pointXScreen-5, pointYScreen-5, pointXScreen+5, pointYScreen+5);
            g.drawLine(pointXScreen-5, pointYScreen+5, pointXScreen+5, pointYScreen-5);
        }

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }

    }
}
