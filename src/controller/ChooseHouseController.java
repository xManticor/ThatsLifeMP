package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

/**
 * ChooseHouseController class controller for GUI
 */
public class ChooseHouseController implements Initializable {

    @FXML
    private ComboBox comboBox;

    @FXML
    private Button enterButton;

    private HouseCard houseCard;
    private Deck houseDeck;

    /**
     * ChooseHouseController constructor that takes in a HouseDeck
     * @param houseDeck
     */
    public ChooseHouseController(Deck houseDeck) {
        this.houseDeck = houseDeck;
    }

    /**
     * Puts the houses inside a combobox with its value and disables enter until a choice has been made
     * @param location
     * @param resources
     */
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

    /**
     * Takes the houseCard that has been selected by the player and closes the window
     * @param ae
     */
    public void onEnter(ActionEvent ae) {
        houseCard = (HouseCard) houseDeck.getDeck().get(comboBox.getSelectionModel().getSelectedIndex());

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }

    /**
     * gets and returns the houseCard
     * @return houseCard
     */
    public HouseCard getHouseCard() {
        return houseCard;
    }
}
