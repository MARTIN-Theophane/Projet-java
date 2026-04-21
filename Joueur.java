import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Joueur extends JFrame {
	int regard = 2; //Définit où le joueur regarde
	
	public Joueur() {
		//Fenêtre du jeu
		setTitle("Détection de touches spécifiques");
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
	
	//Méthode permettant l'action entraainé par l'appui d'une touche
	private void ActionTouches(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Q:
			if (this.regard != 1) {
				this.regard -= 1;
			}
			switch (this.regard) {
			case 1 -> System.out.println("Vous regardez à gauche de vous.");
			case 2 -> System.out.println("Vous regardez en face de vous.");
			case 3 -> System.out.println("Vous regardez à droite de vous.");
			}
			break;
		case KeyEvent.VK_D:
			if (this.regard != 3) {
				this.regard += 1;
			}
			switch (this.regard) {
			case 1 -> System.out.println("Vous regardez à gauche de vous.");
			case 2 -> System.out.println("Vous regardez en face de vous.");
			case 3 -> System.out.println("Vous regardez à droite de vous.");
			}
			break;
		case KeyEvent.VK_A:
			System.out.println("Vous avez allumer ou éteint la lumière de gauche.");
			break;
		case KeyEvent.VK_E:
			System.out.println("Vous avez allumer ou éteint la lumière de droite.");
			break;
		case KeyEvent.VK_W:
			System.out.println("Vous avez ouvert ou fermer la porte de gauche.");
			break;
		case KeyEvent.VK_C:
			System.out.println("Vous avez ouvert ou fermer la porte de droite.");
			break;
		case KeyEvent.VK_F1:
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