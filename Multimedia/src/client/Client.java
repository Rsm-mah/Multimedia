package client;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.image.BufferedImage;
import javazoom.jl.player.Player;
import mp3.Mp3;
//import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;


import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;


public class Client {

    public Client() {

    }



    public void get_client() throws Exception {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        
        Socket clientSocket = new Socket("localhost",3000);
        DataInputStream data = new DataInputStream(clientSocket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());


        String filename = data.readUTF();
        String fichierName = data.readUTF();
        String fichierVideo = data.readUTF();

        

        JButton button1 = new JButton();
        button1.setText(filename);
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try {
                    // ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(e.getActionCommand());
                    oos.flush();
                    System.out.println("You clicked "+e.getActionCommand());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });  
        

        JButton button2 = new JButton();
        button2.setText(fichierName);
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try {
                    // ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(e.getActionCommand());
                    oos.flush();
                    System.out.println("You clicked "+e.getActionCommand());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        }); 

        JButton button3 = new JButton();
        button3.setText(fichierVideo);
        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                try {
                    // ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    oos.writeObject(e.getActionCommand());
                    System.out.println("You clicked "+e.getActionCommand());
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        }); 


        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        String envoye = (String) ois.readObject();

        if(envoye.contains(".jpg")) {
            System.out.println("Ny sary tsara be hazonao "+envoye);
            /* Affichage Image */
            InputStream inputStream = clientSocket.getInputStream();
            System.out.println("Reading "+System.currentTimeMillis());
            byte[] sizear=new byte[4];
            inputStream.read(sizear);
            
            int size=ByteBuffer.wrap(sizear).asIntBuffer().get();
            byte[] imagear=new byte[size];
            inputStream.read(imagear);
            BufferedImage image=ImageIO.read(new ByteArrayInputStream(imagear));
            ImageIcon imageIcon = new ImageIcon(image);

            JFrame jFrame = new JFrame();
            jFrame.setLayout(new FlowLayout());
            jFrame.setSize(500,500);
            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);
            jFrame.add(jLabel);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

        if(envoye.contains(".mp3")) {
            
            /* Envoyer photos */
            int len = 1000000;
            byte[] mybytearray = new byte[len];

            JFrame frame1 = new JFrame();
            frame1.setLayout(new FlowLayout());
            frame1.setSize(500,500);
            JLabel label1 = new JLabel();
            label1.setText(fichierName);
            frame1.add(label1);
            frame1.setVisible(true);
            frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            while(true) {
                data.read(mybytearray, 0, len);
                Thread play = new Thread(new Mp3(mybytearray));
                play.start();
                play(mybytearray);
            }
        }

        if(envoye.contains(".mp4")) {
            System.out.println("Waiting for connection...");
            System.out.println("Connection accepted");
            System.out.println("Spawning thread...");
            Thread trd = new Thread(new Runnable(){
                public void run(){
                    try {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
    
                        System.out.println("Receiving video...");
                        String pathname = "D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/video/video1.mp4";
                        File video = new File(pathname);
                        
                        System.out.println("Done receiving");
    
                        JFrame frame = new JFrame();
                        frame.setLocationRelativeTo(null);
                        frame.setSize(500, 500);
                        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
                        
    
                        EmbeddedMediaListPlayerComponent embeddedMediaListPlayerComponent = new EmbeddedMediaListPlayerComponent();
                        frame.add(embeddedMediaListPlayerComponent);
                        frame.setVisible(true);
                        embeddedMediaListPlayerComponent.mediaPlayer().media().play(video.getPath());
    
    
                        
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }}
            });
            trd.start();
    
    
        

    }
}




    

    public static void play(byte[] data) throws Exception {
        // DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
        // Player player = new Player(in);
        // player.play();
        Player jlPlayer;
            
                    FileInputStream fileInputStream = new FileInputStream("D:/2eme_Annee/Mr Naina/Multimedia/Multimedia/music/see you again.mp3");
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    jlPlayer = new Player(bufferedInputStream);
        
                
        
                new Thread() {
                    public void run() {
                        try {
                            
                            jlPlayer.play();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }.start();
    }

}
