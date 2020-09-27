package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Game;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enterButton.setDisable(true);
        ArrayList<Integer> choices = new ArrayList<>();
        choices.add(2);
        choices.add(3);
        comboBox.getItems().addAll(choices);
        comboBox.setOnAction(e -> {
            if(comboBox.getValue() != null) enterButton.setDisable(false);
        });
    }

    @FXML
    public void onEnter(ActionEvent ae) {
        Stage stage = (Stage) (((Node) ae.getSource()).getScene().getWindow());

        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
        GameController gameController = new GameController(stage, (int) comboBox.getValue());
        gameLoader.setController(gameController);

        try {
            stage.setScene(new Scene(gameLoader.load()));

            // turns the stage into fullscreen
            stage.setMaximized(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onExit(ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}
