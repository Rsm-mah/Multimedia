package client;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;


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


            scan.close();
            ds.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Serveur non connecter");
        }
    }



    public void get_Image_Client() throws Exception{
        Socket socket =  new Socket("localhost", 3000);
            InputStream inputStream = socket.getInputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            String reponse = scan.readLine();
            System.out.println(reponse);
            bufferedWriter.write(reponse);
            bufferedWriter.newLine();
            bufferedWriter.flush();



            System.out.println("Reading: " + System.currentTimeMillis());
            byte[] sizeAr = new byte[4];
            inputStream.read(sizeAr);
            int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();
            byte[] imageAr = new byte[size];
            inputStream.read(imageAr);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));
            System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
            //ImageIO.write(image, "jpg", new File("D:/2eme_Annee/Mr Naina/Streaming/images/image_web_1.jpg"));

            ImageIcon imageIcon = new ImageIcon(image);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setSize(500, 500);
            JLabel jLabel = new JLabel();
            jLabel.setIcon(imageIcon);
            frame.add(jLabel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}