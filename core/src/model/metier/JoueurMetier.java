package model.metier;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;


/**
 * Description : Class JoueurMetier
 */
public class JoueurMetier implements java.io.Serializable{
	
	//armée du joueur
	private Armee armee;
	
	//couleur du joeur
	private String couleur;
	
	//constructeur
	public JoueurMetier() {
		armee = new Armee();
	}
	
	//methode choix couleur
	public void choixCouleur(){
		this.couleur = "RED";
	}

	//methode attaque
	public void attaque(){
		// en attente de la carte
	}
	
	//methode placement de troupes
	public void placementTroupes(){
		//-- en attende de la carte
	}

	//Geetterss de mouuus 
	public Armee getArmee() {
		return armee;
	}

	public String getCouleur() {
		return couleur;
	}
	

		
}
