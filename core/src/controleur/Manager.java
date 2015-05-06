package controleur;

import vue.Vue;

/**
 * Description : Class Singleton Manager
 */
public class Manager {

	//instance unique
	private static Manager instance = new Manager();
	//vue
	private Vue vue;
	
	//constructeur
	private Manager() {
	
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

}
