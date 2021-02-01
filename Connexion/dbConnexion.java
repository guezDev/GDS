package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnexion {
	public static void main(String[] args) {
		 try {
		      Class.forName("org.postgresql.Driver");
		      System.out.println("Ok pour le Driver");

		      String url = "jdbc:postgresql://localhost:5432/projet";
		      String user = "postgres";
		      String passwd = "projet";

		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion établie !");    
		      //launch(args);
		         
		    } catch (Exception e) {
		      //e.printStackTrace();
		      System.out.println("Erreur de connexion à la base de données");
		      
		    }      
	}
}
