package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.BlueCard;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * DrawnBlueController class controller for GUI
 */
public class DrawnBlueController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label bcNameLabel;

    private BlueCard card;

    /**
     * DrawnBlueController constructor that takes in a BlueCard
     * @param card
     */
    public DrawnBlueController(BlueCard card){
        this.card = card;
    }

    /**
     * Sets the text label into the name of the Blue Card
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bcNameLabel.setText(card.getName());
    }

    /**
     * Closes the window when exit is clicked
     * @param ae
     */
    public void onExit(javafx.event.ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}