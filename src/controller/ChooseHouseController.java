package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.Card;
import model.Deck;
import model.HouseCard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseHouseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    private HouseCard houseCard;
    private Deck houseDeck;


    public ChooseHouseController(Deck houseDeck) {
        this.houseDeck = houseDeck;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enterButton.setDisable(true);
        ArrayList<String> choices = new ArrayList<>();

        for(Card houseCard : houseDeck.getDeck()) {
            String choice = ((HouseCard) houseCard).getName() + ;
            if(choices)
        }

        choices.add("Mansion    - $1000000");
        choices.add("Apartment  - $500000");
        choices.add("Cabin      - $200000");
        comboBox.getItems().addAll(choices);
        comboBox.setOnAction(e -> {
            if(comboBox.getValue() != null) enterButton.setDisable(false);
            else enterButton.setDisable(true);
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
