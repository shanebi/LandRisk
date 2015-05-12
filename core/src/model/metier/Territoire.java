package model.metier;

import java.util.ArrayList;

/**
 * Classe qui contruit un territoire.<br>
 * Un territoire possede une liste de noeuds.
 * @author ruben
 *
 */
public class Territoire
{
	/**
	 * Identifiant du territoire. <br>
	 * Chaque territoire est identifie par un id.
	 */
	private int id;

	/**
	 * Une ArrayList pour regrouper les noeuds dans une liste.
	 * Pourquoi une ArrayList ? Car l'ArrayList est particulierement rapide dans l'accessibilité à ses objets (get).
	 */
	private ArrayList<Noeud> listNoeud;

	/**
	 * Constructeur par defaut.
	 */
	public Territoire(){}
	
	/**
	 * Constructeur avec la liste des noeuds qui se trouvent dans ce territoire en parametre.
	 * @param id L'identifiant du territoire.
	 * @param listNoeud La liste des noeuds qui se se situent dans ce territoire.
	 */
	public Territoire(int id, ArrayList<Noeud> listNoeud)
	{
		this.id=id;
		this.listNoeud = listNoeud;
	}

	/**
	 * Methode pour verifier si le noeud attaqué est bien un noeud voisin.
	 * @param idAttaquant Le noeud qui va attaquer.
	 * @param idVoisin La cible du noeud attaquant.
	 * @return Vrai si le noeud passe en parametre est bien un noeud voisin, si non faux.
	 */
	public boolean trouverNoeudVoisin(String idAttaquant, String idVoisin)
	{
		boolean resultat = false;
		//On parcourt notre liste de noeuds
		for(int i = 0; i < this.listNoeud.size(); i++)
		{
			//Si le noeud attaquant est dans ce territoire 
			if(idAttaquant.equals(this.listNoeud.get(i).getId()))
			{
				//On verifie si le noeud voisin passe en parametre est bien un noeud voisin
				resultat = this.listNoeud.get(i).trouverNoeudVoisin(idVoisin);
			}
		}
		return resultat;
	}
	
	/*-------------------------GUETTER-------------------------*/
	/**
	 * Guetter de notre liste de noeuds.
	 * @return Notre liste de noeuds qui se situent dans ce territoire.
	 */
	public ArrayList<Noeud> getListNoeud()
	{
		return listNoeud;
	}

}
