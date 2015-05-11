package model.technique;

import java.io.*;

import model.metier.JoueurMetier;

public class SerializationOutil{
	
	//constructeur
	public SerializationOutil(){
			
	}
	
	//main
   public static void main(String [] args){
	  
	  JoueurMetier mous = new JoueurMetier();
	  mous.choixCouleur();

      try{
    	 
         FileOutputStream fileOut = new FileOutputStream("/Users/silnti/Desktop/tmp/sauvJoueur.txt");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(mous);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /Users/silnti/Desktop/tmp/sauvJoueur.txt");
         
      }
     
      catch(IOException i){
          i.printStackTrace();
      }
     
   }

}