package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.ActionCard;
import model.BlueCard;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawnBlueController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label bcNameLabel;

    private BlueCard card;

    public DrawnBlueController(BlueCard card){
        this.card = card;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bcNameLabel.setText(card.getName());
    }

    public void onExit(javafx.event.ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}