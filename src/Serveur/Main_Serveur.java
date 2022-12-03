package serveur;



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
