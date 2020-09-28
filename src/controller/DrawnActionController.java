package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.ActionCard;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawnActionController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label acNameLabel, acAmountLabel;

    private ActionCard card;

    public DrawnActionController(ActionCard card){
        this.card = card;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acNameLabel.setText(card.getName());
        acAmountLabel.setText("$" + card.getAmount());
    }

    public void onExit(javafx.event.ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}
