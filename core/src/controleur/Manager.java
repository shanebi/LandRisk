package controleur;

import model.metier.Partie;
import model.metier.PartieEnLocal;
import model.technique.Dice;
import vue.Vue;

/**
 * Description : Class Singleton Manager
 */
public class Manager {

	//instance unique
	private static Manager instance = new Manager();
	//vue
	private Vue vue;

	//partie
	private PartieEnLocal pel;

	//dé
	private Dice di;


	//test a sup
	private Partie p;


	//constructeur
	private Manager() {
		pel = new PartieEnLocal();
		di = new Dice();
		p = new Partie() {

			@Override
			public void choixCouleur() {
				// TODO Auto-generated method stub

			}

			@Override
			public void choixCarte() {
				// TODO Auto-generated method stub

			}
		};

	}

	//retourne instance unique
	public static Manager getInstance() {
		return instance;
	}

	//enregistrer la vue
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	//retourne la vue
	public Vue getVue(){
		return this.vue;
	}


	//--------------------------------METHODE DU JEU
	//nouveau jeu en local
	public void nouveauJeuEnLocal(){

		//--------------  TEST DE MOUS---- OKOK
		this.pel.nouveauJeuEnLocal();


		System.out.println("TAILLE DE LA LISTE DE JOUEUR : "+this.p.getJoueurParticipant().size());
		
		
		System.out.println(this.pel.getJoueurParticipant().get(0));
		System.out.println("Couleur : "+this.p.getJoueurParticipant().get(0).getCouleur());
		System.out.println("Nombre Unitee dans troupes : "+this.p.getJoueurParticipant().get(0).getArmee().afficherNombreUniteeDansTroupes());
		System.out.println(this.p.getJoueurParticipant().get(1));
		System.out.println("Couleur : "+this.p.getJoueurParticipant().get(1));
		System.out.println("Nombre Unitee dans troupes : "+this.p.getJoueurParticipant().get(1).getArmee().afficherNombreUniteeDansTroupes());

		// ------------- TEST DE RUBBEN ----  OKOK
		System.out.println(this.pel.getLireXML());

		System.out.println("-------- LISTE DES TERRITOIRES ---- ");

		//test affiche les liste des territoires
		for (int i = 0; i < this.pel.getLireXML().getListTerritoires().size(); i++) {
			System.out.println(this.pel.getLireXML().getListTerritoires().get(i));
		}


		System.out.println("---------- VOIR LA LISTE DES NOEUDS ATTRIBUER AU JOUEUR 1");

		for (int i = 0; i < this.pel.getJoueurParticipant().get(0).getListeNoeudsJoueur().size(); i++) {
			System.out.println(this.pel.getJoueurParticipant().get(0).getListeNoeudsJoueur().get(i));
		}

		System.out.println("---------- VOIR LA LISTE DES NOEUDS ATTRIBUER AU JOUEUR 2");

		for (int i = 0; i < this.p.getJoueurParticipant().get(1).getListeNoeudsJoueur().size(); i++) {
			System.out.println(this.p.getJoueurParticipant().get(1).getListeNoeudsJoueur().get(i));
		}
	}

	//lancer Dé
	public void LanceDe(){
		System.out.println("Résultat dé : "+di.roll());
	}

	//choix carte
	public void choixCarte(){

	}

	//choix Couleur
	public void choixCouleur(){

	}

	//attaque
	public void attaque(){

	}

	//placement troupes
	public void placementTroupes(){

	}

	//activerSon
	public void activerSon(){

	}

	//desactiver son
	public void desactiverSon(){

	}

	//activer music
	public void activerMusic(){

	}

	//desactiver music
	public void desactiverMusic(){

	}

	public void jouer() {

	}

	//modifier nombre face du dé
	public void ModifierNbFaceDice(int nbFace) {
		di.setNbFace(nbFace);
	}
}
