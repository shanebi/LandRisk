package model.metier;

import java.util.ArrayList;

/**
 * Description : Class Partie abstract 
 */
public abstract class Partie {
	//liste des joueurs
	private ArrayList<JoueurMetier> joueurParticipant;

	//constructeur
	public Partie() {
		//creation de l'arrayList
		joueurParticipant = new ArrayList<JoueurMetier>();
		//creation des joueurs
		joueurParticipant.add(new JoueurMetier());
		joueurParticipant.add(new JoueurMetier());
	}
	
	//methode
	public abstract void choixCarte();
	public abstract void choixCouleur();

	//retourne la liste des joueurs
	public ArrayList<JoueurMetier> getJoueurParticipant() {
		return joueurParticipant;
	}
	
	

}
