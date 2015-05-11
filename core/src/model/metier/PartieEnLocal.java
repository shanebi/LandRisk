package model.metier;

/**
 * Description : Class PartieEnLocale permet de lancer une partie en local
 */
public class PartieEnLocal extends Partie {

	//constructeurs
	public PartieEnLocal(){
		
	}

	//choix de la carte
	@Override
	public void choixCarte() {
		//--- a completer en attente de la carte
	}

	//choix de la couleur
	@Override
	public void choixCouleur(){	
		getJoueurMetier1().choixCouleur();
		getJoueurMetier2().choixCouleur();
	}
	
	//nouveau jeu en local
	public void nouveauJeuEnLocal(){
		
		//choix de la carte
		choixCarte();
		
		//choix des couleurs
		choixCouleur();
	}
	
}
