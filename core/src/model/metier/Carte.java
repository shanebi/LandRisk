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
	 * Constructeur par defaut.
	 */
	public Carte(){}
	
	/**
	 * Constructeur avec une liste de territoires en parametre.
	 * @param listTerritoire La liste de territoires de la carte.
	 */
	public Carte(ArrayList<Territoire> listTerritoire)
	{
		this.listTerritoire = listTerritoire;
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
}
