package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Game;
import model.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChoosePlayerController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    private Player[] otherPlayers;
    private Player player;

    public ChoosePlayerController(Player[] otherPlayers) {
        this.otherPlayers = otherPlayers;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> playerchoices = new ArrayList<>();

        for(Player player : otherPlayers) {
            String playerchoice = player.getName();
                playerchoices.add(playerchoice);
            }

        comboBox.getItems().addAll(playerchoices);

        comboBox.setOnAction(e -> {
            if(comboBox.getValue() == null) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
        }

    public void onEnter(ActionEvent ae) {

        player = otherPlayers[comboBox.getSelectionModel().getSelectedIndex()];

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public Player getPlayer() {
        return player;
    }

}
