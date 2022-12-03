package client;

import client.Client;
import serveur.Serveur;

public class Main_Client {
    public static void main(String[] args)throws Exception, ClassNotFoundException{
        
        try{
            Client client=new Client();
            client.getClient();
            
             
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e);
        }
    }
    
}