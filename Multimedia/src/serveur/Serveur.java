package serveur;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.awt.image.BufferedImage;

public class Serveur {
    private Player jlPlayer;

    public Serveur() {

    }

    




    public void getServeur() throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = null;
        Socket socket = new Socket();
        
        try{
            System.out.println("Miandry connexion Client...");
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
            System.out.println("Tafiditra");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        try{
            // Serveur serveur = new Serveur();
            // serveur.getServeur();
            DatagramSocket ds = new DatagramSocket(3000);  
            byte[] buf = new byte[1024];  
            DatagramPacket dp = new DatagramPacket(buf, 1024);  
            ds.receive(dp);  
            String str = new String(dp.getData(), 0, dp.getLength());  
            

            Serveur serveur = new Serveur();
            // serverSocket = new ServerSocket(3000);
            // socket = serverSocket.accept();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String reponse = null;
            System.out.println(str);
            reponse = str;
            bufferedWriter.write(reponse);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            

            ds.close();
            // serveur.Play(str);
        }
        catch(Exception e){
            System.out.println("Client deconnecter");
        }
    }




    public String Play(String music) {
        String musique = music;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/music/"+musique);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            jlPlayer = new Player(bufferedInputStream);

        } catch (Exception e) {
            System.out.println("Problem playing mp3 file ");
            System.out.println(e.getMessage());
        }

        new Thread() {
            public void run() {
                try {
                    jlPlayer.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();

        Scanner sc = new Scanner(System.in);

        System.out.println("Write stop to stop the music: ");

        if (sc.nextLine().equalsIgnoreCase("stop")) {
            this.close();
        }

        sc.close();
        return musique;
    }
    
    public void close() {
        if (jlPlayer != null) jlPlayer.close();
    }



    public void send_Image_Serveur() throws Exception{
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        BufferedImage image = ImageIO.read(new File("D:/2eme_Annee/Mr Naina/Streaming/images/"+bufferedReader.readLine()));
    
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());
        Thread.sleep(120000);
        System.out.println("Closing: " + System.currentTimeMillis());
        serverSocket.close();
        socket.close();
    }

    
}
