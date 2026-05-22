public class Bouton_porte {
	
//définition des attributs
	private int num_bouton_porte;
	private Porte porte;
	
//constructeur
	public Bouton_porte(int num_bouton_porte, Porte porte) {
		this.num_bouton_porte = num_bouton_porte;
		this.porte = porte;
	}

//getter
	public Porte getPorte() {
		return this.porte;
	}
	
//méthode permettant de faire l'action d'appuyer sur le bouton des portes
	void appuyerBoutonPorte() {
		this.porte.fermerPorte();
	}
}
