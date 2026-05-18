public class Porte {
	private int num_porte;
	private boolean etat;
	
	public Porte(int num_porte, boolean etat) {
		this.num_porte = num_porte;
		this.etat = etat;
	}
	
	void fermerPorte() {
		etat = !etat;
	}
	


	public int getNum_porte() {
		return num_porte;
	}
	public boolean getEtat() {
		return etat;
	}
}