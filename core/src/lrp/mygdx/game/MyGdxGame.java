package lrp.mygdx.game;

import model.technique.MusicManager;
import model.technique.Preference;
import model.technique.SoundManager;

import com.badlogic.gdx.Game;

import controleur.Manager;
import vue.Vue;
import vue.screen.ImageLancement;

public class MyGdxGame extends Game implements Vue {

	@Override
	public void create() {
		enregistrerAuManager();

		/*
		 * //----- TEST 1 A SUP --- Création de la partie
		 * Manager.getInstance().nouveauJeuEnLocal();
		 * 
		 * //----- TEST 2 A SUP JOUER ---- Jouer Au jeu
		 * Manager.getInstance().jouer();
		 * 
		 * //----- TEST 3 A SUP BENJAMEN ---- lancer dé
		 * System.out.println("--- TEST DU Dé----");
		 * Manager.getInstance().LanceDe();
		 * System.out.println("Modifier valeur dé et relancer : ");
		 * Manager.getInstance().ModifierNbFaceDice(100);
		 * Manager.getInstance().LanceDe();
		 */

		setScreen(new ImageLancement());

	}

	@Override
	public MyGdxGame getMoi() {
		return this;
	}

	// enregistrer à la vue
	private void enregistrerAuManager() {
		Manager.getInstance().setVue(this);
	}

}
