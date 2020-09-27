package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import model.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class PayLoanController implements Initializable {
    @FXML
    private Spinner spinner;

    @FXML
    private Label titleLabel;

    private Player player;

    private int loanMultiplier;

    public PayLoanController(Player player) {
        this.player = player;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleLabel.setText("Pay Loan ($" + player.getLoan() + ")");
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, player.getLoan() / 25000, 1));
    }

    @FXML
    public void onClickEnter(ActionEvent ae) {
        loanMultiplier = (int) spinner.getValue();
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }

    public int getLoanMultiplier() {
        return loanMultiplier;
    }
}
