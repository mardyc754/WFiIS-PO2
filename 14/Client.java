import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args)
    throws Exception {
        Socket s = new Socket( "localhost", 4321 );
        PrintWriter out = new PrintWriter(s.getOutputStream(), true );
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in) );
        String outs;
        String ins;
        
        String nickname = args.length > 0 ? args[0] : "alfa";
        out.println("[" + nickname + "] " + "HELLO_FROM_CLIENT" + " " + nickname);
        while ( (outs = in.readLine()) != null ) {
            if(outs.equals("EXIT")) break;
            System.out.print("[" + nickname + "] ");
            ins = stdin.readLine();
            if (ins != null) {
                System.out.println(ins);
                out.println(ins);
            }
            
        }
        out.close();  
        in.close();
        stdin.close(); 
        s.close();
    }
}

/*
public class Client {
    public static void main(String[] args)
    throws Exception {
        Socket s = new Socket( "localhost", 4321 );
        PrintWriter out = new PrintWriter(s.getOutputStream(), true );
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in) );
        String outs;
        String ins;

        String nickname = "serstopiony";
        while ( (outs = in.readLine()) != null ) {
            System.out.print("[ " + nickname + "] " + outs);
            ins = stdin.readLine();
            if (ins != null) {
                System.out.println(ins);
                out.println(ins);
            }
        }
        out.close();  
        in.close();
        stdin.close(); 
        s.close();
    }
}
*/
