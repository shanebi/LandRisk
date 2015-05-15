package vue;

import controleur.Manager;

/**
 * Class ConsoleVue qui nous permet de réaliser nos affichages.
 */
public class ConsoleVue implements Vue{
	
	//constructeur
	public ConsoleVue(){
	}
	
	//main
	public static void main(String[] args) {
		ConsoleVue cv = null;
		cv = new ConsoleVue();
		cv.enregistrerAuManager();
		
		//----- TEST 1 A SUP --- Création de la partie
		Manager.getInstance().nouveauJeuEnLocal();
		
		
		//----- TEST 2 A SUP JOUER ---- Jouer Au jeu
		Manager.getInstance().jouer();
		
		
		System.out.println("--- TEST DU Dé----");
		//----- TEST 3 A SUP BENJAMEN ----  lancer dé
		Manager.getInstance().LanceDe();
		System.out.println("Modifier valeur dé et relancer : ");
		Manager.getInstance().ModifierNbFaceDice(100);
		Manager.getInstance().LanceDe();
		
		
		

		
		
		
		
		
		
	}
	
	//enregistrer à la vue
	private void enregistrerAuManager() {
		Manager.getInstance().setVue(this);
	}

	
}
