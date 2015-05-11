package model.technique;

/**
 * Classe technique qui gère un dé
 * 
 * @author Benjamin Bertrand
 *
 */
public class Dice {

	/** Nombre de face du dé */
	private int nbFace;
	/** Valeur aléatoire que l'on obtient après avoir fait lancé le dé. */
	private int randomVal;

	/**
	 * Constructeur de la classe
	 * Par défaut un dé possède six faces
	 */
	public Dice() {
		this.nbFace = 6;
	}

	/**
	 * Methode pour lancer le dé
	 * @return retourne une valeur aléatoire
	 */
	public int roll() {
		randomVal = (int)(Math.random() * (nbFace-1)) + 1;
		return randomVal;
	}

	/**
	 * Retourne le nombre de face du dé
	 * @return nb de face
	 */
	public int getNbFace() {
		return nbFace;
	}

	/**
	 * Défini le nombre de face du dé
	 * @param nbFace Nombre de face que l'on souhaite donner au dé
	 */
	public void setNbFace(int nbFace) {
		this.nbFace = nbFace;
	}

}
