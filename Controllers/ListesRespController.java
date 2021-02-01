package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ListesRespController {
	@FXML private Label nom;
	@FXML private Label prenom;
	@FXML private Label poste;
	
	public void infos(String nom, String prenom, String poste)
	{
		this.nom.setText(nom);
		this.prenom.setText(prenom);
		this.poste.setText(poste);
	}
	
	public void retourAccueil(ActionEvent e)
	{
		Stage stage;
  	  	stage=(Stage) poste.getScene().getWindow();
  	  	stage.show();
	}
}
