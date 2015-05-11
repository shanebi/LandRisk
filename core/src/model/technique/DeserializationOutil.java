package model.technique;

import java.io.*;

import model.metier.JoueurMetier;
public class DeserializationOutil{
	
   public static void main(String [] args){
	   
	  JoueurMetier e = null;
      
      try{
    	  
         FileInputStream fileIn = new FileInputStream("/Users/silnti/Desktop/tmp/sauvJoueur.txt");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (JoueurMetier) in.readObject();
         in.close();
         fileIn.close();
      }
      catch(IOException i){
    	  
         i.printStackTrace();
         return;
      }
      catch(ClassNotFoundException c){
    	  
         System.out.println("Class non trouvée");
         c.printStackTrace();
         return;
      }
   
      System.out.println("Deserialized OK...");
    
   }
   
}