package model.metier;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;


/**
 * Description : Class JoueurMetier
 */
public class JoueurMetier implements java.io.Serializable{
	
	//armée du joueur
	private Armee a;
	
	//couleur du joeur
	private String c;
	
	//constructeur
	public JoueurMetier() {
		a = new Armee();
	}
	
	//methode choix couleur
	public void choixCouleur(){
		this.c = "RED";
	}

	//methode attaque
	public void attaque(){
		// en attente de la carte
	}
	
	//methode placement de troupes
	public void placementTroupes(){
		//-- en attende de la carte
	}
	
	
		
}
