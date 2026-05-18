public class Bouton_porte {
	private int num_bouton_porte;
	private Porte porte;
	
	public Bouton_porte(int num_bouton_porte, Porte porte) {
		this.num_bouton_porte = num_bouton_porte;
		this.porte = porte;
	}

	public Porte getPorte() {
		return this.porte;
	}
	
	void appuyerBoutonPorte() {
		this.porte.fermerPorte();
	}
}