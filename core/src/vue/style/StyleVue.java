package vue.style;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Classe abstracte pour les écrans de jeu.
 * 
 * @author Benjamin Bertrand
 *
 */
public class StyleVue {

	private BitmapFont font;
	private SpriteBatch batch;
	private Skin skin;
	private TextureAtlas atlas;
	private FileHandle skinFile;

	/**
	 * Constructeur de la classe
	 */
	public StyleVue() {
	}

	/**
	 * Retourne le nom de l'écran actuellement affiché. Utile pour faire des
	 * tests.
	 * 
	 * @return Le nom de la classe
	 */
	protected String getNomScreen() {
		return getClass().getSimpleName();
	}

	/**
	 * Retourne une police de caractère.
	 * 
	 * @return font Une police de caractère
	 */
	public BitmapFont getFont() {
		if (font == null) {
			font = new BitmapFont();
		}
		return font;
	}

	/**
	 * Methode qui retourne une SpriteBatch
	 * 
	 * @return batch
	 */
	public SpriteBatch getBatch() {

		if (batch == null) {
			batch = new SpriteBatch();
		}
		return batch;
	}

	/**
	 * Methode qui retourne une skin
	 * 
	 * @return skin
	 */
	public Skin getSkin() {
		if (skin == null) {
			skinFile = Gdx.files.internal("skin/uiskin.json");
			skin = new Skin(skinFile);
		}
		return skin;
	}

	/**
	 * Methode qui retourne une texture
	 * 
	 * @return atlas Une texture
	 */
	public TextureAtlas getAtlas() {
		return atlas;
	}

}
