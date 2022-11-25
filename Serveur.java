package serveur;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Serveur {
    public void getServeur() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=null;
        Socket s=null;
        BufferedWriter os=null;
        BufferedReader is=null;
        BufferedReader scan=null;
        String reponse=null;
        try{
                System.out.println("Miandry connexion Client...");
                serverSocket = new ServerSocket(9000);
                s = serverSocket.accept();
                System.out.println("Tafiditra");
        }catch(Exception e){
            System.out.println(e);
        }
        try{
                os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                is = new BufferedReader(new InputStreamReader(s.getInputStream()));
                scan = new BufferedReader(new InputStreamReader(System.in));
                while(true) {
                    System.out.println("Client :"+is.readLine());
                    System.out.print("Repondre :");
                    reponse=scan.readLine();
                    os.write(reponse);
                    os.newLine();
                    os.flush();
                }
        }
        catch(Exception e){
            System.out.println("Client deconnecter");
        }
    }
}