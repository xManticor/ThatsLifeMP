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
import java.util.Random;
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
        game = new Game(numberOfPlayer);

        board.setWidth(23 * 1.5 * 50);
        board.setHeight(16 * 1.5 * 50);

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
                Path selectedPath = ((AskPathController) askPathLoader.getController()).getPath();
                if(selectedPath.getName().equals("College Path")) {
                    player.addLoan();
                    player.addLoan();
                } else {
                    // draw career card and assign it to the player
                    CareerCard careerCard;
                    // this loop is to return the card if it required a college degree
                    do {
                        careerCard = (CareerCard) game.getCareerDeck().drawCard();
                        if(careerCard.isDegreeRequired()) {
                            game.getCareerDeck().addCard(careerCard);
                        }
                    } while(careerCard.isDegreeRequired());
                    player.setCareer(careerCard);
                    // draw salary card and assign it to the player
                    player.setSalary((SalaryCard) game.getSalaryDeck().drawCard());
                }
                player.setPath(selectedPath);
                player.getPath().getSpace(player.getLocation()).addPlayer(player);
            }
        }

        if(game.getCurrentPlayer().getLoan() > 0) payLoanButton.setDisable(false);
        else payLoanButton.setDisable(true);
    }

    @FXML
    public void onClickMove(ActionEvent ae) {
        Random random = new Random();
        int dice = random.nextInt(10) + 1;
        System.out.println(game.getCurrentPlayer().getName() + " rolled " + dice);

        int diceLeft = 0;
        boolean isNextPath = false;
        Space space = null;

        System.out.println(game.getCurrentPlayer().getLocation());
        game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()).removePlayer(game.getCurrentPlayer());

        for(int i = 0; i < dice; i++) {
            game.getCurrentPlayer().setLocation(game.getCurrentPlayer().getLocation() + 1);
            System.out.println(game.getCurrentPlayer().getPath().getNSpaces() + " - " + game.getCurrentPlayer().getLocation());

            // stops if player reached the end of the Path
            if(game.getCurrentPlayer().getPath().getNSpaces() - 1 == game.getCurrentPlayer().getLocation()) {
                isNextPath = true;
                diceLeft = dice - i - 2;
                break;
            }
            space = game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation());
            // stops if player is in magenta space
            if(game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()).getColor().equals(Color.MAGENTA)) {
                break;
            }
        }

        if(isNextPath) {
            if(game.getCurrentPlayer().getPath().getLastSpace().getConnector() != null) {
                Path nextPath = game.getCurrentPlayer().getPath().getLastSpace().getConnector();
                game.getCurrentPlayer().setPath(nextPath);
                for(int i = 0; i < diceLeft; i++) {
                    game.getCurrentPlayer().setLocation(game.getCurrentPlayer().getLocation() + 1);
                    space = game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation());
                    // stops if player is in magenta space
                    if(game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()).getColor().equals(Color.MAGENTA)) {
                        break;
                    }
                }
                handleSpace(space);
            } else if(game.getCurrentPlayer().getPath().getLastSpace().getType().equals("Which Path?")) {
                Path path1 = ((WhichPathSpace) game.getCurrentPlayer().getPath().getLastSpace()).getPath1();
                Path path2 = ((WhichPathSpace) game.getCurrentPlayer().getPath().getLastSpace()).getPath2();

                // ask for path
                Stage askPathStage = new Stage();
                askPathStage.initStyle(StageStyle.UNDECORATED);
                askPathStage.initModality(Modality.APPLICATION_MODAL);

                FXMLLoader askPathLoader = new FXMLLoader(getClass().getResource("/view/AskPath.fxml"));

                try {
                    askPathStage.setScene(new Scene(askPathLoader.load()));
                    ((AskPathController) askPathLoader.getController()).setPaths(path1, path2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                askPathStage.showAndWait();
                Path selectedPath = ((AskPathController) askPathLoader.getController()).getPath();
                game.getCurrentPlayer().setPath(selectedPath);

                if(game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()).getColor().equals(Color.MAGENTA)) {
                    // activate magenta space
                    handleSpace(game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()));
                }
            } else {
                // player is retired
                game.getCurrentPlayer().setRetired(true);
                game.getCurrentPlayer().setPath(null);
                if(game.getCurrentPlayer().getCareer() != null) {
                    game.getCareerDeck().addCard(game.getCurrentPlayer().getCareer());
                    game.getCurrentPlayer().setCareer(null);
                }

                if(game.getCurrentPlayer().getSalary() != null) {
                    game.getSalaryDeck().addCard(game.getCurrentPlayer().getSalary());
                    game.getCurrentPlayer().setSalary(null);
                }

                // pay all loans
                game.getCurrentPlayer().payLoan(game.getCurrentPlayer().getLoan() / 25000);

                // sell house
                if(game.getCurrentPlayer().getHouse() != null) {
                    game.getCurrentPlayer().addCash(game.getCurrentPlayer().getHouse().getValue());
                    game.getHouseDeck().addCard(game.getCurrentPlayer().getHouse());
                    game.getCurrentPlayer().setHouse(null);
                }
            }
        } else {
            handleSpace(game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()));
        }

        game.getCurrentPlayer().getPath().getSpace(game.getCurrentPlayer().getLocation()).addPlayer(game.getCurrentPlayer());

        game.setTurn(game.getTurn() + 1);
        if(game.getTurn() == game.getNumPlayers()) {
            game.setTurn(0);
        }

        updatePayLoanButton();
        refreshScreen();
    }

    private void handleSpace(Space space) {
        if(space.getColor().equals(Color.ORANGE)) {

        } else if(space.getColor().equals(Color.BLUE)) {

        } else if(space.getColor().equals(Color.GREEN)) {

        } else if(space.getColor().equals(Color.MAGENTA)) {

        }
    }

    @FXML
    public void onClickPayLoan(ActionEvent ae) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader payLoadLoader = new FXMLLoader(getClass().getResource("/view/PayLoan.fxml"));
        PayLoanController payLoanController = new PayLoanController(game.getCurrentPlayer());
        payLoadLoader.setController(payLoanController);

        try {
            stage.setScene(new Scene(payLoadLoader.load()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.showAndWait();
        game.getCurrentPlayer().payLoan(payLoanController.getLoanMultiplier());

        updatePayLoanButton();
        refreshScreen();
    }

    private void updatePayLoanButton() {
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
        else salaryLabel.setText("SALARY:" + game.getCurrentPlayer().getSalary());
        if(game.getCurrentPlayer().getPath() != null) pathLabel.setText("PATH:" + game.getCurrentPlayer().getPath().getName());
        else pathLabel.setText("PATH:" + game.getCurrentPlayer().getPath());
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

        gc.setFill(Color.BLACK);
        gc.fillText("College Path 1", x - 100, y + 60);

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

        gc.setFill(Color.BLACK);
        gc.fillText("Career Path 1", x - 120, y - 10);
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

        gc.setFill(Color.BLACK);
        gc.fillText("Career Path 2", x + 120, y - 10);
    }

    private void drawChangeCareerPath1(Path changeCareerPath1, double x, double y, GraphicsContext gc)  {
        for(int i = 0; i < 4; i++) {
            drawSpace(changeCareerPath1.getSpaces()[i], x, y, gc);
            y -= 50;
        }

        y += 50;

        gc.setFill(Color.BLACK);
        gc.fillText("Change Career Path 1", x - 120, y + 60);

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

        gc.setFill(Color.BLACK);
        gc.fillText("Start a Family Path 1", x + 120, y - 10);

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

        gc.setFill(Color.BLACK);
        gc.fillText("Career Path 3", x + 120, y - 10);

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
        gc.setFill(Color.BLACK);
        gc.fillText("Change Career Path 2", x - 70, y + 60);

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
        gc.setFill(Color.BLACK);
        gc.fillText("Start a Family Path 2", x + 20, y + 60);

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

        gc.setFill(Color.BLACK);
        for(Player player : space.getPlayers()) {
//            gc.drawImage( new Image(""));
            gc.fillText(player.getName(), x, y + 25);
            x += 15;
        }
    }
}
