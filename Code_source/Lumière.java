import java.util.ArrayList;

public class Lumière {
	private int num_lumiere;
	private boolean etat;
	ArrayList<Animatronique> animatroniques;
	
	public Lumière(int num_lumiere, boolean etat) {
		this.num_lumiere = num_lumiere;
		this.etat = etat;
	}
	
	void eteindreLumiere(){
		etat = !etat;
	}
	
	
	public boolean getEtat(){
		return etat;
	}

	//animatronique à la porte ?
	void AnimPorte(boolean etat) {
		for (int i = 0 ; i <= animatroniques.size() ; i++) {
			if (etat == true) {
				if (animatroniques.get(i).getId_espece() == 0); {
					if (animatroniques.get(i).getNum_position() == 14) {
						System.out.println("Bonnie est à la porte");
					} else {
						System.out.println("Il n'y a personne à la porte");
					}
				}
				if (animatroniques.get(i).getId_espece() == 1); {
					if (animatroniques.get(i).getNum_position() == 15) {
						System.out.println("Chica est à la porte");
					} else {
						System.out.println("Il n'y a personne à la porte");
					}
				}
			}
		}
	}
	
	public int getNum_lumiere() {
		return num_lumiere;
	}
	public void setNum_lumiere(int num_lumiere) {
		this.num_lumiere = num_lumiere;
	}
	public boolean getOccupe() {
		return etat;
	}
	public void setOccupe(boolean etat) {
		this.etat = etat;
	}
	public ArrayList<Animatronique> getAnimatroniques() {
		return animatroniques;
	}
	public void setAnimatroniques(ArrayList<Animatronique> animatroniques) {
		this.animatroniques = animatroniques;
	}	
}