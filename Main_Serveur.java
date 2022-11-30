package serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import serveur.Serveur;

public class Main_Serveur {
    public static void main(String[] args) {
        try{
            Serveur serveur = new Serveur();
            serveur.getServeur();
            // serveur.Play("see you again.mp3");
  
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e);
        }
    }
}
