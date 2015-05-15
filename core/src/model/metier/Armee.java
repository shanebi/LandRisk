package model.metier;

import java.io.Serializable;
import java.util.Stack;

/**
 * Description : Class Armee 
 */
public class Armee extends Stack<Unitee> implements Serializable{

	//constructeur
	public Armee(){
		if(size()<=0){
			//10 troupes pour chaque joueur
			for (int i = 0; i < 10; i++) {
				push(new Unitee());
			}
		}
	}

	//retourne le nombre de unites de troupes
	public int afficherNombreUniteeDansTroupes(){	
		int res = size();
		return res;
	}
	
	
	

}
