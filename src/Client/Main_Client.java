package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import client.Client;
import serveur.Serveur;

public class Main_Client {
    public static void main(String[] args)throws Exception, ClassNotFoundException{
        
        try{
            Client client=new Client();
            client.getClient();
            
             
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e);
        }
    }
    
}