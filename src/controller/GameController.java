package controller;

import javafx.fxml.Initializable;
import model.Game;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private int numberOfPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = new Game(numberOfPlayer);
        int turn = 0;

        while(game.getNumRetired() != game.getNumPlayers()) {
            getPlayerTurn(game.getPlayers()[turn]);
            turn++;

            if(turn == game.getNumPlayers()) turn = 0;
            refreshScreen();
        }
    }

    private void getPlayerTurn(Player player) {
        if(player.getName() == null) {
            // ask for player name
        }

        if(player.getPath() == null) {
            // ask for path
        }

        // ask for player to choose a move
        // - roll dice
        // - pay debt (only if may debt)
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void refreshScreen() {
        // refresh board
        // refresh stats
    }
}
