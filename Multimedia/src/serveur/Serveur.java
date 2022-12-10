package serveur;

// import javazoom.jl.player.Player;

// import java.io.BufferedInputStream;
// import java.io.FileInputStream;
// import java.util.Scanner;

// import javax.imageio.ImageIO;

// import java.io.*;
// import java.net.*;
// import java.nio.ByteBuffer;
// import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import affichage.ConteneurFenetre;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class Serveur {
    // private Player jlPlayer;
    


    public Serveur() {

    }


    public void get_serveur() throws Exception {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        Socket s=null;

        ServerSocket servsock = new ServerSocket(3000);
  
        Socket socket = servsock.accept();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
        File file = new File("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/images/image_web_1.jpg");
        out.writeUTF(file.getName().toLowerCase());
    
        File fichierMp3 = new File("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/music/see you agin.mp3");
        out.writeUTF(fichierMp3.getName().toLowerCase());
    
        File fichier = new File("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/video/video1.mp4");
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(fichier.getName().toLowerCase());
  
        while(true) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String demande = (String) ois.readObject();
            System.out.println("Ito ilay demande "+demande);
            
    
            if(demande.contains(".jpg")) {
                System.out.println("Hahazo sary tsara be ianao !");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(demande);
        
                /* Envoyer Image */
                OutputStream outputStream=socket.getOutputStream();
                BufferedImage image=ImageIO.read(file);
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                ImageIO.write(image, "jpg",byteArrayOutputStream );
                byte[] size =ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        
                outputStream.write(size);
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.flush();
                System.out.println("Sending image......");
                System.out.println("Flushed "+System.currentTimeMillis());
            }
  
        if(demande.contains(".mp3")) {
            System.out.println("Hahazo hira tsara be ianao !");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(demande);
    
            /* Envoyer Musique */
            FileInputStream inputStream = new FileInputStream(fichierMp3);
            byte[] mybytearray = inputStream.readAllBytes();
    
            
            while (true) {
                System.out.println("Connected");
                System.out.println(socket.getInetAddress());
                out.writeUTF(fichierMp3.getName().toLowerCase());
                out.write(mybytearray);
            }
        }
  
        if(demande.contains(".mp4")) {
            System.out.println("Hahazo video tsara be ianao !");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(demande);
            
            /* Envoyer vidéo */
            try {
                System.out.println("Connecting...");

                InputStream is = new FileInputStream(new File("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/video/video1.mp4"));
                byte[] bytes = new byte[1024];

                OutputStream stream = socket.getOutputStream();
                int count = is.read(bytes, 0, 1024);
                    while (count != -1){
                        stream.write(bytes, 0, 1024);
                        count = is.read(bytes, 0, 1024);
                    }

                    is.close();
                    stream.close();
                    socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
      
    }
    }

} 

