import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

//attributs de la classe
public class Caméra {
	boolean etat;
	int num_piece;
	Piece piece;
	Lumière lumiere;
	
//change l'état des caméras de allumées à éteintes et inversement
	void allumerCameras() {
		etat = !etat;
	}
	
//affichages des bonnes images des caméras
	void afficherCamera(Piece piece) {
		for (int i = 0; i < piece.getPopulation().size(); i++) {
			switch (piece.getId_piece()) { //pour chaque pièce	
			case 0 :
				switch (piece.getPopulation().size()) { //pour chaque nombre d'animatroniques sur scène	
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/scene_vide.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				case 1 :
					JFrame frame2 = new JFrame("Mon jeu");
			        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur2 = screenSize2.width;
			        int hauteur2 = screenSize2.height;
			        ImageIcon iconOriginal2 = new ImageIcon("Images/cuisine.png");
			        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
			        JLabel label2 = new JLabel(iconOriginal2);
			        frame2.add(label2);
			        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame2.setVisible(true);
				    
				case 2 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon("Images/cuisine.png");
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
				
				case 3 :
					JFrame frame4 = new JFrame("Mon jeu");
			        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize4 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur4 = screenSize4.width;
			        int hauteur4 = screenSize4.height;
			        ImageIcon iconOriginal4 = new ImageIcon("Images/cuisine.png");
			        Image imageRedim4 = iconOriginal4.getImage().getScaledInstance(largeur4, hauteur4, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal4 = new ImageIcon(imageRedim4);
			        JLabel label4 = new JLabel(iconOriginal4);
			        frame4.add(label4);
			        frame4.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame4.setVisible(true);
				}
				
			case 1 :
				switch (piece.getPopulation().size()) { //nombre d'animatronique dans la pièce
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/salle_a_manger_vide.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				    
				case 1 :
					switch (piece.getPopulation().get(0).getId_espece()) { //quel animatronique est dans la pièce
					case 0 :
						if (piece.getPopulation().get(0).getNum_position() == 0) {
							JFrame frame1 = new JFrame("Mon jeu");
					        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur1 = screenSize1.width;
					        int hauteur1 = screenSize1.height;
					        ImageIcon iconOriginal1 = new ImageIcon("Images/salle_a_manger_bonnie.png");
					        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
					        JLabel label1 = new JLabel(iconOriginal1);
					        frame1.add(label1);
					        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame1.setVisible(true);
						} else {
							JFrame frame2 = new JFrame("Mon jeu");
					        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur2 = screenSize2.width;
					        int hauteur2 = screenSize2.height;
					        ImageIcon iconOriginal2 = new ImageIcon("Images/salle_a_manger_vide.png");
					        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
					        JLabel label2 = new JLabel(iconOriginal2);
					        frame2.add(label2);
					        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame2.setVisible(true);
						}
					
					case 1 :
						if (piece.getPopulation().get(0).getNum_position() == 1) {
							JFrame frame3 = new JFrame("Mon jeu");
					        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur3 = screenSize3.width;
					        int hauteur3 = screenSize3.height;
					        ImageIcon iconOriginal3 = new ImageIcon("Images/salle_a_manger_chica.png");
					        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
					        JLabel label3 = new JLabel(iconOriginal3);
					        frame3.add(label3);
					        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame3.setVisible(true);
						} else {
							JFrame frame4 = new JFrame("Mon jeu");
					        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize4 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur4 = screenSize4.width;
					        int hauteur4 = screenSize4.height;
					        ImageIcon iconOriginal4 = new ImageIcon("Images/salle_a_manger_vide.png");
					        Image imageRedim4 = iconOriginal4.getImage().getScaledInstance(largeur4, hauteur4, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal4 = new ImageIcon(imageRedim4);
					        JLabel label4 = new JLabel(iconOriginal4);
					        frame4.add(label4);
					        frame4.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame4.setVisible(true);
						}
						
					case 3 :
						if (piece.getPopulation().get(0).getNum_position() == 1) {
							JFrame frame5 = new JFrame("Mon jeu");
					        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize5 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur5 = screenSize5.width;
					        int hauteur5 = screenSize5.height;
					        ImageIcon iconOriginal5 = new ImageIcon("Images/salle_a_manger_freddy.png");
					        Image imageRedim5 = iconOriginal5.getImage().getScaledInstance(largeur5, hauteur5, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal5 = new ImageIcon(imageRedim5);
					        JLabel label5 = new JLabel(iconOriginal5);
					        frame5.add(label5);
					        frame5.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame5.setVisible(true);
						} else {
							JFrame frame6= new JFrame("Mon jeu");
					        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					        Dimension screenSize6 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur6 = screenSize6.width;
					        int hauteur6 = screenSize6.height;
					        ImageIcon iconOriginal6 = new ImageIcon("Images/salle_a_manger_vide.png");
					        Image imageRedim6 = iconOriginal6.getImage().getScaledInstance(largeur6, hauteur6, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal6 = new ImageIcon(imageRedim6);
					        JLabel label6 = new JLabel(iconOriginal6);
					        frame6.add(label6);
					        frame6.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame6.setVisible(true);
						}
					}
				}
			case 2 :
				if (piece.getPopulation().get(0).getNum_position() == 2) {
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/crique_vide.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				}
			
			case 3 :
				if (piece.getPopulation().get(0).getNum_position() == 2) {
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/crique_foxy_1.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				}
				
			case 4 :
				if (piece.getPopulation().get(0).getNum_position() == 2) {
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/crique_foxy_2.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				}
				
			case 5 :
				if (piece.getPopulation().get(0).getNum_position() == 2) {
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/crique_foxy_parti.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
				}
				
			case 6 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 0 :
					if (piece.getPopulation().get(0).getNum_position() == 0) {
						JFrame frame = new JFrame("Mon jeu");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur = screenSize.width;
				        int hauteur = screenSize.height;
				        ImageIcon iconOriginal = new ImageIcon("Images/reserve_bonnie.png");
				        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal = new ImageIcon(imageRedim);
				        JLabel label = new JLabel(iconOriginal);
				        frame.add(label);
				        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame.setVisible(true);
				    }
				
				default :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon("Images/reserve_vide.png");
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
			    }
				
			case 7 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 1 :
					if (piece.getPopulation().get(0).getNum_position() == 1) {
						JFrame frame = new JFrame("Mon jeu");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur = screenSize.width;
				        int hauteur = screenSize.height;
				        ImageIcon iconOriginal = new ImageIcon("Images/toilettes_chica.png");
				        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal = new ImageIcon(imageRedim);
				        JLabel label = new JLabel(iconOriginal);
				        frame.add(label);
				        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame.setVisible(true);
					}
					
				case 3 :
					if (piece.getPopulation().get(0).getNum_position() == 3) {
						JFrame frame = new JFrame("Mon jeu");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur = screenSize.width;
				        int hauteur = screenSize.height;
				        ImageIcon iconOriginal = new ImageIcon("Images/freddy_toilettes.png");
				        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal = new ImageIcon(imageRedim);
				        JLabel label = new JLabel(iconOriginal);
				        frame.add(label);
				        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame.setVisible(true);
				}
					
				default :
					JFrame frame = new JFrame("Mon jeu");
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int largeur = screenSize.width;
				    int hauteur = screenSize.height;
				    ImageIcon iconOriginal = new ImageIcon("Images/toilettes_vides.png");
				    Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				    ImageIcon iconFinal = new ImageIcon(imageRedim);
				    JLabel label = new JLabel(iconOriginal);
				    frame.add(label);
				    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				    frame.setVisible(true);
				}
				
			case 8 :
				JFrame frame = new JFrame("Mon jeu");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int largeur = screenSize.width;
		        int hauteur = screenSize.height;
		        ImageIcon iconOriginal = new ImageIcon("Images/cuisine.png");
		        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
		        ImageIcon iconFinal = new ImageIcon(imageRedim);
		        JLabel label = new JLabel(iconOriginal);
		        frame.add(label);
		        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
		        frame.setVisible(true);
		        
			case 9 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 0 :
					if (piece.getPopulation().get(0).getNum_position() == 0) {
						JFrame frame1 = new JFrame("Mon jeu");
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur1 = screenSize1.width;
				        int hauteur1 = screenSize1.height;
				        ImageIcon iconOriginal1 = new ImageIcon("Images/placard_bonnie.png");
				        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
				        JLabel label1= new JLabel(iconOriginal1);
				        frame1.add(label1);
				        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame1.setVisible(true);
					}
					
				default :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon("Images/placard_vide.png");
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
				}
				
			case 10 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 0 :
					if (piece.getPopulation().get(0).getNum_position() == 0) {
						JFrame frame3 = new JFrame("Mon jeu");
				        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur3 = screenSize3.width;
				        int hauteur3 = screenSize3.height;
				        ImageIcon iconOriginal3 = new ImageIcon("Images/couloir_gauche_bonnie.png");
				        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
				        JLabel label3 = new JLabel(iconOriginal3);
				        frame3.add(label3);
				        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame3.setVisible(true);
					}
					
				default :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon("Images/couloir_gauche_vide.png");
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
				}
			case 11 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 0 :
					if (piece.getPopulation().get(0).getNum_position() == 0) {
						JFrame frame3 = new JFrame("Mon jeu");
				        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur3 = screenSize3.width;
				        int hauteur3 = screenSize3.height;
				        ImageIcon iconOriginal3 = new ImageIcon("Images/coin_couloir_gauche_bonnie.png");
				        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
				        JLabel label3 = new JLabel(iconOriginal3);
				        frame3.add(label3);
				        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame3.setVisible(true);
					}
					
				default :
					JFrame frame3 = new JFrame("Mon jeu");
					frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
					int largeur3 = screenSize3.width;
					int hauteur3 = screenSize3.height;
					ImageIcon iconOriginal3 = new ImageIcon("Images/coin_couloir_gauche_vide.png");
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
					ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
					JLabel label3 = new JLabel(iconOriginal3);
					frame3.add(label3);
					frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					frame3.setVisible(true);
				}
				
			case 12 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
				case 1 :
					if (piece.getPopulation().get(0).getNum_position() == 1) {
						JFrame frame1 = new JFrame("Mon jeu");
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur1 = screenSize1.width;
				        int hauteur1 = screenSize1.height;
				        ImageIcon iconOriginal1 = new ImageIcon("Images/chica_couloir_droit.png");
				        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
				        JLabel label1 = new JLabel(iconOriginal1);
				        frame1.add(label1);
				        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame1.setVisible(true);
					}
					
				case 3 :
					if (piece.getPopulation().get(0).getNum_position() == 3) {
						JFrame frame2 = new JFrame("Mon jeu");
				        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur2 = screenSize2.width;
				        int hauteur2 = screenSize2.height;
				        ImageIcon iconOriginal2 = new ImageIcon("Images/couloir_droit_freddy.png");
				        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
				        JLabel label2 = new JLabel(iconOriginal2);
				        frame2.add(label2);
				        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame2.setVisible(true);
				}
					
				default :
					JFrame frame1 = new JFrame("Mon jeu");
				    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
				    int largeur1 = screenSize1.width;
				    int hauteur1 = screenSize1.height;
				    ImageIcon iconOriginal1 = new ImageIcon("Images/couloir_droit_vide.png");
				    Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
				    ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
				    JLabel label1 = new JLabel(iconOriginal1);
				    frame1.add(label1);
				    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				    frame1.setVisible(true);
				}
				
			case 13 :
				switch (piece.getPopulation().get(0).getId_espece()) {
				
			    case 1 :
				    if (piece.getPopulation().get(0).getNum_position() == 1) {
					    JFrame frame2 = new JFrame("Mon jeu");
			            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
			            int largeur2 = screenSize2.width;
			            int hauteur2 = screenSize2.height;
			            ImageIcon iconOriginal2 = new ImageIcon("Images/coin_couloir_droit_chica.png");
			            Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
			            ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
			            JLabel label2 = new JLabel(iconOriginal2);
			            frame2.add(label);
			            frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			            frame2.setVisible(true);
				    }
				
			    case 3 :
				    if (piece.getPopulation().get(0).getNum_position() == 3) {
				    	JFrame frame3 = new JFrame("Mon jeu");
			            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			            int largeur3 = screenSize3.width;
			            int hauteur3 = screenSize3.height;
			            ImageIcon iconOriginal3 = new ImageIcon("Images/coin_couloir_droit_freddy.png");
			            Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			            ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			            JLabel label3 = new JLabel(iconOriginal3);
			            frame3.add(label3);
			            frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			            frame3.setVisible(true);
		    	}
				
			    default :
			    	JFrame frame1 = new JFrame("Mon jeu");
			        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur1 = screenSize1.width;
			        int hauteur1 = screenSize1.height;
			        ImageIcon iconOriginal1 = new ImageIcon("Images/coin_couloir_droit_vide.png");
			        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
			        JLabel label1 = new JLabel(iconOriginal1);
			        frame1.add(label1);
			        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame1.setVisible(true);
				}
				
			case 14 :
				if (lumiere.getOccupe() == true) {
					if(piece.getPopulation().get(0).getNum_position() == 0) {
						JFrame frame1 = new JFrame("Mon jeu");
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur1 = screenSize1.width;
				        int hauteur1 = screenSize1.height;
				        ImageIcon iconOriginal1 = new ImageIcon("Images/bonnie_porte.png");
				        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
				        JLabel label1 = new JLabel(iconOriginal1);
				        frame1.add(label1);
				        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame1.setVisible(true);
					} else {
				        JFrame frame1 = new JFrame("Mon jeu");
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur1 = screenSize1.width;
				        int hauteur1 = screenSize1.height;
				        ImageIcon iconOriginal1 = new ImageIcon("Images/bureau_lumiere_gauche.png");
				        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
				        JLabel label1 = new JLabel(iconOriginal1);
				        frame1.add(label1);
				        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame1.setVisible(true);
				    }
				}
				
			case 15 :
				if (lumiere.getOccupe() == true) {
					if(piece.getPopulation().get(0).getNum_position() == 1) {
						JFrame frame1 = new JFrame("Mon jeu");
					    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
						int largeur1 = screenSize1.width;
						int hauteur1 = screenSize1.height;
						ImageIcon iconOriginal1 = new ImageIcon("Images/chica_porte.png");
						Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
					    ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
						JLabel label1 = new JLabel(iconOriginal1);
						frame1.add(label1);
					    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						frame1.setVisible(true);
					} else {
						JFrame frame1 = new JFrame("Mon jeu");
					    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					    Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
					    int largeur1 = screenSize1.width;
					    int hauteur1 = screenSize1.height;
					    ImageIcon iconOriginal1 = new ImageIcon("Images/bureau_lumiere_droite.png");
					    Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
					    ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
					    JLabel label1 = new JLabel(iconOriginal1);
					    frame1.add(label1);
					    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					    frame1.setVisible(true);
					}
				}
				
			case 16 :
				JFrame frame1 = new JFrame("Mon jeu");
			    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
			    int largeur1 = screenSize1.width;
			    int hauteur1 = screenSize1.height;
			    ImageIcon iconOriginal1 = new ImageIcon("Images/bureau_vide.png");
			    Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
			    ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
			    JLabel label1 = new JLabel(iconOriginal1);
			    frame1.add(label1);
			    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			    frame1.setVisible(true);
			}
	    }
	}
}