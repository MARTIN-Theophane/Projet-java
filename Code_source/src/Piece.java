import java.util.ArrayList;
public class Piece {

// définition attribut
	private int id_piece;
	private int place_max;
	private ArrayList<Animatronique> population = new ArrayList<>();
	
// Constructeur	
	public Piece(int id_piece, int place_max) {
		this.id_piece = id_piece;
		this.place_max = place_max;
	}
	
// Getters
	public int getId_piece() {
		return id_piece;
	}
	public int getPlace_max() {
		return place_max;
	}
	public ArrayList<Animatronique> getPopulation() {
		return population;
	}
	
// Setter
	public void setId_piece(int id_piece) {
		this.id_piece = id_piece;
	}
	public void setPlace_max(int place_max) {
		this.place_max = place_max;
	}
	public void setPopulation(ArrayList<Animatronique> population) {
		this.population = population;
	}
	
// Fonction ajouterAnim
	public void ajouterAnim(Animatronique anim) {
	// Ajoute un animatronique à la population de la pièce
		if (this.population.size()<=place_max) {
			this.population.add(anim);
			//System.out.println("l'anim "+anim.getId_espece()+"a été ajouter à la pièce"+this.getId_piece());
			//System.out.print("La nouvelle population de la pièce "+this.getId_piece()+" est : ");
			for (int i=0;i<this.population.size();i++) {
				//System.out.print(population.get(i).getId_espece()+", ");
			}
			//System.out.println();
		}
	}
// Fonction supprimerAnim
	
	public void supprimerAnim(Animatronique anim) {
	// Supprime un nimatronique donné de la population de la pièce
		for (int i=0;i<this.population.size();i++) {
			if (this.population.get(i).getId_espece()==anim.getId_espece()) {
				this.population.remove(i);
				//System.out.print("La nouvelle population de la pièce"+this.getId_piece()+" est : ");
				for (int j=0;j<this.population.size();j++) {
					//System.out.print(population.get(j).getId_espece()+", ");
				}
				//System.out.println();
			}
		}
	}
	


	
	
	
	// Scène = 1
	// Salle à manger = 2
	// Crique des pirates = 3
	// réserve = 4
	// Toilette = 5
	// cuisine = 6
	// placard = 7
	// couloir gauche = 8
	// coin du couloir gauche = 9
	// couloir droit = 10
	// coin du couloir droit = 11
	// porte gauche = 12
	// porte droite = 13
	// Bureau = 15

	
}
