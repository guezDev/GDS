package application;
	
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Authentification.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			Class.forName("org.postgresql.Driver");
		    System.out.println("Ok pour le Driver");

		    String url = "jdbc:postgresql://localhost:5432/projet";
		    String user = "postgres";
		    String passwd = "projet";
		    
		    Connection conn = DriverManager.getConnection(url, user, passwd);
		    System.out.println("Connexion établie !");
		} catch(Exception e) {
		    System.out.println("Erreur de connexion à la base de données, Redémarrer l'application");
			primaryStage.close();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
