public class Bouton_lumiere {
	
//définition des attributs
	int num_bouton_lumiere;
	Lumière lumiere;
	
//constructeur
	public Bouton_lumiere(int num_bouton_lumiere, Lumière lumiere) {
		this.num_bouton_lumiere = num_bouton_lumiere;
		this.lumiere = lumiere;
	}

//getter
	public Lumière getLumiere() {
		return this.lumiere;
	}
	
//méthode permettant de faire l'action d'appuyer sur le bouton des lumières
	void appuyerBoutonLumiere() {
		lumiere.eteindreLumiere();
	}
}
