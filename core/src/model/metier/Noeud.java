package model.metier;

import java.util.ArrayList;

/**
 * Classe chargee de construire une certaine zone d'un territoire. <br>
 * Un noeud est caractérise par son centre de gravité. <br>
 * Le centre de gravité sert donc de base pour les coordonnées du noeud, et pour l'interaction avec le joueur (partie sensible de la zone).
 * @author ruben
 *
 */
public class Noeud
{
	/**
	 * Coordonnee du point sur la carte : en abscisse.
	 */
	private int x;

	/**
	 * Coordonnee du point sur la carte : en ordonnee.
	 */
	private int y;
	
	/**
	 * Identifiant du noeud. <br>
	 * Chaque noeud est identifie par un id, qui est la concatenation des coordonnees x et y.
	 */
	private String id;
	
	/**
	 * Chaque noeud a un noeud voisin, c'est à dire un noeud qui possede une frontiere en commune <br>
	 * ou une jonction maritime avec ce dernier.<br>
	 * Cette liste permettra donc de savoir si un joueur peut attaquer ce noeud ou pas.<br><br>
	 * 
	 * Pourquoi une ArrayList ? Car l'ArrayList est particulierement rapide dans l'accessibilité à ses objets (get).
	 */
	private ArrayList<String> listNoeudsVoisins;

	public Noeud(){}
	
	/**
	 * Constructeur avec les coordonees et l'id en parametre.
	 * @param x les coordonnees du noeud en abscisse.
	 * @param y les coordonnees du noeud en ordonnee.
	 * @param id l'identifiant du noeud.
	 */
	public Noeud(int x, int y, ArrayList<String> listNoeudsVoisins)
	{
		this.x=x;
		this.y=y;
		//l'id est la concatenation de des coordonnees x+y
		this.id=Integer.toString(x)+"."+Integer.toString(y);
		this.listNoeudsVoisins = listNoeudsVoisins;
	}
	
	/**
	 * Methode pour verifier si le noeud attaqué est bien un noeud voisin.
	 * @param idVoisin La cible du noeud qui attaquant.
	 * @return Vrai si le noeud passe en parametre est bien un noeud voisin, si non faux.
	 */
	public boolean trouverNoeudVoisin(String idVoisin)
	{
		boolean resultat=false;
		//On parcourt notre liste de noeuds voisins pour ce noeud
		for(int i = 0; i < this.listNoeudsVoisins.size(); i++)
		{
			//On verifie si le noeud voisin passe en parametre est bien un noeud voisin
			if(idVoisin.equals(this.listNoeudsVoisins.get(i)))
			{
				return resultat=true;
			}
		}
		return resultat;
	}
	
	/*-------------------------GUETTER-------------------------*/
	/**
	 * Guetter du coordonnee du noeud en abscisse.
	 * @return coordoonee du noeud en en abscisse.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Guetter d'une coordonnee du noeud en ordonnee.
	 * @return coordoonee du noeud en ordonnee.
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Guetter de l'identifiant du noeud.
	 * @return l'id du noeud.
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Guetter de la liste des noeuds voisins à ce noeud.
	 * @return La liste des noeuds voisins à ce noeud.
	 */
	public ArrayList<String> getListNoeudsVoisins()
	{
		return listNoeudsVoisins;
	}
}
