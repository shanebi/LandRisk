package model.metier;

import java.util.ArrayList;

/**
 * Classe chargee de construire la carte (geographique) de la partie.
 * @author ruben
 *
 */
public class Carte
{
	/**/
	/**
	 * Une ArrayList pour regrouper les territoires dans une liste.
	 * Pourquoi une ArrayList ? Car l'ArrayList est particulierement rapide dans l'accessibilité à ses objets (get).
	 */
	private ArrayList<Territoire> listTerritoire;
	
	/**
	 * Liste de noeuds presents dans l'ensemble des territoires pour une carte donnee.
	 */
	private ArrayList<Noeud> listNoeudsTotaux;

	/**
	 * Constructeur par defaut.
	 */
	public Carte(){}

	/**
	 * Constructeur avec une liste de territoires en parametre.
	 * @param listTerritoire La liste de territoires de la carte.
	 * @param listNoeudsTotaux La liste des noeuds de tous les territoires.
	 */
	public Carte(ArrayList<Territoire> listTerritoire, ArrayList<Noeud> listNoeudsTotaux)
	{
		this.listTerritoire = listTerritoire;
		this.listNoeudsTotaux = listNoeudsTotaux;
	}

	/**
	 * Methode pour verifier si le noeud attaqué est bien un noeud voisin.
	 * @param idAttaquant idAttaquant Le noeud qui va attaquer.
	 * @param idVoisin idVoisin La cible du noeud attaquant.
	 * @return Vrai si le noeud passe en parametre est bien un noeud voisin, si non faux.
	 */
	public boolean trouverNoeudVoisin(String idAttaquant, String idVoisin)
	{
		boolean resultat = false;
		//On parcourt notre liste de territoires
		for(int i = 0; i < this.listTerritoire.size(); i++)
		{
			return resultat = this.listTerritoire.get(i).trouverNoeudVoisin(idAttaquant, idVoisin);
		}
		return resultat;
	}

	/*-------------------------GUETTER-------------------------*/
	/**
	 * Guetter de la liste des territoires.
	 * @return La liste des territoires.
	 */
	public ArrayList<Territoire> getListTerritoire()
	{
		return listTerritoire;
	}
	
	/**
	 * Guetter de la liste contenant l'ensemble des noeuds de tous les territoires.
	 * @return La liste des noeuds contenant l'ensemble des noeuds de tous les territoires.
	 */
	public ArrayList<Noeud> getListNoeudsTotaux()
	{
		return listNoeudsTotaux;
	}
}
