public class Lumière {
	private int num_lumiere;
	private boolean etat;
	
	public Lumière(int num_lumiere, boolean etat) {
		this.num_lumiere = num_lumiere;
		this.etat = etat;
	}
	
	boolean eteindreLumiere() {
		etat = !etat;
		return etat;
	}
}
