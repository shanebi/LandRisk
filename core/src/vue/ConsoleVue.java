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
	}

	
	//enregistrer à la vue
	private void enregistrerAuManager() {
		Manager.getInstance().setVue(this);
	}

}
