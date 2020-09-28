package controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Game;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;



public class GameResultController implements Initializable {

    @FXML
    private Label place1st, cash1st;

    @FXML
    private Button exitButton;

    private Player[] retiredPlayers;

    private Player winner;

    private Game game;

    public GameResultController(Player[] retiredPlayers){
        this.retiredPlayers = retiredPlayers;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int highest = 0;
        for(Player player : retiredPlayers){
            if(player.getCash() > highest) {
                highest = player.getCash();
                winner = player;
            }
        }
        place1st.setText(winner.getName());
        cash1st.setText("$ " + winner.getCash());
    }

}


