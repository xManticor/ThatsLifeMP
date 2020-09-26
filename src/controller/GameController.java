package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;


public class GameController {
    private int numberOfPlayer;

    @FXML
    private Canvas board;

    private Stage stage;

    private Game game;

    public GameController(Stage stage, int numberOfPlayer) {
        this.stage = stage;
        this.numberOfPlayer = numberOfPlayer;
    }

    public void gameOn() {
        board.setWidth(23 * 1.5 * 50);
        board.setHeight(16 * 1.5 * 50);
        game = new Game(numberOfPlayer);
        int turn = 0;

        drawBoard();
//        while(game.getNumRetired() != game.getNumPlayers()) {
//            drawBoard();
//            getPlayerTurn(game.getPlayers()[turn]);
//            turn++;
//
//            if(turn == game.getNumPlayers()) turn = 0;
//            refreshScreen();
//        }
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

        x += 50;
        y -= 50;

        for(int i = 2; i < 6; i++) {
            drawSpace(collegePath1.getSpaces()[i], x, y, gc);
            x += 50;
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
        x -= 50;

        for(int i = 5; i < careerPath2.getNSpaces(); i++) {
            drawSpace(careerPath2.getSpaces()[i], x, y, gc);
            x -= 50;
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
        y += 50;

        for(int i = 6; i < familyPath1.getNSpaces(); i++) {
            drawSpace(familyPath1.getSpaces()[i], x, y, gc);
            y += 50;
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



    private void getPlayerTurn(Player player) {
        if(player.getName() == null) {
            // ask for player name
        }

        if(player.getPath() == null) {
            // ask for path
        }

        // ask for player to choose a move
        // - roll dice
        // - pay debt (only if may debt)
    }

    public void refreshScreen() {
        // refresh board
        // refresh stats
    }

}
