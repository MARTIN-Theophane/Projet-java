import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;


public class Main {

	static void setPopulation(ArrayList<Animatronique> animatroniques, ArrayList<Piece> pieces) {
	// Initialisation des populations des pièces de la liste "pieces"
		
		for (int i=0;i<animatroniques.size();i++) {
			for (int j=0;j<pieces.size();j++) {
			// Parcours les pieces pour chaque animatronique
				if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
				// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
					pieces.get(j).ajouterAnim(animatroniques.get(i));
					// Ajoute l'animatronique à la pop de la pièce
					//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
					animatroniques.get(i).setMove(false);
					// Change l'état de mouvement de l'animatronique
				}
			}
		}
	}
	
	static void newPopulation(ArrayList<Animatronique> animatroniques, ArrayList<Piece> pieces, int[][] chemin) {
	// Initialisation des populations des pièces de la liste "pieces"
		
		for (int i=0;i<animatroniques.size();i++) {
			for (int j=0;j<pieces.size();j++) {
			// Parcours les pieces pour chaque animatronique
				if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
				// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
					pieces.get(j).ajouterAnim(animatroniques.get(i));
					// Ajoute l'animatronique à la pop de la pièce
					if (animatroniques.get(i).getTour()>0) {
					// Après l'initialisation :
						pieces.get(chemin[animatroniques.get(i).getId_espece()][(animatroniques.get(i).getTour())-1]).supprimerAnim(animatroniques.get(i));
					// Supprime l'animatronique de sa précédente pièce
					} else {
						pieces.get(chemin[animatroniques.get(i).getId_espece()][(chemin[animatroniques.get(i).getId_espece()].length)-1]).supprimerAnim(animatroniques.get(i));
					// Supprime l'animatronique de la dernière piece
					}
					//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
					animatroniques.get(i).setMove(false);
					// Change l'état de mouvement de l'animatronique
				}
			}
		}
	}
	
	static void setTime(ArrayList<Animatronique> animatroniques) {
	    // initialise le chrono des animatroniques s'il est à 0 (à 0 au départ)
	        do {
	            for (int i=0;i<animatroniques.size();i++) {
	                if (animatroniques.get(i).getTime()==0) {
	                    animatroniques.get(i).setChrono();
	                }
	                
	            }
	            if (animatroniques.get(0).getTime()>animatroniques.get(1).getTime() || animatroniques.get(1).getTime()>animatroniques.get(3).getTime()) {
	                break;
	            } else {
	                for (int i=0;i<animatroniques.size();i++) {
	                    animatroniques.get(i).setTime(0);
	                }
	            }
	        } while (true);
	}
	
	
	static void chrono(ArrayList<Animatronique> animatroniques) {
	// Gestion des chronos des animatroniques
		boolean a=true;

		do {
			// Initialise un Thread qui attend 1s
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("thread interrompu.");
				}
			});
			
			
			// Retire 1 au chrono des animatroniques toutes les secondes
			if (a) {
				for (int i=0;i<animatroniques.size();i++) {
					a=animatroniques.get(i).decompte();
					if (!a) {
						break;
					}
				}
			}
			
			
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println("thread interrompu.");
			}
			
			
			
		} while (a); 
		// Tant que le chrono d'un des animatroniques n'est pas arrivé à 0
	}
	
	static void move(ArrayList<Animatronique> animatroniques, ArrayList<Piece> pieces, int[][] chemin) {
	    // Change les animatroniques de numéro de position
	        for (int i=0;i<animatroniques.size();i++) {
	            if (animatroniques.get(i).getTime()==0) {
	                animatroniques.get(i).setMove(true);
	            }
	        }
	        for (int i=0;i<animatroniques.size();i++) {
	            
	            if (  (animatroniques.get(i).getTour())+1  <  chemin[animatroniques.get(i).getId_espece()].length  ) {
	                if ((animatroniques.get(i).getMove())   &&   
	                        (pieces.get(chemin[animatroniques.get(i).getId_espece()][(animatroniques.get(i).getTour())+1]).getPopulation().size()  !=  
	                        pieces.get(chemin[animatroniques.get(i).getId_espece()][(animatroniques.get(i).getTour())+1]).getPlace_max())) {
	                // Si (l'animatronique doit bouger) && (la pièce suivante n'est pas pleine)
	                	animatroniques.get(i).setNum_position(chemin[animatroniques.get(i).getId_espece()][(animatroniques.get(i).getTour())+1]);
	                    // Change la position de lanimatronique pour la pièce suivante
	                } else {
	                    animatroniques.get(i).setMove(false);
	                    // Change l'état de mouvement de l'animatronique
	                }
	            } else {
	                if ((animatroniques.get(i).getMove())   &&   
	                        (pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPopulation().size()  !=  
	                        pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPlace_max())) {
	                // Si (l'animatronique doit bouger) && (la pièce suivante n'est pas pleine)
	                    animatroniques.get(i).setNum_position(chemin[animatroniques.get(i).getId_espece()][0]);
	                    // Change la position de lanimatronique pour la pièce suivante
	                } else {
	                    animatroniques.get(i).setMove(false);
	                    // empêche l'animatronique de bouger
	                }
	            }
	        }
	    }
	
static void redemarrer_pos_anim(ArrayList<Animatronique> animatroniques, ArrayList<Piece> pieces,Joueur[] joueur, int[][] chemin) {
		
		
		if (pieces.get(14).getPopulation().size() != 0 && joueur[0].getPorte_gauche().getEtat()) {
			System.out.println("a");
			
			pieces.get(14).getPopulation().get(0).setNum_position(0);
			pieces.get(14).getPopulation().get(0).setMove(true);
			pieces.get(14).getPopulation().get(0).setTour((int) 0);
			
			for (int i=0;i<animatroniques.size();i++) {
				if ((animatroniques.get(i).getMove())   &&   
                    (pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPopulation().size()  !=  
                    pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPlace_max())) {
					
					for (int j=0;j<pieces.size();j++) {
					// Parcours les pieces pour chaque animatronique
						if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
						// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
							pieces.get(j).ajouterAnim(animatroniques.get(i));
							// Ajoute l'animatronique à la pop de la pièce
							pieces.get(14).supprimerAnim(animatroniques.get(i));
							// Supprime l'animatronique de la dernière piece
							//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
							animatroniques.get(i).setMove(false);
							// Change l'état de mouvement de l'animatronique
						}
					}
				setTime(animatroniques);
				} else {
					setTime(animatroniques);
				}
			}
		
			
			
		} else if (pieces.get(15).getPopulation().size() != 0 && joueur[0].getPorte_droite().getEtat()) {
			System.out.println("b");
			
			pieces.get(15).getPopulation().get(0).setNum_position(0);
			pieces.get(15).getPopulation().get(0).setMove(true);
			pieces.get(15).getPopulation().get(0).setTour((int) 0);
			
			for (int i=0;i<animatroniques.size();i++) {
				if ((animatroniques.get(i).getMove())   &&   
                    (pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPopulation().size()  !=  
                    pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPlace_max())) {
					
					for (int j=0;j<pieces.size();j++) {
						// Parcours les pieces pour chaque animatronique
						if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
						// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
							pieces.get(j).ajouterAnim(animatroniques.get(i));
							// Ajoute l'animatronique à la pop de la pièce
							pieces.get(15).supprimerAnim(animatroniques.get(i));
							// Supprime l'animatronique de la dernière piece
							//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
							animatroniques.get(i).setMove(false);
							// Change l'état de mouvement de l'animatronique
						}
					}
				setTime(animatroniques);
				} else {
					setTime(animatroniques);
				} 
			}
		
		} else if ((pieces.get(10).getPopulation().size() != 0 && joueur[0].getPorte_droite().getEtat()) 
				&& (pieces.get(10).getPopulation().get(0).getId_espece() == (int) 2)) {
			System.out.println("c");
			
			pieces.get(10).getPopulation().get(0).setNum_position(0);
			pieces.get(10).getPopulation().get(0).setMove(true);
			pieces.get(10).getPopulation().get(0).setTour((int) 0);
			
			for (int i=0;i<animatroniques.size();i++) {
				if ((animatroniques.get(i).getMove())   &&   
                    (pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPopulation().size()  !=  
                    pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPlace_max())) {
					
					for (int j=0;j<pieces.size();j++) {
						// Parcours les pieces pour chaque animatronique
						if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
						// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
							pieces.get(j).ajouterAnim(animatroniques.get(i));
							// Ajoute l'animatronique à la pop de la pièce
							pieces.get(10).supprimerAnim(animatroniques.get(i));
							// Supprime l'animatronique de la dernière piece
							//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
							animatroniques.get(i).setMove(false);
							// Change l'état de mouvement de l'animatronique
						}
					}
				setTime(animatroniques);
				} else {
					setTime(animatroniques);
				} 
			}
		
		} else if ((pieces.get(13).getPopulation().size() != 0 && joueur[0].getPorte_droite().getEtat()) 
				&& (pieces.get(13).getPopulation().get(0).getId_espece() == (int) 3)) {
			System.out.println("d");
			
			pieces.get(13).getPopulation().get(0).setNum_position(0);
			pieces.get(13).getPopulation().get(0).setMove(true);
			pieces.get(13).getPopulation().get(0).setTour((int) 0);
			
			for (int i=0;i<animatroniques.size();i++) {
				if ((animatroniques.get(i).getMove())   &&   
                    (pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPopulation().size()  !=  
                    pieces.get(chemin[animatroniques.get(i).getId_espece()][0]).getPlace_max())) {
					
					for (int j=0;j<pieces.size();j++) {
						// Parcours les pieces pour chaque animatronique
						if ((animatroniques.get(i).getMove()) && (animatroniques.get(i).getNum_position()==pieces.get(j).getId_piece())) {
						// Si (animatronique doit bouger (initialisé à "true")) && (numéro de position animatronique == id de la pièce)
							pieces.get(j).ajouterAnim(animatroniques.get(i));
							// Ajoute l'animatronique à la pop de la pièce
							pieces.get(13).supprimerAnim(animatroniques.get(i));
							// Supprime l'animatronique de la dernière piece
							//System.out.println("l'animatronique "+i+" a été ajouter à la piece "+j+".");
							animatroniques.get(i).setMove(false);
							// Change l'état de mouvement de l'animatronique
						}
					}
				setTime(animatroniques);
				} else {
					setTime(animatroniques);
				} 
			}
		}	
	}

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

	static void Jumpscare(Animatronique animatronique,Piece piece) {
		if (piece.getPopulation().get(0).getNum_position() == 16) {
			JFrame frame1 = new JFrame("Mon jeu");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
	        int largeur1 = screenSize1.width;
	        int hauteur1 = screenSize1.height;
	        ImageIcon iconOriginal1 = new ImageIcon("Images/bonnie_jumpscare.png");
	        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
	        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
	        JLabel label1 = new JLabel(iconOriginal1);
	        frame1.add(label1);
	        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
	        frame1.setVisible(true);
	        
	        try {
	            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sons/son_jumpscare.mp4"));
	            
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

	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		} else if (piece.getPopulation().get(1).getNum_position() == 16) {
			JFrame frame1 = new JFrame("Mon jeu");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
	        int largeur1 = screenSize1.width;
	        int hauteur1 = screenSize1.height;
	        ImageIcon iconOriginal1 = new ImageIcon("Images/chica_jumpscare.png");
	        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
	        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
	        JLabel label1 = new JLabel(iconOriginal1);
	        frame1.add(label1);
	        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
	        frame1.setVisible(true);
	        
	        try {
	            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sons/son_jumpscare.mp4"));
	            
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

	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		} else if (piece.getPopulation().get(2).getNum_position() == 16) {
			JFrame frame1 = new JFrame("Mon jeu");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
	        int largeur1 = screenSize1.width;
	        int hauteur1 = screenSize1.height;
	        ImageIcon iconOriginal1 = new ImageIcon("Images/foxy_jumpscare.png");
	        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
	        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
	        JLabel label1 = new JLabel(iconOriginal1);
	        frame1.add(label1);
	        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
	        frame1.setVisible(true);
	        
	        try {
	            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sons/son_jumpscare.mp4"));
	            
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

	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		} else if (piece.getPopulation().get(3).getNum_position() == 16) {
			JFrame frame1 = new JFrame("Mon jeu");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
	        int largeur1 = screenSize1.width;
	        int hauteur1 = screenSize1.height;
	        ImageIcon iconOriginal1 = new ImageIcon("Images/freddy_jumpscare.png");
	        Image imageRedim1 = iconOriginal1.getImage().getScaledInstance(largeur1, hauteur1, Image.SCALE_SMOOTH);
	        ImageIcon iconFinal1 = new ImageIcon(imageRedim1);
	        JLabel label1 = new JLabel(iconOriginal1);
	        frame1.add(label1);
	        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximise la fenêtre
	        frame1.setVisible(true);
	        
	        try {
	            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sons/son_jumpscare.mp4"));
	            
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

	        } catch (UnsupportedAudioFileException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (LineUnavailableException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	static void porteGauche(Lumière lumiere, Piece piece) {
		if (lumiere.getOccupe() == true) {
			if(piece.getPopulation().get(0).getNum_position() == 15) {
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
		        
		        try {
		            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("son_animatronique_porte.mp4"));
		            
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

		        } catch (UnsupportedAudioFileException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
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
		        
		        try {
		            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("son_animatronique_porte.mp4"));
		            
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

		        } catch (UnsupportedAudioFileException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	static void porteDroite(Lumière lumiere, Piece piece) {
		if (lumiere.getOccupe() == true) {
			if(piece.getPopulation().get(1).getNum_position() == 15) {
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
				
				try {
		            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("son_animatronique_porte.mp4"));
		            
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

		        } catch (UnsupportedAudioFileException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
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
			    
			    try {
		            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("son_animatronique_porte.mp4"));
		            
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

		        } catch (UnsupportedAudioFileException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	}
	
	static void porteVide(Lumière lumiere) {
        if (lumiere.getOccupe() == false) {
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
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*----------- INITIALISATION LISTE PIECE ----------------*/
// Piece(id piece, population max)
		
		ArrayList<Piece> pieces = new ArrayList<>();
		Piece scene = new Piece((int) 0, (int) 3);
		Piece s_a_manger = new Piece((int) 1, (int) 1);
		Piece c_d_pirates_1 = new Piece((int) 2, (int) 1);
		Piece c_d_pirates_2 = new Piece((int) 3, (int) 1);
		Piece c_d_pirates_3 = new Piece((int) 4, (int) 1);
		Piece c_d_pirates_4 = new Piece((int) 5, (int) 1);
		Piece p_entretien = new Piece((int) 6, (int) 1);
		Piece toilette = new Piece((int) 7, (int) 1);
		Piece cuisine = new Piece((int) 8, (int) 1);
		Piece placard = new Piece((int) 9, (int) 1);
		Piece c_gauche = new Piece((int) 10, (int) 1);
		Piece c_c_gauche = new Piece((int) 11, (int) 1);
		Piece c_droit = new Piece((int) 12, (int) 1);
		Piece c_c_droit = new Piece((int) 13, (int) 1);
		Piece p_gauche = new Piece((int) 14, (int) 1);
		Piece p_droit = new Piece((int) 15, (int) 1);
		Piece bureau = new Piece((int) 16, (int) 1);
		
		pieces.add(scene);
		pieces.add(s_a_manger);
		pieces.add(c_d_pirates_1);
		pieces.add(c_d_pirates_2);
		pieces.add(c_d_pirates_3);
		pieces.add(c_d_pirates_4);
		pieces.add(p_entretien);
		pieces.add(toilette);
		pieces.add(cuisine);
		pieces.add(placard);
		pieces.add(c_gauche);
		pieces.add(c_c_gauche);
		pieces.add(c_droit);
		pieces.add(c_c_droit);
		pieces.add(p_gauche);
		pieces.add(p_droit);
		pieces.add(bureau);
		
/*------------------- INITIALISATION CHEMIN ANIMATRONIQUE ------------------------
	Cette liste permet de définir le chemin de pièce en pièce des animatronique selon cette logique :
	
	chemin[NUMERO DE L'ANIMATRONIQUE][NUMERO DE LA PIECE]												*/
	
		int[][] chemin = {{0,1,6,10,9,11,14,16},{0,1,7,8,12,13,15,16},{2,3,4,5,10,16},{0,1,7,8,12,13,16}};
		
/*------------------- INITIALISATION LISTE ANIMATRONIQUE ------------------------*/
// Animatronique(id espece, position animatronique)
		
		ArrayList<Animatronique> animatroniques = new ArrayList<>();
		Animatronique bonnie = new Animatronique((int) 0, chemin[0][0]);
		Animatronique chica = new Animatronique((int) 1, chemin[1][0]);
		Animatronique foxy = new Animatronique((int) 2, chemin[2][0]);
		Animatronique freddy = new Animatronique((int) 3, chemin[3][0]);
		animatroniques.add(bonnie);
		animatroniques.add(chica);
		animatroniques.add(foxy);
		animatroniques.add(freddy);
		
		
		
		//Création des lumieres et de leurs boutons
		Lumière lumiere_gauche = new Lumière(1,false);
		Lumière lumiere_droite = new Lumière(2,false);

/*---------------------------------------------------------------------------------------------------------------*/	
		Joueur[] joueur = new Joueur[1]; // tableau pour accès depuis lambda

		SwingUtilities.invokeLater(() -> {
		    joueur[0] = new Joueur(pieces,lumiere_gauche,lumiere_droite);
		});
		
		setPopulation(animatroniques, pieces);
		// Initialise la population des pièces précédement créées
		// (pour une description détaillée, voir ln 6)
		
		Thread t1 = new Thread(() -> {
			while (true) {
				setTime(animatroniques); // Initialisation du chrono des animatroniques (voir ln 29)
				chrono(animatroniques);	 // Gestion des chronos des animatroniques (voir ln 39)
				move(animatroniques, pieces, chemin); // Change les animatroniques de numéro de position (voir ln 78)
				newPopulation(animatroniques, pieces, chemin); // Initialise la nouvelle population des pièces ****A TESTER !!!!!!****
			}
		});
		
		Thread t2 = new Thread(() -> {
		    while (true) {
		    	//redemarrer_pos_anim(animatroniques,pieces,joueur,chemin);
		    	Jumpscare(animatroniques.get(0),pieces.get(16));
		    	Jumpscare(animatroniques.get(1),pieces.get(16));
		    	Jumpscare(animatroniques.get(2),pieces.get(16));
		    	Jumpscare(animatroniques.get(3),pieces.get(16));
		    	porteGauche(lumiere_gauche,pieces.get(16));
		    	porteDroite(lumiere_droite,pieces.get(16));
		    	porteVide(lumiere_droite);
		    	porteVide(lumiere_gauche);
		    }
		});

		t1.start();
		t2.start();
	}
	
}

// Num des pièces :
// Scène = 0
// Salle à manger = 1
// Crique des pirates (rideau fermés) = 2
// Crique des pirates (rideau légèrement ouvert) = 3
// Crique des pirates (rideau ouvert) = 4
// Crique des pirates (rideau ouvert (sans Foxy)) = 5
// pièce d'entretien = 6
// Toilette = 7
// cuisine = 8
// placard = 9
// couloir gauche = 10
// coin du couloir gauche = 11
// couloir droit = 12
// coin du couloir droit = 13
// porte gauche = 14
// porte droite = 15
// Bureau = 16

// Num des Animatroniques :
// Bonnie = 0
// Chica = 1
// Foxy = 2
// Freddy = 3