package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    private int numberOfPlayer;

    @FXML
    private Canvas board;

    @FXML
    private Button moveButton, payLoanButton;

    @FXML
    private Label playerLabel, cashLabel, careerLabel, salaryLabel, pathLabel;

    private Stage stage;

    private Game game;

    public GameController(Stage stage, int numberOfPlayer) {
        this.stage = stage;
        this.numberOfPlayer = numberOfPlayer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        board.setWidth(23 * 1.5 * 50);
        board.setHeight(16 * 1.5 * 50);
        game = new Game(numberOfPlayer);

        for(Player player : game.getPlayers()) {
            if(player.getName() == null) {
                // ask for player name
                Stage askNameStage = new Stage();
                askNameStage.initStyle(StageStyle.UNDECORATED);
                askNameStage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader askNameLoader = new FXMLLoader(getClass().getResource("/view/AskName.fxml"));

                try {
                    askNameStage.setScene(new Scene(askNameLoader.load()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                askNameStage.showAndWait();
                player.setName(((AskNameController) askNameLoader.getController()).getName());
            }

            if(player.getPath() == null) {
                // ask for path
                Stage askPathStage = new Stage();
                askPathStage.initStyle(StageStyle.UNDECORATED);
                askPathStage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader askPathLoader = new FXMLLoader(getClass().getResource("/view/AskPath.fxml"));

                try {
                    askPathStage.setScene(new Scene(askPathLoader.load()));
                    ((AskPathController) askPathLoader.getController()).setPaths(game.getCareerPath1(), game.getCollegePath1());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                askPathStage.showAndWait();
                player.setPath(((AskPathController) askPathLoader.getController()).getPath());
            }
        }
    }

    @FXML
    public void onClickMove(ActionEvent ae) {
        game.setTurn(game.getTurn() + 1);
        if(game.getTurn() == game.getNumPlayers()) {
            game.setTurn(0);
        }

        updatePayLoanButton();
        refreshScreen();
    }

    @FXML
    public void onClickPayDebt(ActionEvent ae) {
        updatePayLoanButton();
        refreshScreen();
    }

    private void updatePayLoanButton() {
        System.out.println(game.getCurrentPlayer());
        System.out.println(game.getTurn());
        if(game.getCurrentPlayer().getLoan() > 0) {
            payLoanButton.setDisable(false);
        } else {
            payLoanButton.setDisable(true);
        }
    }

    public void refreshScreen() {
        // refresh board
        drawBoard();
        // refresh stats
        playerLabel.setText("PLAYER:" + game.getCurrentPlayer().getName());
        cashLabel.setText("CASH:" + game.getCurrentPlayer().getCash());
        if(game.getCurrentPlayer().getCareer() != null) careerLabel.setText("CAREER:" + game.getCurrentPlayer().getCareer().getName());
        else careerLabel.setText("CAREER:" + game.getCurrentPlayer().getCareer());
        if(game.getCurrentPlayer().getSalary() != null) salaryLabel.setText("SALARY:" + Integer.toString(game.getCurrentPlayer().getSalary().getSalary()));
        else careerLabel.setText("SALARY:" + game.getCurrentPlayer().getSalary());
        if(game.getCurrentPlayer().getPath() != null) pathLabel.setText("PATH:" + game.getCurrentPlayer().getPath().getName());
        else careerLabel.setText("PATH:" + game.getCurrentPlayer().getPath());

    }

    public void drawBoard() {
        GraphicsContext gc = board.getGraphicsContext2D();
        gc.clearRect(0, 0, board.getWidth(), board.getHeight());

        double x = board.getWidth() / 2, y = board.getHeight() / 2;

        gc.strokeRect(x - 100, y - 150, 150, 150);

        Path collegePath1 = game.getCollegePath1();
        drawCollegePath1(collegePath1, x, y, gc);

        x += 50;
        y -= 2 * 50;

        Path careerPath1 = game.getCareerPath1();
        drawCareerPath1(careerPath1, x, y, gc);

        x += 3 * 50;

        Path careerPath2 = collegePath1.getLastSpace().getConnector();
        drawCareerPath2(careerPath2, x, y, gc);

        x -= 7 * 50;
        y -= 5 * 50;

        Path changeCareerPath1 = ((WhichPathSpace) careerPath2.getLastSpace()).getPath2();
        drawChangeCareerPath1(changeCareerPath1, x, y, gc);

        x -= 50;
        y += 50;

        Path familyPath1 = ((WhichPathSpace) careerPath2.getLastSpace()).getPath1();
        drawFamilyPath1(familyPath1, x, y, gc);

        x -= 6 * 50;
        y += 3 * 50;

        Path careerPath3 = changeCareerPath1.getLastSpace().getConnector();
        drawCareerPath3(careerPath3, x, y, gc);

        x += 18 * 50;
        y += 2 * 50;

        Path changeCareerPath2 =  ((WhichPathSpace) careerPath3.getLastSpace()).getPath2();
        drawChangeCareerPath2(changeCareerPath2, x, y, gc);

        x += 2 * 50;

        Path familyPath2 = ((WhichPathSpace) careerPath3.getLastSpace()).getPath1();
        drawFamilyPath2(familyPath2, x, y, gc);

        x -= 3 * 50;
        y -= 9 * 50;

        Path careerPath4 = changeCareerPath2.getLastSpace().getConnector();
        drawCareerPath4(careerPath4, x, y, gc);

        x -= 7 * 50;

        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, 150, 150);

        // retirement
    }

    private void drawCollegePath1(Path collegePath1, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 2; i++) {
            drawSpace(collegePath1.getSpaces()[i], x, y, gc);
            y += 50;
        }

        y -= 50;

        for(int i = 2; i < 6; i++) {
            x += 50;
            drawSpace(collegePath1.getSpaces()[i], x, y, gc);
        }

        x -= 50;

        for(int i = 6; i < collegePath1.getNSpaces(); i++) {
            y -= 50;
            drawSpace(collegePath1.getSpaces()[i], x, y, gc);
        }
    }

    private void drawCareerPath1(Path careerPath1, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 3; i++) {
            drawSpace(careerPath1.getSpaces()[i], x, y, gc);
            x += 50;
        }
    }

    private void drawCareerPath2(Path careerPath2, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 5; i++) {
            drawSpace(careerPath2.getSpaces()[i], x, y, gc);
            y -= 50;
        }

        y += 50;

        for(int i = 5; i < careerPath2.getNSpaces(); i++) {
            x -= 50;
            drawSpace(careerPath2.getSpaces()[i], x, y, gc);
        }
    }

    private void drawChangeCareerPath1(Path changeCareerPath1, double x, double y, GraphicsContext gc)  {
        for(int i = 0; i < 4; i++) {
            drawSpace(changeCareerPath1.getSpaces()[i], x, y, gc);
            y -= 50;
        }

        y += 50;

        for(int i = 4; i < 12; i++) {
            x -= 50;
            drawSpace(changeCareerPath1.getSpaces()[i], x, y, gc);
        }

        for(int i = 12; i < changeCareerPath1.getNSpaces(); i++) {
            y += 50;
            drawSpace(changeCareerPath1.getSpaces()[i], x, y, gc);
        }
    }

    private void drawFamilyPath1(Path familyPath1, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 6; i++) {
            drawSpace(familyPath1.getSpaces()[i], x, y, gc);
            x -= 50;
        }

        x += 50;

        for(int i = 6; i < familyPath1.getNSpaces(); i++) {
            y += 50;
            drawSpace(familyPath1.getSpaces()[i], x, y, gc);
        }
    }

    private void drawCareerPath3(Path careerPath3, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 9; i++) {
            drawSpace(careerPath3.getSpaces()[i], x, y, gc);
            y += 50;
        }

        y -= 50;

        for(int i = 9; i < 28; i++) {
            x += 50;
            drawSpace(careerPath3.getSpaces()[i], x, y, gc);
        }

        for(int i = 28; i < careerPath3.getNSpaces(); i++) {
            y -= 50;
            drawSpace(careerPath3.getSpaces()[i], x, y, gc);
        }
    }

    private void drawChangeCareerPath2(Path changeCareerPath2, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 2; i++) {
            drawSpace(changeCareerPath2.getSpaces()[i], x, y, gc);
            x -= 50;
        }

        x += 50;

        for(int i = 2; i < changeCareerPath2.getNSpaces(); i++) {
            y -= 50;
            drawSpace(changeCareerPath2.getSpaces()[i], x, y, gc);
        }
    }

    private void drawFamilyPath2(Path familyPath2, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < 2; i++) {
            drawSpace(familyPath2.getSpaces()[i], x, y, gc);
            x += 50;
        }

        x -= 50;

        for(int i = 2; i < 11; i++) {
            y -= 50;
            drawSpace(familyPath2.getSpaces()[i], x, y, gc);
        }

        x -= 50;

        for(int i = 11; i < familyPath2.getNSpaces(); i++) {
            drawSpace(familyPath2.getSpaces()[i], x, y, gc);
            x -= 50;
        }
    }

    private void drawCareerPath4(Path careerPath4, double x, double y, GraphicsContext gc) {
        for(int i = 0; i < careerPath4.getNSpaces(); i++) {
            drawSpace(careerPath4.getSpaces()[i], x, y, gc);
            x -= 50;
        }
    }

    private void drawSpace(Space space, double x, double y, GraphicsContext gc) {
        gc.setFill(space.getColor());
        gc.fillRect(x, y, 50, 50);
        gc.strokeRect(x, y, 50, 50);
        gc.fillText(space.getType(), x, y);
        for(Player player : space.getPlayers()) {
//            gc.drawImage( new Image(""));
        }
    }
}
