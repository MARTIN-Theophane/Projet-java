import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Lumière {
	
//définition des attributs
	private int num_lumiere;
	private boolean etat;
	ArrayList<Animatronique> animatroniques;
	
	
//constructeur
	public Lumière(int num_lumiere, boolean etat) {
		this.num_lumiere = num_lumiere;
		this.etat = etat;
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
	
// méthode permettant d'allumer la lumière et qui joue le son associé
	void allumerLumiere() {
		etat = !etat;
		try {
			AudioInputStream audio = null;
			try {
				audio = AudioSystem.getAudioInputStream(new File(get_adresse_son("Lumiere A")));
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
	
//méthode permettant d'éteindre la lumière 
	void eteindreLumiere(){
		etat = !etat;
	}
	
	
	public boolean getEtat(){
		return etat;
	}

//méthode déterminant si un animatronique est à la porte
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
	
//getters
	public int getNum_lumiere() {
		return num_lumiere;
	}
	
	public ArrayList<Animatronique> getAnimatroniques() {
		return animatroniques;
	}
	
	public boolean getOccupe() {
		return etat;
	}
	
//setters
	public void setNum_lumiere(int num_lumiere) {
		this.num_lumiere = num_lumiere;
	}
	public void setOccupe(boolean etat) {
		this.etat = etat;
	}

	public void setAnimatroniques(ArrayList<Animatronique> animatroniques) {
		this.animatroniques = animatroniques;
	}	
}