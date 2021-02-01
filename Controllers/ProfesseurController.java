package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfesseurController {
	@FXML private Label nom;
	@FXML private Label prenom;
	@FXML private Label poste;
	
	public void infos(String nom, String prenom, String poste)
	{
		this.nom.setText(nom);
		this.prenom.setText(prenom);
		this.poste.setText(poste);
	}
}
