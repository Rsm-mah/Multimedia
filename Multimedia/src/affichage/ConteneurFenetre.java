package affichage;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import listener.Listener;

import java.awt.Graphics;

public class ConteneurFenetre extends JPanel{

    Vector<JButton> buttons;
    Boolean button_music_active = false;
    Boolean button_image_active = false;
    //Boolean button_music_active;
    Listener listener = new Listener(this);

    public ConteneurFenetre(){
        this.proprieteFenetre();
    }

    public void proprieteFenetre() {
        buttons = new Vector<JButton>();
        buttons.add(new JButton("Music"));
        buttons.add(new JButton("Image"));
        
        for (int i = 0; i < buttons.size(); i++) {
            this.add(buttons.get(i));
            buttons.get(i).addMouseListener(listener);
        }

        this.setLayout(null);
        this.setFocusable(true);
    }



    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);


        buttons.get(0).setBounds(50, 0, 100, 40);
        buttons.get(1).setBounds(200, 0, 100, 40);
    }


    public Vector<JButton> all_Buttons() {
        Vector<JButton> b = new Vector<JButton>();
        b.add(buttons.get(0));
        b.add(buttons.get(1));
        return b;
    }


    public Boolean getButton_music_active() {
        return button_music_active;
    }

    public void setButton_music_active(Boolean button_music_active) {
        this.button_music_active = button_music_active;
    }

    public Boolean getButton_image_active() {
        return button_image_active;
    }

    public void setButton_image_active(Boolean button_image_active) {
        this.button_image_active = button_image_active;
    }
}
