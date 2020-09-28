package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.ActionCard;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * DrawnActionController class controller for GUI
 */
public class DrawnActionController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label acNameLabel, acAmountLabel;

    private ActionCard card;

    /**
     * DrawnActionController constructor that takes in an ActionCard
     * @param card
     */
    public DrawnActionController(ActionCard card){
        this.card = card;
    }

    /**
     * Sets the text of the labels into the name of the card and its value
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acNameLabel.setText(card.getName());
        acAmountLabel.setText("$" + card.getAmount());
    }

    /**
     * Closes the window when exit is clicked
     * @param ae
     */
    public void onExit(javafx.event.ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}
