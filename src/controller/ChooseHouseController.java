package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
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
        ArrayList<String> choices = new ArrayList<>();

        for(Card houseCard : houseDeck.getDeck()) {
            String choice = houseCard.getName() + " - $" + ((HouseCard) houseCard).getValue();
            if(!choices.contains(choice)) {
                choices.add(choice);
            }
        }

        comboBox.getItems().addAll(choices);

        comboBox.setOnAction(e -> {
            if(comboBox.getValue() == null) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
    }

    public void onEnter(ActionEvent ae) {
        houseCard = (HouseCard) houseDeck.getDeck().get(comboBox.getSelectionModel().getSelectedIndex());

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    public HouseCard getHouseCard() {
        return houseCard;
    }
}
