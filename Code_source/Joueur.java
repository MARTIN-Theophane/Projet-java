import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Joueur extends JFrame {
	//Création des lumieres et de leurs boutons
		private Lumière lumiere_gauche;
		private Lumière lumiere_droite;
		private Bouton_lumiere bouton_lumiere_gauche = new Bouton_lumiere(1,lumiere_gauche);
		private Bouton_lumiere bouton_lumiere_droite = new Bouton_lumiere(2,lumiere_droite);
		
		//Création des portes et de leurs boutons
		private Porte porte_gauche = new Porte(1,false);
		private Porte porte_droite = new Porte(2,false);
		private Bouton_porte bouton_porte_gauche = new Bouton_porte(1,porte_gauche);
		private Bouton_porte bouton_porte_droite = new Bouton_porte(1,porte_droite);
	
	Caméra cam = new Caméra(lumiere_gauche,lumiere_droite);
	ArrayList<Piece> pieces;
	
	public Joueur(ArrayList<Piece> pieces,Lumière lumiere_gauche,Lumière lumiere_droite) {
		this.pieces = pieces;
		this.lumiere_gauche = lumiere_gauche;
		this.lumiere_droite = lumiere_droite;
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
		case KeyEvent.VK_A: //Lumière gauche
            if (this.bouton_lumiere_gauche.getLumiere().getEtat() == false) {
                this.bouton_lumiere_gauche.appuyerBoutonLumiere();
                System.out.println("Vous avez éteint la lumière de gauche.");
            } else {
                System.out.println("Vous avez allumé la lumière de gauche.");
            }
            break;
        case KeyEvent.VK_E: //Lumière droite
            if (this.bouton_lumiere_droite.getLumiere().getEtat() == false) {
                this.bouton_lumiere_droite.appuyerBoutonLumiere();
                System.out.println("Vous avez éteint la lumière de droite.");
                
            } else {
                System.out.println("Vous avez allumé la lumière de droite.");
            }
            break;
		case KeyEvent.VK_W: //Porte gauche
            if (this.bouton_porte_gauche.getPorte().getEtat() == false) {
                this.bouton_porte_gauche.appuyerBoutonPorte();
                System.out.println("Vous avez ouvert la porte de gauche.");
            } else {
                System.out.println("Vous avez fermé la porte de gauche.");
            }
            break;
        case KeyEvent.VK_C: //Porte droite
            if (this.bouton_porte_droite.getPorte().getEtat() == false) {
                this.bouton_porte_droite.appuyerBoutonPorte();
                System.out.println("Vous avez ouvert la porte de droite.");
            } else {
                System.out.println("Vous avez fermé la porte de droite.");
            }
            break;
		case KeyEvent.VK_SPACE: //Caméra
			cam.allumerCameras(pieces.get(0),0);		
			break;
		/*case KeyEvent.VK_RIGHT:
			if (cam.getEtat()) {
				int num_piece = cam.getNum_piece();
				if (cam.getNum_piece() != 15) {
					num_piece = cam.getNum_piece() + 1;
				}
				cam.allumerCameras(pieces.get(num_piece),num_piece);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (cam.getEtat()) {
				int num_piece = cam.getNum_piece();
				if (cam.getNum_piece() != 0) {
					num_piece = cam.getNum_piece() - 1;
				}
				cam.allumerCameras(pieces.get(num_piece),num_piece);
			}
			break;*/
		case KeyEvent.VK_ESCAPE: //Quitter le jeu
			System.out.println("Le jeu est fermé.");
			System.exit(0);
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
			System.out.println("Quitter le jeu : Echap");
			break;
		}
	}
	
	public Lumière getLumiere_gauche() {
		return lumiere_gauche;
	}
	public Lumière getLumiere_droite() {
		return lumiere_droite;
	}
	public Bouton_lumiere getBouton_lumiere_gauche() {
		return bouton_lumiere_gauche;
	}
	public Bouton_lumiere getBouton_lumiere_droite() {
		return bouton_lumiere_droite;
	}
	public Porte getPorte_gauche() {
		return porte_gauche;
	}
	public Porte getPorte_droite() {
		return porte_droite;
	}
	public Bouton_porte getBouton_porte_gauche() {
		return bouton_porte_gauche;
	}
	public Bouton_porte getBouton_porte_droite() {
		return bouton_porte_droite;
	}
}