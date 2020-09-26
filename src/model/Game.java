package model;

import java.util.Scanner;
import java.util.*;

public class Game {

    private Player[] players;
    private Player[] retired;
    private int numPlayers;
    private String pName;

    Deck actionDeck = new Deck("Action Deck");
    Deck blueDeck = new Deck("Blue Deck");
    Deck careerDeck = new Deck("Career Deck");
    Deck salaryDeck = new Deck("Salary Deck");
    Deck houseDeck = new Deck("House Deck");

    Path collegePath = new Path("College Path", 7);
    Path careerPath1 = new Path("Career Path 1", 2);
    Path careerPath2 = new Path("Career Path 2", 11);


    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        this.players = new Player[numPlayers];
        this.retired = new Player[numPlayers];

        // Generates players
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
        }
        generateActionDeck();
        generateBlueDeck();
        generateCareerDeck();
        generateHouseDeck();
        generateSalaryDeck();


    }

    /*public void generatePath(){

        for(int i = 0; i < Path.length; )
    }*/


    public void display2TopCareer(){
        System.out.println(careerDeck.getDeck().get(0).getName() +","+ careerDeck.getDeck().get(0).getDescription());
        System.out.println(careerDeck.getDeck().get(1).getName() +","+ careerDeck.getDeck().get(1).getDescription());
    }

    public void generateActionDeck() {

        for (int i = 0; i < 20; i++)
            actionDeck.addCard(new CollectFromBank("Collect From Bank", generateRandom(1000, 35000)));
        for (int i = 0; i < 20; i++)
            actionDeck.addCard(new PayTheBank("Pay The Bank", generateRandom(1000, 20000)));
        for (int i = 0; i < 3; i++)
            actionDeck.addCard(new CollectFromPlayer("Collect From Player", generateRandom(1000, 15000)));
        for (int i = 0; i < 2; i++)
            actionDeck.addCard(new PayThePlayer("Pay The Player", generateRandom(1000, 15000)));
        for (int i = 0; i < 3; i++)
            actionDeck.addCard(new CollectFromAll("Collect From All", generateRandom(1000, 13500)));
        for (int i = 0; i < 2; i++)
            actionDeck.addCard(new PayToAll("Pay To All", generateRandom(1000, 13500)));

        Collections.shuffle(actionDeck.getDeck());
    }

    public void generateBlueDeck() {

        blueDeck.addCard(new Lawsuit("Lawyer"));
        blueDeck.addCard(new SalaryTaxDue("Accountant"));
        blueDeck.addCard(new TipTheServer("Server"));
        blueDeck.addCard(new SkiAccident("Doctor"));
        blueDeck.addCard(new ComputerRepair("Computer Consultant"));
        blueDeck.addCard(new WorldCup("Athlete"));
        blueDeck.addCard(new F1Race("Racecar Driver"));

        Collections.shuffle(blueDeck.getDeck());
    }

    public void generateCareerDeck() {
        careerDeck.addCard(new CareerCard("Lawyer", generateRandom(5, 8), true));
        careerDeck.addCard(new CareerCard("Accountant", generateRandom(4, 7), true));
        careerDeck.addCard(new CareerCard("Computer Consultant", generateRandom(3, 7), true));
        careerDeck.addCard(new CareerCard("Doctor", generateRandom(5, 8), true));
        careerDeck.addCard(new CareerCard("Server", generateRandom(1, 4), false));
        careerDeck.addCard(new CareerCard("Racecar Driver", generateRandom(2, 8), false));
        careerDeck.addCard(new CareerCard("Athlete", generateRandom(1, 6), false));

        Collections.shuffle(careerDeck.getDeck());
    }

    public void generateSalaryDeck() {

        for (int i = 0; i < 10; i++)
            salaryDeck.addCard(new SalaryCard("Salary", generateRandom(1, 10) * 10000, generateRandom(1, 10) * 1000));

        Collections.shuffle(salaryDeck.getDeck());
    }

    public void generateHouseDeck() {
        for (int i = 0; i < 3; i++) {
            houseDeck.addCard(new HouseCard("Mansion", 1000000));
            houseDeck.addCard(new HouseCard("Apartment", 500000));
            houseDeck.addCard(new HouseCard("Cabin", 200000));
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getNumRetired() {
        return retired.length;
    }

    /**
     * This method generates number that ranges from 1000 to 10000, then returns it.
     * 
     * @return random generated number
     */

    public int generateRandom(int lb, int ub) {

        return (int) (Math.random() * (ub - lb + 1) + lb);
    }
}