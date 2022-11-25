package client;

import java.io.*;
import java.net.*;


public class Client {
    public void getClient()throws IOException, ClassNotFoundException{
        Socket socket=null;
        BufferedWriter os=null;
        BufferedReader is=null;
        BufferedReader scan=null;
        String answer;
        try{
            socket = new Socket("localhost",9000);
            os = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            scan = new BufferedReader(new InputStreamReader(System.in));
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            while(true){
                //ecrire un nouveau message
                System.out.print("New Message : ");
                answer=scan.readLine();
                os.write(answer);
                os.newLine();
                os.flush();
                System.out.println("Serveur:"+(String) is.readLine());
            }
        }
        catch(Exception e){
            System.out.println("Serveur non connecter");
        }
    }
}