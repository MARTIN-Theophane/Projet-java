public class Porte {
	private int num_porte;
	private boolean etat;
	
	public Porte(int num_porte, boolean etat) {
		this.num_porte = num_porte;
		this.etat = etat;
	}

	boolean fermerPorte() {
		etat = !etat;
		return etat;
	}
}
