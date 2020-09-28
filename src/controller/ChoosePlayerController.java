package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * ChoosePlayerController class controller for GUI
 */
public class ChoosePlayerController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    private Player[] otherPlayers;
    private Player player;

    /**
     * ChoosePlayerController constructor that collects players besides the current player
     * @param otherPlayers
     */
    public ChoosePlayerController(Player[] otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    /**
     * Shows the players in a combo box and one has to be selected, besides the current player
     * Also disables enter button until a choice has been made
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> playerchoices = new ArrayList<>();

        for(Player player : otherPlayers) {
            String playerchoice = player.getName();
                playerchoices.add(playerchoice);
            }

        comboBox.getItems().addAll(playerchoices);

        comboBox.setOnAction(e -> {
            if(comboBox.getValue() == null)
                enterButton.setDisable(true);
            else
                enterButton.setDisable(false);
        });
        }

    /**
     * Gets the player selected from the combo box when enter is clicked
      * @param ae
     */
    public void onEnter(ActionEvent ae) {

        player = otherPlayers[comboBox.getSelectionModel().getSelectedIndex()];

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    /**
     * Gets the selected player
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

}
