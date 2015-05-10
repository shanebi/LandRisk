package controleur;

import model.metier.Partie;
import model.metier.PartieEnLocal;
import vue.Vue;

/**
 * Description : Class Singleton Manager
 */
public class Manager {

	//instance unique
	private static Manager instance = new Manager();
	//vue
	private Vue vue;
	
	//partie
	private PartieEnLocal pel;
	
	//constructeur
	private Manager() {
		pel = new PartieEnLocal();
	}

	//retourne instance unique
	public static Manager getInstance() {
		return instance;
	}

	//enregistrer la vue
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	//retourne la vue
	public Vue getVue(){
		return this.vue;
	}

	
	//--------------------------------METHODE DU JEU
	//nouveau jeu en local
	public void nouveauJeuEnLocal(){
		this.pel.nouveauJeuEnLocal();
	}
	
	//lancer Dé
	public void LanceDe(){

	}
	
	//choix carte
	public void choixCarte(){
			
	}
	
	//choix Couleur
	public void choixCouleur(){
		
	}
	
	//attaque
	public void attaque(){
	
	}
	
	//placement troupes
	public void placementTroupes(){
		
	}
	
	//activerSon
	public void activerSon(){
		
	}
	
	//desactiver son
	public void desactiverSon(){
		
	}

	//activer music
	public void activerMusic(){
		
	}
	
	//desactiver music
	public void desactiverMusic(){
		
	}
	
	
}
