import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

//attributs de la classe
public class Caméra {
	boolean etat;
	int num_piece;
	Lumière lumiere_gauche;
	Lumière lumiere_droite;
	
//constructeur
public Caméra(Lumière lumiere_gauche, Lumière lumiere_droite) {
		this.etat = false;
		this.lumiere_gauche = lumiere_gauche;
		this.lumiere_droite = lumiere_droite;
	}

//change l'état des caméras de éteintes à allumées
void allumerCameras(Piece piece, int num_piece) {
    etat = true;
    this.num_piece = num_piece;
    this.afficherCamera(piece);
    try {
    	AudioInputStream audio = null;
    	try {
    	    audio = AudioSystem.getAudioInputStream(new File(get_adresse_son("Cameras O")));
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
        
        // Convertir en format compatible Java
        AudioFormat formatCible = new AudioFormat(
            AudioFormat.Encoding.PCM_SIGNED,
            44100,   // fréquence
            16,      // bits
            2,       // canaux (stereo)
            4,       // frame size
            44100,   // frame rate
            false    // little endian
        );
        
        AudioInputStream audioConverti = AudioSystem.getAudioInputStream(formatCible, audio);
        
        Clip clip = AudioSystem.getClip();
        clip.open(audioConverti);
        clip.start();
        Thread.sleep(clip.getMicrosecondLength() / 1000);

    } catch (IOException e) {
        e.printStackTrace();
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

//change l'état des caméras de allumées à éteintes
void fermerCameras() {
  etat = false;
  try {
	  AudioInputStream audio = null;
	  try {
		  audio = AudioSystem.getAudioInputStream(new File(get_adresse_son("Cameras F")));
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  	
      ImageIcon iconOriginal1 = new ImageIcon();
      try {
      	iconOriginal1 = new ImageIcon(get_adresse_image("Jumpscare C"));
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      // Convertir en format compatible Java
      AudioFormat formatCible = new AudioFormat(
          AudioFormat.Encoding.PCM_SIGNED,
          44100,   // fréquence
          16,      // bits
          2,       // canaux (stereo)
          4,       // frame size
          44100,   // frame rate
          false    // little endian
      );
      
      AudioInputStream audioConverti = AudioSystem.getAudioInputStream(formatCible, audio);
      
      Clip clip = AudioSystem.getClip();
      clip.open(audioConverti);
      clip.start();
      Thread.sleep(clip.getMicrosecondLength() / 1000);

  } catch (IOException e) {
      e.printStackTrace();
  } catch (LineUnavailableException e) {
      e.printStackTrace();
  } catch (InterruptedException e) {
      e.printStackTrace();
  }
}

//getters
public boolean getEtat() {
	return etat;
}
public int getNum_piece() {
	return num_piece;
}

//setters
public void setNum_piece(int num_piece) {
	this.num_piece = num_piece;
}

//méthode récupérant l'image dans la base de données
static String get_adresse_image(String nom_image) throws Exception {
    Class.forName("org.sqlite.JDBC");
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:BDD.db")) {
        String strSql = "SELECT adresse FROM Image WHERE nom = ?";
        try (PreparedStatement statement = connection.prepareStatement(strSql)) {
            statement.setString(1, nom_image);
            ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getString("adresse");
	        }
	    }
	}
	return "";
}

//méthode récupérant le son dans la base de données
static String get_adresse_son(String nom_son) throws Exception {
  Class.forName("org.sqlite.JDBC");
  try (Connection connection = DriverManager.getConnection("jdbc:sqlite:BDD.db")) {
      String strSql = "SELECT adresse FROM Son WHERE nom = ?";
      try (PreparedStatement statement = connection.prepareStatement(strSql)) {
          statement.setString(1, nom_son);
          ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getString("adresse");
	        }
	    }
	}
	return "";
}

	void afficherCamera(Piece piece) {
			switch (piece.getId_piece()) { //pour chaque pièce	
			case 0 :
				switch (piece.getPopulation().size()) { //pour chaque nombre d'animatroniques sur scène	
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon();
			        try {
			        	iconOriginal = new ImageIcon(this.get_adresse_image("Scene"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
			        break;
				case 1 :
					JFrame frame2 = new JFrame("Mon jeu");
			        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur2 = screenSize2.width;
			        int hauteur2 = screenSize2.height;
			        ImageIcon iconOriginal2 = new ImageIcon();
			        try {
			        	iconOriginal2 = new ImageIcon(this.get_adresse_image(""));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
			        JLabel label2 = new JLabel(iconOriginal2);
			        frame2.add(label2);
			        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame2.setVisible(true);
			        break;
				case 2 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon();
			        try {
			        	iconOriginal3 = new ImageIcon(get_adresse_image("Scene CFr"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
			        break;
				case 3 :
					JFrame frame4 = new JFrame("Mon jeu");
			        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize4 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur4 = screenSize4.width;
			        int hauteur4 = screenSize4.height;
			        ImageIcon iconOriginal4 = new ImageIcon();
			        try {
			        	iconOriginal4 = new ImageIcon(this.get_adresse_image("Scene BCF"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim4 = iconOriginal4.getImage().getScaledInstance(largeur4, hauteur4, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal4 = new ImageIcon(imageRedim4);
			        JLabel label4 = new JLabel(iconOriginal4);
			        frame4.add(label4);
			        frame4.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame4.setVisible(true);
			        break;
				}
				break;
			case 1 :
				switch (piece.getPopulation().size()) { //nombre d'animatronique dans la pièce
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon();
			        try {
			        	iconOriginal = new ImageIcon(get_adresse_image("Salle a manger"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
			        break;
				case 1 :
					switch (piece.getPopulation().get(0).getId_espece()) { //quel animatronique est dans la pièce
					case 0 :
						if (piece.getPopulation().get(0).getNum_position() == 1) {
							JFrame frame1 = new JFrame("Mon jeu");
					        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur1 = screenSize1.width;
					        int hauteur1 = screenSize1.height;
					        ImageIcon iconOriginal1 = new ImageIcon();
					        try {
					        	iconOriginal1 = new ImageIcon(get_adresse_image("Salle a manger B"));
					        } catch (Exception e) {
					            e.printStackTrace();
					        }
					        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
					        JLabel label1 = new JLabel(iconOriginal1);
					        frame1.add(label1);
					        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame1.setVisible(true);
						}
						break;
					case 1 :
						if (piece.getPopulation().get(0).getNum_position() == 1) {
							JFrame frame3 = new JFrame("Mon jeu");
					        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur3 = screenSize3.width;
					        int hauteur3 = screenSize3.height;
					        ImageIcon iconOriginal3 = new ImageIcon();
					        try {
					        	iconOriginal3 = new ImageIcon(get_adresse_image("Salle a manger C"));
					        } catch (Exception e) {
					            e.printStackTrace();
					        }
					        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
					        JLabel label3 = new JLabel(iconOriginal3);
					        frame3.add(label3);
					        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame3.setVisible(true);
						}
						break;
					case 3 :
						if (piece.getPopulation().get(3).getNum_position() == 1) {
							JFrame frame5 = new JFrame("Mon jeu");
					        frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					        Dimension screenSize5 = Toolkit.getDefaultToolkit().getScreenSize();
					        int largeur5 = screenSize5.width;
					        int hauteur5 = screenSize5.height;
					        ImageIcon iconOriginal5 = new ImageIcon();
					        try {
					        	iconOriginal5 = new ImageIcon(get_adresse_image("Salle a manger Fr"));
					        } catch (Exception e) {
					            e.printStackTrace();
					        }
					        Image imageRedim5 = iconOriginal5.getImage().getScaledInstance(largeur5, hauteur5, Image.SCALE_SMOOTH);
					        ImageIcon iconFinal5 = new ImageIcon(imageRedim5);
					        JLabel label5 = new JLabel(iconOriginal5);
					        frame5.add(label5);
					        frame5.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
					        frame5.setVisible(true);
						}
						break;
					}
					break;
				}
				break;
			case 2 :
				if (piece.getPopulation().size() > 0) {
				    if (piece.getPopulation().get(0).getNum_position() == 2) {
					    JFrame frame = new JFrame("Mon jeu");
			            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			            int largeur = screenSize.width;
			            int hauteur = screenSize.height;
			            ImageIcon iconOriginal = new ImageIcon();
				        try {
				        	iconOriginal = new ImageIcon(get_adresse_image("Crique"));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
			            Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			            ImageIcon iconFinal = new ImageIcon(imageRedim);
			            JLabel label = new JLabel(iconOriginal);
			        	frame.add(label);
			        	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        	frame.setVisible(true);
				    }
				}
				break;
			case 3 :
				if (piece.getPopulation().size() > 0){
					if (piece.getPopulation().get(0).getNum_position() == 3) {
						JFrame frame = new JFrame("Mon jeu");
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						int largeur = screenSize.width;
						int hauteur = screenSize.height;
						ImageIcon iconOriginal = new ImageIcon();
				        try {
				        	iconOriginal = new ImageIcon(get_adresse_image("Crique F 1"));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
						Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
						ImageIcon iconFinal = new ImageIcon(imageRedim);
						JLabel label = new JLabel(iconOriginal);
						frame.add(label);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						frame.setVisible(true);
					}
				}
				break;
			case 4 :
				if (piece.getPopulation().size() > 0){
					if (piece.getPopulation().get(0).getNum_position() == 4) {
						JFrame frame = new JFrame("Mon jeu");
				        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur = screenSize.width;
				        int hauteur = screenSize.height;
				        ImageIcon iconOriginal = new ImageIcon();
				        try {
				        	iconOriginal = new ImageIcon(get_adresse_image("Crique F 2"));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal = new ImageIcon(imageRedim);
				        JLabel label = new JLabel(iconOriginal);
				        frame.add(label);
				        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame.setVisible(true);
					}
				}
				break;
			case 5 :
				if (piece.getPopulation().size() > 0){
					if (piece.getPopulation().get(0).getNum_position() == 5) {
						JFrame frame = new JFrame("Mon jeu");
				        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				        int largeur = screenSize.width;
				        int hauteur = screenSize.height;
				        ImageIcon iconOriginal = new ImageIcon();
				        try {
				        	iconOriginal = new ImageIcon(get_adresse_image("Crique F P"));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				        ImageIcon iconFinal = new ImageIcon(imageRedim);
				        JLabel label = new JLabel(iconOriginal);
				        frame.add(label);
				        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				        frame.setVisible(true);
					}
				}
				break;
			case 6 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
			        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur = screenSize.width;
			        int hauteur = screenSize.height;
			        ImageIcon iconOriginal = new ImageIcon();
			        try {
			        	iconOriginal = new ImageIcon(get_adresse_image("Reserve"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal = new ImageIcon(imageRedim);
			        JLabel label = new JLabel(iconOriginal);
			        frame.add(label);
			        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 0 :
							if (piece.getPopulation().get(0).getNum_position() == 6) {
								JFrame frame1 = new JFrame("Mon jeu");
						        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur1 = screenSize1.width;
						        int hauteur1 = screenSize1.height;
						        ImageIcon iconOriginal1 = new ImageIcon();
						        try {
						        	iconOriginal = new ImageIcon(get_adresse_image("Reserve B"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
						        JLabel label1 = new JLabel(iconOriginal1);
						        frame1.add(label1);
						        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame1.setVisible(true);
							}
						break;
						}
				    }
				}
				break;
			case 7 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame = new JFrame("Mon jeu");
				    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    int largeur = screenSize.width;
				    int hauteur = screenSize.height;
				    ImageIcon iconOriginal = new ImageIcon();
			        try {
			        	iconOriginal = new ImageIcon(get_adresse_image("Toilettes"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				    Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
				    ImageIcon iconFinal = new ImageIcon(imageRedim);
				    JLabel label = new JLabel(iconFinal);
				    frame.add(label);
				    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
				    frame.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {switch (piece.getPopulation().get(0).getId_espece()) {
						
						case 1 :
							if (piece.getPopulation().get(0).getNum_position() == 7) {
								JFrame frame1 = new JFrame("Mon jeu");
						        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur1 = screenSize1.width;
						        int hauteur1 = screenSize1.height;
						        ImageIcon iconOriginal1 = new ImageIcon();
						        try {
						        	iconOriginal1 = new ImageIcon(get_adresse_image("Toilettes C"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
						        JLabel label1 = new JLabel(iconFinal1);
						        frame1.add(label1);
						        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame1.setVisible(true);
							}
							break;
						case 3 :
							if (piece.getPopulation().get(0).getNum_position() == 7) {
								JFrame frame2 = new JFrame("Mon jeu");
						        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur2 = screenSize2.width;
						        int hauteur2 = screenSize2.height;
						        ImageIcon iconOriginal2 = new ImageIcon();
						        try {
						        	iconOriginal2 = new ImageIcon(get_adresse_image("Toilettes Fr"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
						        JLabel label2 = new JLabel(iconFinal2);
						        frame2.add(label2);
						        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame2.setVisible(true);
							}
						    break;
							
					default :
					    break;
					}
				}
				break;
				
				
				}
				break;			
			case 8 :
				JFrame frame = new JFrame("Mon jeu");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int largeur = screenSize.width;
		        int hauteur = screenSize.height;
		        ImageIcon iconOriginal = new ImageIcon();
		        try {
		        	iconOriginal = new ImageIcon(get_adresse_image("Cuisine"));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        Image imageRedim = iconOriginal.getImage().getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
		        ImageIcon iconFinal = new ImageIcon(imageRedim);
		        JLabel label = new JLabel(iconOriginal);
		        frame.add(label);
		        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
		        frame.setVisible(true);
		        break;
			case 9 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame1 = new JFrame("Mon jeu");
			        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur1 = screenSize1.width;
			        int hauteur1 = screenSize1.height;
			        ImageIcon iconOriginal1 = new ImageIcon();
			        try {
			        	iconOriginal1 = new ImageIcon(get_adresse_image("Placard"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
			        JLabel label1 = new JLabel(iconOriginal1);
			        frame1.add(label1);
			        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame1.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 0 :
							if (piece.getPopulation().get(0).getNum_position() == 6) {
								JFrame frame2 = new JFrame("Mon jeu");
						        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur2 = screenSize2.width;
						        int hauteur2 = screenSize2.height;
						        ImageIcon iconOriginal2 = new ImageIcon();
						        try {
						        	iconOriginal2 = new ImageIcon(get_adresse_image("Placard B"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
						        JLabel label2 = new JLabel(iconOriginal2);
						        frame2.add(label2);
						        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame2.setVisible(true);
							}
						break;
						}
				    }
				}
				break;
			case 10 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon();
			        try {
			        	iconOriginal3 = new ImageIcon(get_adresse_image("Couloir G"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 0 :
							if (piece.getPopulation().get(0).getNum_position() == 6) {
								JFrame frame1 = new JFrame("Mon jeu");
						        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur1 = screenSize1.width;
						        int hauteur1 = screenSize1.height;
						        ImageIcon iconOriginal1 = new ImageIcon();
						        try {
						        	iconOriginal = new ImageIcon(get_adresse_image("Couloir G B"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
						        JLabel label1 = new JLabel(iconOriginal1);
						        frame1.add(label1);
						        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame1.setVisible(true);
							}
						break;
						}
				    }
				}
				break;
			case 11 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon();
			        try {
			        	iconOriginal3 = new ImageIcon(get_adresse_image("Coin couloir G"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 0 :
							if (piece.getPopulation().get(0).getNum_position() == 6) {
								JFrame frame1 = new JFrame("Mon jeu");
						        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
						        int largeur1 = screenSize1.width;
						        int hauteur1 = screenSize1.height;
						        ImageIcon iconOriginal1 = new ImageIcon();
						        try {
						        	iconOriginal = new ImageIcon(get_adresse_image("Coin couloir G B"));
						        } catch (Exception e) {
						            e.printStackTrace();
						        }
						        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
						        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
						        JLabel label1 = new JLabel(iconOriginal1);
						        frame1.add(label1);
						        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
						        frame1.setVisible(true);
							}
						break;
						}
				    }
				}
				break;
			case 12 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon();
			        try {
			        	iconOriginal3 = new ImageIcon(get_adresse_image("Couloir D"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 1 :
							if (piece.getPopulation().size() > 1) {
								if (piece.getPopulation().get(1).getNum_position() == 12) {
									JFrame frame1 = new JFrame("Mon jeu");
							        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
							        int largeur1 = screenSize1.width;
							        int hauteur1 = screenSize1.height;
							        ImageIcon iconOriginal1 = new ImageIcon();
							        try {
							        	iconOriginal1 = new ImageIcon(get_adresse_image("Couloir D C"));
							        } catch (Exception e) {
							            e.printStackTrace();
							        }
							        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
							        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
							        JLabel label1 = new JLabel(iconOriginal1);
							        frame1.add(label1);
							        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
							        frame1.setVisible(true);
								}
							}
							break;
							
						case 3 :
							if (piece.getPopulation().size() > 3) {
								if (piece.getPopulation().get(3).getNum_position() == 12) {
									JFrame frame2 = new JFrame("Mon jeu");
							        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
							        int largeur2 = screenSize2.width;
							        int hauteur2 = screenSize2.height;
							        ImageIcon iconOriginal2 = new ImageIcon();
							        try {
							        	iconOriginal2 = new ImageIcon(get_adresse_image("Couloir D Fr"));
							        } catch (Exception e) {
							            e.printStackTrace();
							        }
							        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
							        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
							        JLabel label2 = new JLabel(iconOriginal2);
							        frame2.add(label2);
							        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
							        frame2.setVisible(true);
								}
							}
							break;
						}
				    }
				}
				break;
			case 13 :
				switch (piece.getPopulation().size()) {
				case 0 :
					JFrame frame3 = new JFrame("Mon jeu");
			        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        Dimension screenSize3 = Toolkit.getDefaultToolkit().getScreenSize();
			        int largeur3 = screenSize3.width;
			        int hauteur3 = screenSize3.height;
			        ImageIcon iconOriginal3 = new ImageIcon();
			        try {
			        	iconOriginal3 = new ImageIcon(get_adresse_image("Coin couloir D"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        Image imageRedim3 = iconOriginal3.getImage().getScaledInstance(largeur3, hauteur3, Image.SCALE_SMOOTH);
			        ImageIcon iconFinal3 = new ImageIcon(imageRedim3);
			        JLabel label3 = new JLabel(iconOriginal3);
			        frame3.add(label3);
			        frame3.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
			        frame3.setVisible(true);
			        break;
				case 1:
					if (piece.getPopulation().size() > 0) {
						switch (piece.getPopulation().get(0).getId_espece()) {
						case 1 :
							if (piece.getPopulation().size() > 1) {
								if (piece.getPopulation().get(1).getNum_position() == 12) {
									JFrame frame1 = new JFrame("Mon jeu");
							        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
							        int largeur1 = screenSize1.width;
							        int hauteur1 = screenSize1.height;
							        ImageIcon iconOriginal1 = new ImageIcon();
							        try {
							        	iconOriginal1 = new ImageIcon(get_adresse_image("Coin couloir D C"));
							        } catch (Exception e) {
							            e.printStackTrace();
							        }
							        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
							        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
							        JLabel label1 = new JLabel(iconOriginal1);
							        frame1.add(label1);
							        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
							        frame1.setVisible(true);
								}
							}
							break;
							
						case 3 :
							if (piece.getPopulation().size() > 3) {
								if (piece.getPopulation().get(3).getNum_position() == 12) {
									JFrame frame2 = new JFrame("Mon jeu");
							        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							        Dimension screenSize2 = Toolkit.getDefaultToolkit().getScreenSize();
							        int largeur2 = screenSize2.width;
							        int hauteur2 = screenSize2.height;
							        ImageIcon iconOriginal2 = new ImageIcon();
							        try {
							        	iconOriginal2 = new ImageIcon(get_adresse_image("Coin couloir D Fr"));
							        } catch (Exception e) {
							            e.printStackTrace();
							        }
							        Image imageRedim2 = iconOriginal2.getImage().getScaledInstance(largeur2, hauteur2, Image.SCALE_SMOOTH);
							        ImageIcon iconFinal2 = new ImageIcon(imageRedim2);
							        JLabel label2 = new JLabel(iconOriginal2);
							        frame2.add(label2);
							        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
							        frame2.setVisible(true);
								}
							}
							break;
						}
				    }
				}
				break;
			}
	    
	}
}
