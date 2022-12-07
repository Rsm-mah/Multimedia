package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import affichage.ConteneurFenetre;
import client.Client;
import serveur.Serveur;;

public class Listener implements MouseListener{

    ConteneurFenetre conteneurFenetre;

    public Listener() {

    }

    public Listener(ConteneurFenetre conteneurFenetre) {
        this.conteneurFenetre = conteneurFenetre;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        try {
            if (e.getSource() == conteneurFenetre.all_Buttons().get(0)) {
                conteneurFenetre.setButton_music_active(true);
                Client client=new Client();
                client.getClient();
            }
            else if (e.getSource() == conteneurFenetre.all_Buttons().get(1)) {
                conteneurFenetre.setButton_music_active(false);
                conteneurFenetre.setButton_image_active(true);
                Client client=new Client();
                client.get_Image_Client();
            }
        } catch (Exception ex) {
            // TODO: handle exception
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
