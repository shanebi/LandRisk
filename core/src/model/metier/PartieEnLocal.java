package model.metier;

/**
 * Description : Class PartieEnLocale permet de lancer une partie en local
 */
public class PartieEnLocal extends Partie {

	private LireXML lx;

	//constructeurs
	public PartieEnLocal(){
		lx = new LireXML();
	}

	//choix de la carte
	@Override
	public void choixCarte() {
		lx.lireCarteXML();
	}

	//choix de la couleur
	@Override
	public void choixCouleur(){	
		//attribution des couleurs a tout les joueurs
		for (int i = 0; i < getJoueurParticipant().size(); i++) {		
			getJoueurParticipant().get(i).choixCouleur();
		}
	}

	//nouveau jeu en local
	public void nouveauJeuEnLocal(){

		//choix de la carte
		choixCarte();

		//choix des couleurs
		choixCouleur();	


		//ici attribuer au joueur les noeuds


		//recuperation de tout les joueurs


		//recuperation de tout les noeuds


		//division des noeuds par le nombre de joueurs


		//set du nombre de face du dé par nombre de joueurs


		//lancement dé


		//si joueur a pas atteind max de noeud


		//attribution de l'objet de l'Arraylist à position 0
		
		
		
		
		
		
		
	}

	//retourne liXML
	public LireXML getLireXML(){
		return this.lx;
	}


}
