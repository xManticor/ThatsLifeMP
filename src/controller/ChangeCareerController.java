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

public class ChangeCareerController  {

    @FXML
    private ComboBox careerCombo, salaryCombo;

    @FXML
    private Button enterButton;

    private Player player;
    private Deck careerDeck, salaryDeck;
    private CareerCard careerCard1, careerCard2;

    //public ChangeCareerController(Player player, Deck careerDeck)
}
