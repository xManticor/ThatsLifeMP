package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * AskNameController class controller for GUI
 */
public class AskNameController implements Initializable {
    @FXML
    private TextField nameInput;

    @FXML
    private Button enterButton;

    private String name;

    /**
     * Overrides initialize with programmer's intent to disable enterButton if no text has been entered
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameInput.textProperty().addListener(e -> {
            if(nameInput.getText().equals("")) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
    }

    /**
     * Takes name and closes the window when enter is clicked
     * @param ae
     */
    @FXML
    public void onClickEnter(ActionEvent ae) {
        name = nameInput.getText();
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }

    /**
     * Gets the name input
     * @return name
     */
    public String getName() {
        return name;
    }
}
