package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import serveur.Serveur;


public class Client {
    public void getClient()throws IOException, ClassNotFoundException{
        Socket socket = null;
        try{
            socket = new Socket("localhost",3000);
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Serveur serveur=new Serveur();
            //serveur.getServeur();
            DatagramSocket ds = new DatagramSocket();  
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine() ;
            InetAddress ip = InetAddress.getByName("localhost");  
            
            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(),ip, 3000);  
            ds.send(dp);

            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            serveur.Play(bufferedReader.readLine());


            
            ds.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Serveur non connecter");
        }
    }
}