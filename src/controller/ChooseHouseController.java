package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseHouseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enterButton.setDisable(true);
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Mansion");
        choices.add("Apartment");
        choices.add("Cabin");
        comboBox.getItems().addAll(choices);
        comboBox.setOnAction(e -> {
            if(comboBox.getValue() != null) enterButton.setDisable(false);
        });
    }

    public void onEnter(ActionEvent ae) {

        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/view/ChooseHouse.fxml"));

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
