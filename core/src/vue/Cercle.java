package vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

/**
 * Classe qui se charge de créer un cercle
 * 
 * @author Benjamin Bertrand
 *
 */
public class Cercle extends Actor {

	private float x, y, radius;
	private ShapeRenderer sr;
	private Color couleur;

	private Label lbl;
	private LabelStyle lblStyle;
	private BitmapFont bFont;
	private Stage stage;
	
	

	/**
	 * Constructeur de la classe
	 * 
	 * @param x
	 *            Coordonnée x du cercle
	 * @param y
	 *            Coordonnée y du cercle
	 * @param radius
	 *            Taille du cercle
	 */
	public Cercle(float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		
		stage = new Stage();
		sr = new ShapeRenderer();
		bFont = new BitmapFont(Gdx.files.internal("default.fnt"));
		lblStyle = new LabelStyle(bFont, Color.WHITE);
		lbl = new Label(null, lblStyle);
	}

	/**
	 * Méthode qui affiche le cercle
	 * 
	 * @param batch
	 *            SpriteBatch du screen
	 * @param couleur
	 *            Couleur du cercle
	 * @param txt
	 *            Texte à l'intérieur du cercle
	 * 
	 */
	public void dessiner(SpriteBatch batch, Color couleur, String txt) {
				
		batch.end();
		
		bFont.scale(1f); // Taille de la police de caractère

		sr.begin(ShapeRenderer.ShapeType.Filled);

		// Premier cercle qui va servir de bordure noir
		sr.setColor(Color.BLACK);
		sr.circle(x, y, radius);

		// Deuxième cercle avec la couleur du joueur
		sr.setColor(couleur);
		sr.circle(x, y, radius - 10);

		sr.end();

		lbl.setText(txt);
		lbl.setPosition(getX() - 10, getY());

		stage.addActor(lbl);
		stage.draw();
		
		batch.begin();

	}

	public void dispose() {
		sr.dispose();
	}
	
	
	
	/**
	 * Retourne l'ordonné X du cercle
	 */
	public float getX() {
		return x;
	}

	/**
	 * Retourne l'ordonné Y du cercle
	 */
	public float getY() {
		return y;
	}

	/**
	 * Retourne la couleur du cercle
	 * 
	 * @return Couleur du cercle
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Défini une couleur au cercle
	 * 
	 * @param couleur
	 *            La couleur que l'on souhaite afficher
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * Methode qui récupère le contenu d'un label
	 * @return lbl La chaine de caractère contenu dans un label
	 */
	public Label getLbl() {
		return lbl;
	}

	/**
	 * Methode qui défini le contenu d'un label
	 * @param lbl Chaine de caractère que l'on souhaite afficher
	 */
	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}
	
}
