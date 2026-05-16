public class Lumière {
	int num_lumiere;
	boolean etat;
	Animatronique animatronique;
	
//éteindre la lumière
	void eteindreLumiere() {
		etat = !etat;
	}

//animatronique à la porte ?
	void AnimPorte(boolean etat) {
		if (etat == true) {
			if (animatronique.getId_espece() == 0); {
				if (animatronique.getNum_position() == 14) {
					System.out.println("Bonnie est à la porte");
				} else {
					System.out.println("Il n'y a personne à la porte");
				}
			}
			if (animatronique.getId_espece() == 1); {
				if (animatronique.getNum_position() == 15) {
					System.out.println("Chica est à la porte");
				} else {
					System.out.println("Il n'y a personne à la porte");
				}
			}
		}
	}
}
