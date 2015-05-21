package model.technique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;

/**
 * Controleur qui se charge de gérer les musiques.
 * <p>
 * Une seule musique peut-être joué à la fois
 * 
 * @author Benjamin Bertrand
 *
 */
public class MusicManager implements Disposable {

	/** Indique si une musique est en cours de lecture */
	private LandRiskMusic musicBeingPlayed;
	/** Le volume par défaut de la musique */
	private float volume = 1f;
	/** Indique si une musique est en cours de lecture */
	private boolean enabled = true;

	/**
	 * Enumération des musiques disponible.
	 */
	public enum LandRiskMusic {
		// On recupere les musiques dans le dossier asset du projet android
		/** Musique du menu (si besoin) */
		MENU("music/augha.mp3"),
		/** Musique du plateau de jeu */
		MAP("music/adarkheart.mp3"); 
		//MAP(music/beneaththeshadows.mp3);

		private String fileName;
		private Music musicResource;

		private LandRiskMusic(String fileName) {
			this.fileName = fileName;
		}

		public String getFileName() {
			return fileName;
		}

		public Music getMusicResource() {
			return musicResource;
		}

		public void setMusicResource(Music musicBeingPlayed) {
			this.musicResource = musicBeingPlayed;
		}
	}

	/**
	 * Constructeur de la classe
	 */
	public MusicManager() {
	}

	/**
	 * Joue la musique sélectionnée.
	 * <p>
	 * Si une musique est déjà en cours de lecture, celle-ci sera stoppé
	 * automatiquement
	 */
	public void play(LandRiskMusic music) {
		// On regarde si une musique est en cours de lecture
		if (!enabled) {
			return;
		}

		// On vérifie si la musique sélectionnée est déjà en cours de lecture
		if (musicBeingPlayed == music) {
			return;
		}

		// On arrête la musique en cours de lecture
		stop();

		// On lance la nouvelle musique
		FileHandle musicFile = Gdx.files.internal(music.getFileName());
		Music musicResource = Gdx.audio.newMusic(musicFile);
		musicResource.setVolume(volume);
		musicResource.setLooping(true);
		musicResource.play();

		// On se souvient de la musique en cours de lecture
		musicBeingPlayed = music;
		musicBeingPlayed.setMusicResource(musicResource);
	}

	/**
	 * Arrête et élimine n'importe quelle musique en cours de lecture.
	 */
	public void stop() {
		if (musicBeingPlayed != null) {
			Music musicResource = musicBeingPlayed.getMusicResource();
			musicResource.stop();
			musicResource.dispose();
			musicBeingPlayed = null;
		}
	}

	/**
	 * Ajustement du volume de la musique avec une valeur comprise dans la
	 * fourchette suivante [0,1].
	 */
	public void setVolume(float volume) {
		// On vérifie le niveau du volume
		if (volume < 0 || volume > 1f) {
			throw new IllegalArgumentException(
					"Le volume doit être compris entre [0,1]");
		}
		this.volume = volume;

		// Si une musique est en cours de lecture, on change son volume
		if (musicBeingPlayed != null) {
			musicBeingPlayed.getMusicResource().setVolume(volume);
		}
	}

	/**
	 * Active ou desactive la musique
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
		//Si une musique est en train d'être désactivée, on arrête la musique 
		if (!enabled) {
			stop();
		}
	}

	/**
	 * On tue le manager musicale
	 */
	@Override
	public void dispose() {
		stop();
	}

}
