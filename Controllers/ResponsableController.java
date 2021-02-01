package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResponsableController {
	@FXML private Label nom;
	@FXML private Label prenom;
	@FXML private Label poste;
	
	public void infos(String nom, String prenom, String poste)
	{
		this.nom.setText(nom);
		this.prenom.setText(prenom);
		this.poste.setText(poste);
	}
	
	public void consulterListes(ActionEvent e)
	{
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/ListesResponsable.fxml"));
			Parent root =loader.load();
			  
	  	  	Scene scene = new Scene(root);
	  	  	Stage fen=new Stage();
	  	  	fen.setScene(scene);
	  	  	fen.show();
	  	  
	  	  	Stage stage;
	  	  	stage=(Stage) poste.getScene().getWindow();
	  	  	stage.close();
	  	  	
	  	  	ListesRespController listesR=loader.getController();
	  	  	listesR.infos(nom.getText(),prenom.getText(),poste.getText());
		}
		catch(Exception exp)
		{
			System.out.println("Erreur de connexion à la base de données, Redémarrer l'application");
		    Stage stage;
		    stage=(Stage) poste.getScene().getWindow();
		    stage.close();
		}
	}
	
	public void consulterOM(ActionEvent e)
	{
		
	}
	
	public void faireFicheRemb(ActionEvent e)
	{
		
	}
	
	public void faireOM(ActionEvent e)
	{
		
	}
}
