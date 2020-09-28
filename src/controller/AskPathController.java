package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.Path;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * AskPathController class controller for GUI
 */
public class AskPathController implements Initializable {
    @FXML
    private Button enterButton;

    @FXML
    private ComboBox pathCombo;

    private Path path, path1, path2;

    /**
     * Overrides initialize with programmer's intent to disable enterButton if no text has been entered
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pathCombo.valueProperty().addListener(e -> {
            if(pathCombo.getValue() == null) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
    }

    /**
     * Copies path1 or path 2 into path when enter is clicked
     * @param ae
     */
    public void onClickEnter(ActionEvent ae) {
        if(pathCombo.getSelectionModel().getSelectedIndex() == 0) {
            path = path1;
        } else {
            path = path2;
        }
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }

    /**
     * Sets and adds the path to be taken
     * @param path1 first path
     * @param path2 second path
     */
    public void setPaths(Path path1, Path path2) {
        this.path1 = path1;
        this.path2 = path2;
        pathCombo.getItems().add(path1.getName());
        pathCombo.getItems().add(path2.getName());
    }

    /**
     * Gets path
     * @return path
     */
    public Path getPath() {
        return path;
    }
}
