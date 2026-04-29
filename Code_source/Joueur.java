import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Joueur extends JFrame {
	int regard = 2; //Définit où le joueur regarde
	
	//Création des lumieres et de leurs boutons
	private Lumière lumiere_gauche = new Lumière(1,false);
	private Lumière lumiere_droite = new Lumière(2,false);
	Bouton_lumiere bouton_lumiere_gauche = new Bouton_lumiere(1,lumiere_gauche);
	Bouton_lumiere bouton_lumiere_droite = new Bouton_lumiere(2,lumiere_droite);
	
	//Création des portes et de leurs boutons
	private Porte porte_gauche = new Porte(1,false);
	private Porte porte_droite = new Porte(2,false);
	Bouton_porte bouton_porte_gauche = new Bouton_porte(1,porte_gauche);
	Bouton_porte bouton_porte_droite = new Bouton_porte(1,porte_droite);
	
	public Joueur() {
		//Fenêtre du jeu
		setTitle("Projet java");
		setSize(400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(-2000,-2000);
		
		//Lance l'action des touches quand une touche est cliqué
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				ActionTouches(e);
			}
		});
		
		//Rend visible la fenêtre
		setFocusable(true);
		setVisible(true);
		
		System.out.println("Le jeu est lancé.");
	}
	
	//Méthode permettant l'action entrainé par l'appui d'une touche
	private void ActionTouches(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q: //Regarder plus à droite
			if (this.regard != 1) {
				this.regard -= 1;
			}
			switch (this.regard) {
			case 1 -> System.out.println("Vous regardez à gauche de vous.");
			case 2 -> System.out.println("Vous regardez en face de vous.");
			case 3 -> System.out.println("Vous regardez à droite de vous.");
			}
			break;
		case KeyEvent.VK_D: //Regarder plus à gauche
			if (this.regard != 3) {
				this.regard += 1;
			}
			switch (this.regard) {
			case 1 -> System.out.println("Vous regardez à gauche de vous.");
			case 2 -> System.out.println("Vous regardez en face de vous.");
			case 3 -> System.out.println("Vous regardez à droite de vous.");
			}
			break;
		case KeyEvent.VK_A: //Lumière gauche
			if (this.bouton_lumiere_gauche.appuyerBoutonLumiere() == false) {
				System.out.println("Vous avez éteint la lumière de gauche.");
			} else {
				System.out.println("Vous avez allumé la lumière de gauche.");
			}
			break;
		case KeyEvent.VK_E: //Lumière droite
			if (this.bouton_lumiere_droite.appuyerBoutonLumiere() == false) {
				System.out.println("Vous avez éteint la lumière de droite.");
			} else {
				System.out.println("Vous avez allumé la lumière de droite.");
			}
			break;
		case KeyEvent.VK_W: //Porte gauche
			if (this.bouton_porte_gauche.appuyerBoutonPorte() == false) {
				System.out.println("Vous avez ouvert la porte de gauche.");
			} else {
				System.out.println("Vous avez fermé la porte de gauche.");
			}
			break;
		case KeyEvent.VK_C: //Porte droite
			if (this.bouton_porte_droite.appuyerBoutonPorte() == false) {
				System.out.println("Vous avez ouvert la porte de droite.");
			} else {
				System.out.println("Vous avez fermé la porte de droite.");
			}
			break;
		case KeyEvent.VK_F1: //Liste des touches
			System.out.println();
			System.out.println("Liste des touches");
			System.out.println("Regarder vers la gauche : Q");
			System.out.println("Regarder vers la droite : D");
			System.out.println("Actionner l'interrupteur gauche : A");
			System.out.println("Actionner l'interrupteur droite : E");
			System.out.println("Actionner la porte gauche : W");
			System.out.println("Actionner la porte droite : C");
			break;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(Joueur::new);
	}
}
