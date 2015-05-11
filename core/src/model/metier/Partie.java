package model.metier;

/**
 * Description : Class Partie abstract 
 */
public abstract class Partie {

	//attributs joueurs
	private JoueurMetier jm;
	private JoueurMetier jm2;
	
	//attributs carte 
	//--
	
	//constructeur
	public Partie() {
		jm = new JoueurMetier();
		jm2 = new JoueurMetier();
	}
	
	//methode
	public abstract void choixCarte();
	public abstract void choixCouleur();

	
	//retourne la joueur
	public JoueurMetier getJoueurMetier1(){
		return this.jm;
	}
	
	//retourne le joueur
	public JoueurMetier getJoueurMetier2(){
		return this.jm2;
	}
	
}
