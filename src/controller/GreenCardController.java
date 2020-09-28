package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GreenCardController implements Initializable {

    @FXML
    private Button exitButton;

    @FXML
    private Label gcNameLabel, gcAmountLabel;
    private int amount;
    private String name;

    public GreenCardController(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gcNameLabel.setText(name);
        if(name.equals("Pay Day"))
            gcAmountLabel.setText("$" + amount);
        else if (name.equals("Pay Raise"))
            gcAmountLabel.setText("Raise added by 1");
    }

    public void onExit(javafx.event.ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}
