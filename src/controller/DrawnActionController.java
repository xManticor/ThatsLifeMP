package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawnActionController implements Initializable {

    @FXML
    private Button okButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onOK(ActionEvent ae) {
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }
}
