public class Bouton_porte {
	private int num_bouton_porte;
	private Porte porte;
	
	public Bouton_porte(int num_bouton_porte, Porte porte) {
		this.num_bouton_porte = num_bouton_porte;
		this.porte = porte;
	}

	boolean appuyerBoutonPorte() {
		return porte.fermerPorte();
	}
}
