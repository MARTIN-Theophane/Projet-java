import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Porte {
	
//définition des attributs
	private int num_porte;
	private boolean etat;
	
//constructeur
	public Porte(int num_porte, boolean etat) {
		this.num_porte = num_porte;
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
	
//méthode permettant d'ouvrir les portes avec le bon son
	void ouvrirPorte() {
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
	
//méthode permettant de fermer les portes avec le bon son
	void fermerPorte() {
		etat = !etat;
		try {
	        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Sons/fermeture_porte.wav"));
	        
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
	

//getters
	public int getNum_porte() {
		return num_porte;
	}
	public boolean getEtat() {
		return etat;
	}
}
