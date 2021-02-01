package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainController {
	@FXML private TextField txtId;
	@FXML private PasswordField passId;
	@FXML private Label message;
	
	@FXML 
	public void login(ActionEvent e)
	{
		try {
		      Class.forName("org.postgresql.Driver");

		      String url = "jdbc:postgresql://localhost:5432/projet";
		      String user = "postgres";
		      String passwd = "projet";

		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		      
		      String id=txtId.getText();
		      String mdp=passId.getText();
		      
		      String query="SELECT * FROM connexion";
		      query +=" WHERE id_connexion = ?";
		      query += " AND mdp = ?";
		      
		      PreparedStatement prepare=conn.prepareStatement(query);
		      prepare.setString(1, id);
		      prepare.setString(2, mdp);
		      
		      ResultSet result=state.executeQuery(prepare.toString());
		      if(!result.next())
		      {
		    	  message.setTextFill(Color.RED);
		    	  message.setText("Mauvais identifiant ou mot de passe");
		      }
		      else
		      {
		    	  if (result.getObject(6).toString().equals("responsable"))
		    	  {
		    		  FXMLLoader loader=new FXMLLoader();
		    		  loader.setLocation(getClass().getResource("/view/AccueilResponsable.fxml"));
		    		  Parent root =loader.load();
		    		  
			    	  Scene scene = new Scene(root);
			    	  Stage fen=new Stage();
			    	  fen.setScene(scene);
			    	  fen.show();
			    	  
			    	  Stage stage;
			    	  stage=(Stage) message.getScene().getWindow();
			    	  stage.close();
			    	  
			    	  this.txtId.setText(result.getObject(4).toString());
			    	  this.passId.setText(result.getObject(5).toString());
			    	  this.message.setText(result.getObject(6).toString());
			    	  ResponsableController respC=loader.getController();
			    	  respC.infos(txtId.getText(),passId.getText(),message.getText());
		    	  }
		    	  else
		    	  {
		    		  FXMLLoader loader=new FXMLLoader();
		    		  loader.setLocation(getClass().getResource("/view/AccueilProfesseur.fxml"));
		    		  Parent root =loader.load();
		    		  
			    	  Scene scene = new Scene(root);
			    	  Stage fen=new Stage();
			    	  fen.setScene(scene);
			    	  fen.show();
			    	  
			    	  Stage stage;
			    	  stage=(Stage) message.getScene().getWindow();
			    	  stage.close();
			    	  
			    	  this.txtId.setText(result.getObject(4).toString());
			    	  this.passId.setText(result.getObject(5).toString());
			    	  this.message.setText(result.getObject(6).toString());
			    	  ProfesseurController profC=loader.getController();
			    	  profC.infos(txtId.getText(),passId.getText(),message.getText());
		    	  }
		      }
		 
		      prepare.close();
		      result.close();
		      state.close();
		    } catch (Exception exp) {
		      //e.printStackTrace();
		      System.out.println("Erreur de connexion à la base de données, Redémarrer l'application");
		      Stage stage;
	    	  stage=(Stage) message.getScene().getWindow();
	    	  stage.close();
		    }      
	}
}
