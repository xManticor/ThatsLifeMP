package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.CareerCard;
import model.Deck;
import model.Player;
import model.SalaryCard;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * CareerChoiceController class controller for GUI
 */
public class CareerChoiceController implements Initializable {
    @FXML
    private ComboBox careerCombo, salaryCombo;

    @FXML
    private Button enterButton;

    private String type; //
    private Player player;
    private Deck careerDeck, salaryDeck;
    private CareerCard careerCard1, careerCard2;
    private SalaryCard salaryCard1, salaryCard2;

    /**
     * CareerChoiceController that takes the parameters and draws salary cards
     * @param type
     * @param player
     * @param careerDeck
     * @param salaryDeck
     */
    public CareerChoiceController(String type, Player player, Deck careerDeck, Deck salaryDeck) {
        this.type = type; //
        this.player = player;
        this.careerDeck = careerDeck;
        this.salaryDeck = salaryDeck;
        salaryCard1 = (SalaryCard) salaryDeck.drawCard();
        salaryCard2 = (SalaryCard) salaryDeck.drawCard();
    }

    /**
     * Creates new ArrayLists for the drawn salary and career cards and set into combo boxes, and also disables
     * enter button if no choices has been made
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> careerChoices = new ArrayList<>();
        ArrayList<String> salaryChoices = new ArrayList<>();
        if (type.equals("College Career Choice") || player.hasCollegeDegree()) {

            careerCard1 = (CareerCard) careerDeck.drawCard();
            careerCard2 = (CareerCard) careerDeck.drawCard();

        } else {
            careerCard1 = (CareerCard) careerDeck.drawDegreeCard();
            careerCard2 = (CareerCard) careerDeck.drawDegreeCard();
        }

        careerChoices.add(careerCard1.getName() + " - " + careerCard1.getMaxRaise());
        careerChoices.add(careerCard2.getName() + " - " + careerCard2.getMaxRaise());
        careerCombo.getItems().addAll(careerChoices);

        salaryChoices.add("$" + salaryCard1.getSalary() + " - $" + salaryCard1.getTaxDue());
        salaryChoices.add("$" + salaryCard2.getSalary() + " - $" + salaryCard2.getTaxDue());
        salaryCombo.getItems().addAll(salaryChoices);


        careerCombo.setOnAction(e -> {
            if(careerCombo.getValue() == null && salaryCombo.getValue() == null)
                enterButton.setDisable(true);
        });
        salaryCombo.setOnAction(e -> {
            if (salaryCombo.getValue() == null && careerCombo.getValue() == null)
                enterButton.setDisable(true);
            else
                enterButton.setDisable(false);
        });
    }

    /**
     * Checks which card has been selected and returns the cards that has not been selected when enter has been clicked
     * @param ae
     */
    @FXML
    public void onClickEnter(ActionEvent ae) {
        if(careerCombo.getSelectionModel().getSelectedIndex() == 0) {
            player.setCareer(careerCard1);
            careerDeck.addCard(careerCard2);
        } else {
            player.setCareer(careerCard2);
            careerDeck.addCard(careerCard1);
        }
        if(salaryCombo.getSelectionModel().getSelectedIndex() == 0) {
            player.setSalary(salaryCard1);
            salaryDeck.addCard(salaryCard2);
        } else {
            player.setSalary(salaryCard2);
            salaryDeck.addCard(salaryCard1);
        }

        ((Stage) ((Node) ae.getSource()).getScene().getWindow()).close();
    }
}
