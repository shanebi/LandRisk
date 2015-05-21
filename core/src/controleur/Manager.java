package controleur;

import model.metier.Partie;
import model.metier.PartieEnLocal;
import model.technique.Dice;
import model.technique.MusicManager;
import model.technique.MusicManager.LandRiskMusic;
import model.technique.SoundManager;
import vue.Vue;

/**
 * Description : Class Singleton Manager
 */
public class Manager {

	// instance unique
	private static Manager instance = new Manager();
	// vue
	private Vue vue;

	// partie
	private PartieEnLocal pel;

	// dé
	private Dice di;

	// test a sup
	private Partie p;

	/** Manager des effets spéciaux */
	private SoundManager soundManager;

	/** Manager des musiques */
	private MusicManager musicManager;

	// constructeur
	private Manager() {
		
		musicManager = new MusicManager();
		soundManager = new SoundManager();
		
		//pel = new PartieEnLocal();
		//di = new Dice();
		/*p = new Partie() {

			@Override
			public void choixCouleur() {
				// TODO Auto-generated method stub

			}

			@Override
			public void choixCarte() {
				// TODO Auto-generated method stub

			}
		};
		
		*/

	}

	// retourne instance unique
	public static Manager getInstance() {
		return instance;
	}

	// enregistrer la vue
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	// retourne la vue
	public Vue getVue() {
		return this.vue;
	}

	// --------------------------------METHODE DU JEU
	// nouveau jeu en local
	public void nouveauJeuEnLocal() {

		// -------------- TEST DE MOUS---- OKOK
		this.pel.nouveauJeuEnLocal();

		System.out.println("TAILLE DE LA LISTE DE JOUEUR : "
				+ this.p.getJoueurParticipant().size());

		System.out.println(this.pel.getJoueurParticipant().get(0));
		System.out.println("Couleur : "
				+ this.p.getJoueurParticipant().get(0).getCouleur());
		System.out.println("Nombre Unitee dans troupes : "
				+ this.p.getJoueurParticipant().get(0).getArmee()
						.afficherNombreUniteeDansTroupes());
		System.out.println(this.p.getJoueurParticipant().get(1));
		System.out.println("Couleur : " + this.p.getJoueurParticipant().get(1));
		System.out.println("Nombre Unitee dans troupes : "
				+ this.p.getJoueurParticipant().get(1).getArmee()
						.afficherNombreUniteeDansTroupes());

		// ------------- TEST DE RUBBEN ---- OKOK
		System.out.println(this.pel.getLireXML());

		System.out.println("-------- LISTE DES TERRITOIRES ---- ");

		// test affiche les liste des territoires
		for (int i = 0; i < this.pel.getLireXML().getListTerritoires().size(); i++) {
			System.out.println(this.pel.getLireXML().getListTerritoires()
					.get(i));
		}

		System.out.println(this.pel.getJoueurParticipant().get(0)
				.getListeNoeudsJoueur().size());
		System.out.println(this.pel.getJoueurParticipant().get(1)
				.getListeNoeudsJoueur().size());

		System.out
				.println("---------- VOIR LA LISTE DES NOEUDS ATTRIBUER AU JOUEUR 1");

		for (int i = 0; i < this.pel.getJoueurParticipant().get(0)
				.getListeNoeudsJoueur().size(); i++) {
			System.out.println(this.pel.getJoueurParticipant().get(0)
					.getListeNoeudsJoueur().get(i));
		}

		System.out
				.println("---------- VOIR LA LISTE DES NOEUDS ATTRIBUER AU JOUEUR 2");

		for (int i = 0; i < this.pel.getJoueurParticipant().get(1)
				.getListeNoeudsJoueur().size(); i++) {
			System.out.println(this.pel.getJoueurParticipant().get(1)
					.getListeNoeudsJoueur().get(i));
		}

	}

	// lancer Dé
	public void LanceDe() {
		System.out.println("Résultat dé : " + di.roll());
	}

	// choix carte
	public void choixCarte() {
	}

	// choix Couleur
	public void choixCouleur() {

	}

	// attaque
	public void attaque() {

	}

	// placement troupes
	public void placementTroupes() {

	}

	/**
	 * Methode qui active les effets sonore du jeu
	 */
	public void activerSon() {
		soundManager.setEnabled(true);
	}

	/**
	 * Methode qui désactive les effets sonore du jeu
	 */
	public void desactiverSon() {
		soundManager.setEnabled(false);
	}

	/**
	 * Methode qui active la musique du jeu
	 */
	public void activerMusic() {
		musicManager.setEnabled(true);
	}

	/**
	 * Methode qui désactive la musique du jeu
	 */
	public void desactiverMusic() {
		musicManager.setEnabled(false);
	}

	public void jouer() {

	}

	// modifier nombre face du dé
	public void ModifierNbFaceDice(int nbFace) {
		di.setNbFace(nbFace);
	}

	
	
	/**
	 * Methode qui appelle la musique qui sera joué dans le menu principal
	 */
	public void musicMenu(){
		musicManager.play(LandRiskMusic.MENU);
	}
	
	/**
	 * Methode qui appelle la musique qui sera joué durant une partie
	 */
	public void musicMap(){
		musicManager.play(LandRiskMusic.MAP2);
	}
}
