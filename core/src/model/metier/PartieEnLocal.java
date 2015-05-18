package model.metier;

import java.util.ArrayList;

import model.technique.Dice;
import model.technique.LireXML;

/**
 * Description : Class PartieEnLocale permet de lancer une partie en local
 */
public class PartieEnLocal extends Partie {

	private LireXML lx;
	private Dice de;

	//constructeurs
	public PartieEnLocal(){
		lx = new LireXML();
	}

	//choix de la carte
	@Override
	public void choixCarte() {
		lx.lireCarteXML();
		de = new Dice();
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

		//**********
		//recuperation de tout les joueurs dans un var tmp
		ArrayList<JoueurMetier> listeTmpJoueurParticipant = getJoueurParticipant();

		//recuperation de tout les noeuds dans une var tmp
		ArrayList<Noeud> listeTmpListNoeudTotaux = lx.getCarte().getListNoeudsTotaux();

		//division des noeuds par le nombre de joueurs
		int nbJoueur = listeTmpJoueurParticipant.size();
		int nbNoeudParJoueur = listeTmpListNoeudTotaux.size()/nbJoueur;

		System.out.println("NB NOEUD PAR JOUEUR : "+nbNoeudParJoueur);

		
		
		
		
		
		//boucle tant que il y a encore des noeuds dans la liste
		while(listeTmpListNoeudTotaux.size()!=0){	

			System.out.println("cb de noeud reste il : "+listeTmpListNoeudTotaux.size());
			//set du nombre de face du dé par nombre de joueurs
			de.setNbFace(listeTmpJoueurParticipant.size()+1);

			//lancement dé
			int resDe = de.roll();

			System.out.println("Res du Dice : "+(resDe));

			//si joueur a pas atteind max de noeud on lui attribut le noeud
			if(listeTmpJoueurParticipant.get(resDe-1).getListeNoeudsJoueur().size()<nbNoeudParJoueur){

				//recuperation du noeud en haut de pile et ajout a la liste du joueur
				listeTmpJoueurParticipant.get(resDe-1).getListeNoeudsJoueur().add(listeTmpListNoeudTotaux.get(0));

				//supprimer le noeud attribuer
				listeTmpListNoeudTotaux.remove(0);
				
				System.out.println("---->DANS LE IF");
			}

			//on le retire de la liste ( le joueur)
			else{
				
				//listeTmpJoueurParticipant.remove(resDe-1);
				
				if (resDe>1) {	
					resDe=1;
				}

				else {
					resDe=2;
				}
				
				//recuperation du noeud en haut de pile et ajout a la liste du joueur
				listeTmpJoueurParticipant.get(resDe-1).getListeNoeudsJoueur().add(listeTmpListNoeudTotaux.get(0));

				//supprimer le noeud attribuer
				listeTmpListNoeudTotaux.remove(0);
				
				System.out.println("**ON EST DANS LE REMOVE");		
			}
		}
	}

	//retourne liXML
	public LireXML getLireXML(){
		return this.lx;
	}
	
}
