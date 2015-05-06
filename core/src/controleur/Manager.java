package controleur;

/**
 * Description : Class Singleton Manager
 */
public class Manager {

	//instance unique
	private static Manager instance = new Manager();
	
	//constructeur
	private Manager() {
	
	}

	//retourne instance unique
	public static Manager getInstance() {
		return instance;
	}

}
