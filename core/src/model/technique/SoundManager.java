package model.technique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;

/**
 * Classe qui gère les effets sonores
 * 
 * @author Benjamin Bertrand
 */
public class SoundManager implements Disposable {

	private Music soundResource;
	private FileHandle soundFile;

	/** Enumeration des sons disponibles */
	public enum LandRiskSound {
		// On recupere les sfx dans le dossier asset du projet android
		CLICK("sound/click.mp3"); //Effet sonore d'un clic

		private final String fileName;

		private LandRiskSound(String fileName) {
			this.fileName = fileName;
		}

		public String getFileName() {
			return fileName;
		}
	}

	/** Le volume par défaut du sfx */
	private float volume = 1f;

	/** Indique si le sfx est activé */
	private boolean enabled = true;

	/**
	 * Constructeur de la classe
	 */
	public SoundManager() {
	}

	/**
	 * Execute le sfx souhaité.
	 * 
	 * @param sound
	 *            le Sfx qui l'on souhaite jouer
	 */
	public void play(LandRiskSound sound) {
		// On regarde si un son est activé
		if (!enabled) {
			return;
		}

		// On lance le son
		soundFile = Gdx.files.internal(sound.getFileName());
		soundResource = Gdx.audio.newMusic(soundFile);
		soundResource.setVolume(volume);
		soundResource.play();
	}

	/**
	 * Ajustement du volume du sfx avec une valeur comprise dans la fourchette
	 * suivante [0,1].
	 */
	public void setVolume(float volume) {
		if (volume < 0 || volume > 1f) {
			throw new IllegalArgumentException(
					"Le volume doit être compris entre [0,1]");
		}
		this.volume = volume;
	}

	/**
	 * Active ou desactive la musique
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * On stop le sfx
	 */
	public void dispose() {
		soundResource.stop();
	}
}