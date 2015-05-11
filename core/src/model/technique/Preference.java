package model.technique;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Classe qui permet de changer les préférences audio et de les
 * sauvegarder/restaurer.
 * La méthode "preference" de libgdx fonctionne de manière similaire à un hashmap
 * 
 * Aide puisé dans le tuto  suivant : http://steigert.blogspot.fr/2012/03/6-libgdx-tutorial-preferences.html
 *
 *
 * @author Benjamin Bertrand
 *
 */
public class Preference {

	/** Instanciation du hashmap **/
	private Preferences pref;
	/** Nom du hashmap **/
	private static final String PREF_NAME = "reglageApp"; 
	/** Clé du hashmap lié au musique activé **/
	private static final String PREF_MUSIC_ENABLED = "musicEnabled";
	/** Clé du hashmap lié au SFX activé **/
	private static final String PREF_SOUND_ENABLED = "soundEnabled";
	/** Clé du hashmap lié au volume de la musique **/
	private static final String PREF_MUSIC_VOLUME = "musicVolume" ; 

	
	/**
	 * Constructeur de la classe
	 */
	public Preference() {
	}

	/**
	 * Singleton de la classe
	 * 
	 * @return pref Instanciation du hashmap preferences
	 */
	protected Preferences getPrefs() {
		if (pref == null) {
			pref = Gdx.app.getPreferences(PREF_NAME);
		}
		return pref;
	}

	/**
	 * Retourne vrai si les effets sonores sont activés
	 * @return vrai
	 */
	public boolean isSoundEffectsEnabled() {
		return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
	}

	/**
	 * Permet d'activer ou non les effets sonores
	 * @param soundEffectsEnabled Valeur booléenne qui permet d'activer ou non les effets sonores
	 */
	public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
		getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled);
		getPrefs().flush();
	}

	/**
	 * Retourne vrai si la musique est activé
	 * @return vrai
	 */
	public boolean isMusicEnabled() {
		return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
	}

	
	/**
	 * Permet d'activer ou non la music
	 * @param soundEffectsEnabled Valeur booléenne qui permet d'activer ou non le son
	 */
	public void setMusicEnabled(boolean musicEnabled) {
		getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled);
		getPrefs().flush();
	}
	
	
	/**
	 * Regle le volume sonore du jeu pour celui par défaut.
	 * @return Volume au maximum
	 */
	public int isMusicVolumeDefault(){
		return getPrefs().getInteger(PREF_MUSIC_VOLUME, 100);
	}
	
	
	/**
	 * Permet de régler le volume de la musique
	 * @param valeur int du volume sonore
	 */
	public void setMusicVolume(int volume) {
		getPrefs().putInteger(PREF_MUSIC_VOLUME, volume);
		getPrefs().flush();	
	}
	
}
