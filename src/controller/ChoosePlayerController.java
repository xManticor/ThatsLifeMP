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

    private Player[] players;
    private Player player;
    private Game game;

    public ChoosePlayerController(Player[] players) {
        this.players = players;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> playerchoices = new ArrayList<>();

        for(int i = 0; i < game.getOtherPlayers().length; i++) {
            String playerchoice = game.getOtherPlayers()[i].getName();
                playerchoices.add(playerchoice);
            }

        comboBox.getItems().addAll(playerchoices);

        comboBox.setOnAction(e -> {
            if(comboBox.getValue() == null) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
        }

    public void onEnter(ActionEvent ae) {

        player = game.getPlayers()[comboBox.getSelectionModel().getSelectedIndex()];

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

}
