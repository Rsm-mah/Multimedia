package client;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main_Client {
    public static void main(String[] args) {
        try {
            File audiofile = new File("D:/2eme_Annee/Mr Naina/Multimedia/music/see you again.mp3").getAbsoluteFile();
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audiofile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}