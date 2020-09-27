package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import model.Path;

public class AskPathController implements Initializable {
    @FXML
    private Button enterButton;

    @FXML
    private ComboBox pathCombo;

    private Path path, path1, path2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pathCombo.valueProperty().addListener(e -> {
            if(pathCombo.getValue() == null) enterButton.setDisable(true);
            else enterButton.setDisable(false);
        });
    }

    public void onClickEnter(ActionEvent ae) {
        if(pathCombo.getSelectionModel().getSelectedIndex() == 0) {
            path = path1;
        } else {
            path = path2;
        }
        ((Stage) (((Node) ae.getSource()).getScene().getWindow())).close();
    }

    public void setPaths(Path path1, Path path2) {
        this.path1 = path1;
        this.path2 = path2;
        pathCombo.getItems().add(path1.getName());
        pathCombo.getItems().add(path2.getName());
    }

    public Path getPath() {
        return path;
    }
}
