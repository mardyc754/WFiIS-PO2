import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) 
    throws Exception {
        InetAddress a = InetAddress.getLocalHost();

        String name = args.length > 0 ? args[0] : "beta";
        while(true){
            ServerSocket ss = new ServerSocket(4321);
            Socket cs = ss.accept();
            System.out.println("[connection from " + a + "]");

            
            PrintWriter out =new PrintWriter(cs.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            String outl = "";
            out.println(outl);
            System.out.println("HELLO_FROM_SERVER " + name);
            String inl;
            
            while ( (inl = in.readLine()) != null ) {
                System.out.println(inl);
                if( inl.equals("q") ) {
                    out.println("EXIT");
                    break;
                }
                out.println(outl);
            }
            out.close();   
            in.close();
            cs.close();    
            ss.close();
        }
    }
}

/*
public class Server {
    public static void main(String[] args) 
    throws Exception {
        InetAddress a = InetAddress.getLocalHost();
        ServerSocket ss = new ServerSocket(4321);
        Socket cs = ss.accept();
        System.out.println("[connection from " + a + "]");

        // true => auto-flush the output buffer:
        PrintWriter out =new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        //String outl = "Napisz cos [’q’ konczy]";
        //out.println(outl);
        String inl;
        while ( (inl = in.readLine()) != null ) {
            if( inl.equals("q") ){ 
                out.println("EXIT");
                break;
            }
            out.println("Otrzymano wiadomosc");
        }
        out.close();   
        in.close();
        cs.close();    
        ss.close();
    }
}
*/
