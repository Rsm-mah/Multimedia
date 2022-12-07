package affichage;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
    {
        ConteneurFenetre conteneurFenetre = new ConteneurFenetre();
        this.setTitle("Streaming");
        this.setSize(600, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(conteneurFenetre);
        this.setVisible(true);
    }
    
}
