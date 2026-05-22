
public class Animatronique {
	
// Définition des attribut
	private int id_espece;
	private int num_position;
	private int time;
	private boolean move;
	private int tour;
	
// Constructeur
	public Animatronique(int id_espece, int num_position) {
		this.id_espece = id_espece;
		this.num_position = num_position;
		this.move = true;
		this.tour = 0;
		this.time = 0;
	}
// Getter
	public int getId_espece() {
		return id_espece;
	}

	public int getNum_position() {
		return num_position;
	}

	public int getTime() {
		return time;
	}
	
	public boolean getMove() {
		return move;
	}
	public int getTour() {
		return tour;
	}

	
// Setter
	public void setId_espece(int id_espece) {
		this.id_espece = id_espece;
	}

	public void setTime(int time) {
        this.time = time;
    }
	
	public void setMove(boolean move) {
		this.move = move;
	}
	
	public void setTour(int tour) {
		this.tour = tour;
	}
	
	public void setNum_position(int num_position) {
		this.num_position = num_position;
		
		switch (this.id_espece) {
		
		case 0 :
			if (this.tour<7) {
				this.tour ++;
			} else {
				this.tour = 0;
			}
		break;
		
		case 1 :
			if (this.tour<7) {
				this.tour ++;
			} else {
				this.tour = 0;
			}
		break;
		
		case 2 :
			if (this.tour<5) {
				this.tour ++;
			} else {
				this.tour = 0;
			}
		break;
		
		case 3 :
			if (this.tour<6) {
				this.tour ++;
			} else {
				this.tour = 0;
			}
		break;
		
		}
		
		System.out.println("La position de l'anim "+this.id_espece+" est "+this.num_position);
	}
	
	public void setChrono() {
        // Initialise aléatoirement le chrono des animatroniques
        this.time = ((int) (Math.random()*20))+20;
    }
	
	public boolean decompte() {
	    // Retire 1 au chronos des animatronique s'il ne sont pas arrivé à 0
	        this.time--;
	        if (this.time>0) {
	            //System.out.println("Le temps de l'anim "+this.id_espece+" a pour temps "+this.time);
	            return true;
	        } else {
	            //System.out.println("Le temps de l'anim "+this.id_espece+" a pour temps "+this.time);
	            return false;
	        }
	}
	
}
	
	
	// Scène = 1
	// Salle à manger = 2
	// Crique des pirates (rideau fermés) = 31
	// Crique des pirates (rideau légèrement ouvert) = 32
	// Crique des pirates (rideau ouvert) = 33
	// Crique des pirates (rideau ouvert (sans Foxy)) = 34
	// pièce d'entretien = 4
	// Toilette = 5
	// cuisine = 6
	// placard = 7
	// couloir gauche = 8
	// coin du couloir gauche = 9
	// couloir droit = 10
	// coin du couloir droit = 11
	// porte gauche = 12
	// porte droite = 13
	// Bureau = 14
	
	// Num des Animatroniques :
	// Bonnie = 0
	// Chica = 1
	// Foxy = 2
	// Freddy = 3
