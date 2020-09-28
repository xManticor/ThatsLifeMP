package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Game;
import model.Player;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * GameResultController class controller for GUI
 */
public class GameResultController implements Initializable {

    @FXML
    private Label place1st, cash1st;

    @FXML
    private Button exitButton;

    private Player[] retiredPlayers;

    private Player winner;

    private Game game;

    /**
     * GameResultController constructor that takes in the retired players
     * @param retiredPlayers
     */
    public GameResultController(Player[] retiredPlayers){
        this.retiredPlayers = retiredPlayers;
    }

    /**
     * Checks which player has the highest cash and makes it the winner
     * @param location
     * @param resources
     */
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


