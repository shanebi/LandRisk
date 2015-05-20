package vue.screen;

import lrp.mygdx.game.MyGdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;

import controleur.AdaptEcran;
import controleur.Manager;

/**
 * Classe qui affiche l'écran des options avec le réglage du son, de la musique
 * et de la vitesse du jeu
 * 
 * @author Giovanni Armede
 *
 */
public class Reglage implements Screen {

	private Sprite boutonSpriteSon;
	private Sprite boutonSpriteMusic;
	private Sprite boutonSpriteVitesse;
	private Sprite boutonCliqueSprite;
	private Sprite arrierePlanSprite;
	private Sprite boutonRetourSprite;

	private BitmapFont font;
	private SpriteBatch batch;

	private float xposBouton1;
	private float xposBouton2;
	private float xposBouton3;
	private float xposBoutonRetour;

	private float yposBouton1;
	private float yposBouton2;
	private float yposBouton3;
	private float yposBoutonRetour;

	private boolean cliqueBouton1;
	private boolean cliqueBouton2;
	private boolean cliqueBouton3;

	/** Checkbox */
	
	public Reglage() {
	}
	
	

	/**
	 * Fonction qui maintien le rapport entre les positions X vis-à-vis de la
	 * taille de l'écran
	 * 
	 * @param x
	 *            Ordonnée X
	 * @return La position de X par rapport à la taille de l'écran
	 */
	private float xUnite(float x) {
		return AdaptEcran.setEcranPostX(x);
	}

	/**
	 * Fonction qui maintien le rapport entre les positions Y vis-à-vis de la
	 * taille de l'écran
	 * 
	 * @param y
	 *            Ordonnée Y
	 * @return La position de Y par rapport à la taille de l'écran
	 */
	private float yUnite(float y) {
		return AdaptEcran.setEcranPosY(y);
	}

	@Override
	public void show() {

		batch = new SpriteBatch();

		// Charger Texture dans Sprite
		boutonSpriteSon = new Sprite(new Texture(Gdx.files.internal("icon/son.png")));
		boutonSpriteMusic = new Sprite(new Texture(
				Gdx.files.internal("icon/musique.png")));
		boutonSpriteVitesse = new Sprite(new Texture(
				Gdx.files.internal("icon/vitesse du jeu.png")));

		boutonCliqueSprite = new Sprite(new Texture(
				Gdx.files.internal("icon/quitter.png")));
		arrierePlanSprite = new Sprite(new Texture(
				Gdx.files.internal("icon/acceuil.png")));
		boutonRetourSprite = new Sprite(new Texture(
				Gdx.files.internal("icon/retour.png")));

		boutonSpriteSon.setSize(xUnite(150), yUnite(50));
		boutonSpriteMusic.setSize(xUnite(200), yUnite(70));
		boutonSpriteVitesse.setSize(xUnite(350), yUnite(70));

		boutonCliqueSprite.setSize(xUnite(128), yUnite(64));
		arrierePlanSprite.setSize(xUnite(480), yUnite(320));
		boutonRetourSprite.setSize(xUnite(64), yUnite(64));

		// La police pour le texte
		font = new BitmapFont();
		font.setColor(Color.DARK_GRAY);
		font.setScale(xUnite(1), yUnite(1)); // définir la taille du texte selon
												// l'écran

		// Position du bouton 'nouveau jeu'
		xposBouton1 = xUnite(130);
		yposBouton1 = yUnite(230);

		// Position du bouton 'Options'
		xposBouton2 = xUnite(120);
		yposBouton2 = yUnite(130);

		// Position du bouton 'Options'
		xposBouton3 = xUnite(60);
		yposBouton3 = yUnite(40);

		// Position du bouton 'Retour'
		xposBoutonRetour = xUnite(0);
		yposBoutonRetour = yUnite(260);

		boutonRetourSprite.setPosition(xposBoutonRetour, yposBoutonRetour);

	}

	public void manipulerMenu() {

		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean touchUp(int x, int y, int pointer, int bouton) {

				if (x > xUnite(150) && x < xUnite(325) && y > yUnite(30)
						&& y < yUnite(90)) {

					// le bouton 1 (jeu local) a été cliqué

				}

				if (x > xUnite(150) && x < xUnite(320) && y > yUnite(130)
						&& y < yUnite(190))

				{

					// le bouton 2 (jeu en ligne) a été cliqué

				}

				if (x > xUnite(150) && x < xUnite(320) && y > yUnite(220)
						&& y < yUnite(280))

				{

					// le bouton 3 (jeu en ligne) a été cliqué
					// game.setScreen(new NouvJeu(game));

				}

				if (x > xUnite(0) && x < xUnite(64) && y > yUnite(0)
						&& y < yUnite(64))

				{

					// le bouton retour a été cliqué
					Manager.getInstance().getVue().getMoi().setScreen(new Menu());

				}

				cliqueBouton1 = false;

				cliqueBouton2 = false;

				cliqueBouton3 = false;

				return false;

			}

			@Override
			public boolean touchDown(int x, int y, int pointer, int bouton) {

				if (x > xUnite(160) && x < xUnite(260) && y > yUnite(35)
						&& y < yUnite(90))

				{

					cliqueBouton1 = true;

				}

				if (x > xUnite(120) && x < xUnite(318) && y > yUnite(130)
						&& y < yUnite(190))

				{

					cliqueBouton2 = true;

				}

				if (x > xUnite(70) && x < xUnite(408) && y > yUnite(220)
						&& y < yUnite(280))

				{

					cliqueBouton3 = true;

				}

				return false;

			}

			@Override
			public boolean touchDragged(int arg0, int arg1, int arg2) {

				return false;

			}

			@Override
			public boolean scrolled(int arg0) {

				return false;

			}

			@Override
			public boolean mouseMoved(int arg0, int arg1) {

				return false;

			}

			@Override
			public boolean keyUp(int arg0) {

				return false;

			}

			@Override
			public boolean keyTyped(char arg0) {

				return false;

			}

			@Override
			public boolean keyDown(int arg0) {

				return false;

			}

		});

	}

	/**
	 * Méthode qui va afficher le menu à l'écran
	 */
	public void dessinerMenu() {
		// obligatoire pour commencer un dessin sur le SpriteBatch
		batch.begin();

		// arrierePlan
		arrierePlanSprite.draw(batch);

		// bouton 1
		if (!cliqueBouton1) {

			// Fixer la position
			boutonSpriteSon.setPosition(xposBouton1, yposBouton1);
			// Puis le dessiner
			boutonSpriteSon.draw(batch);

		} else {
			boutonCliqueSprite.setPosition(xposBouton1, yposBouton1);
			boutonCliqueSprite.draw(batch);
		}

		// bouton 2
		if (!cliqueBouton2) {
			// fixer la position
			boutonSpriteMusic.setPosition(xposBouton2, yposBouton2);
			// puis le dessiner
			boutonSpriteMusic.draw(batch);

		} else {
			boutonCliqueSprite.setPosition(xposBouton2, yposBouton2);
			boutonCliqueSprite.draw(batch);
		}

		if (!cliqueBouton3) {

			// fixer la position
			boutonSpriteVitesse.setPosition(xposBouton3, yposBouton3);
			// puis le dessiner
			boutonSpriteVitesse.draw(batch);

		} else {
			boutonCliqueSprite.setPosition(xposBouton3, yposBouton3);
			boutonCliqueSprite.draw(batch);
		}

		boutonRetourSprite.draw(batch);
		batch.end(); // obligatoire pour finir le dessin sur un SpriteBatch

	}

	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resize(int arg0, int arg1) {

	}

	@Override
	public void resume() {

	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		manipulerMenu(); // Gestion des input

		// Contenu de la page menu
		dessinerMenu();

	}

	@Override
	public void hide() {
	}

}
