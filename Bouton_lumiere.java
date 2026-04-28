public class Bouton_lumiere {
	int num_bouton_lumiere;
	Lumière lumiere;
	
	public Bouton_lumiere(int num_bouton_lumiere, Lumière lumiere) {
		this.num_bouton_lumiere = num_bouton_lumiere;
		this.lumiere = lumiere;
	}

	boolean appuyerBoutonLumiere() {
		return lumiere.eteindreLumiere();
	}
