package model;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.Scanner;
import java.util.*;

public class Game {

    private Player[] players;
    private Player[] retired;
    private int numPlayers;
    private String pName;

    private Deck actionDeck = new Deck("Action Deck");
    private Deck blueDeck = new Deck("Blue Deck");
    private Deck careerDeck = new Deck("Career Deck");
    private Deck salaryDeck = new Deck("Salary Deck");
    private Deck houseDeck = new Deck("House Deck");

    private Path collegePath = generateCollegePath();
    private Path careerPath1 = generateCareerPath1();
    private Path careerPath2 = generateCareerPath2();
    private Path familyPath1 = generateFamilyPath1();
    private Path careerPath3 = generateCareerPath3();
    private Path familyPath2 = generateFamilyPath2();
    private Path changeCareerPath2 = generateChangeCareerPath2();
    private Path careerPath4 = generateCareerPath4();


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

    private Path generateCollegePath() {
        Path collegePath = new Path("College Path");
        collegePath.addSpace(new CollegeOrCareerChoiceSpace("College Career Choice"));
        for(int i = 0; i < 5; i++)
            collegePath.addSpace(new OrangeSpace("Orange Space"));
        collegePath.addSpace(new JobSearchSpace("Job Search Space"));

        return collegePath;
    }

    private Path generateCareerPath1() {
        Path careerPath1 = new Path("Career Path");
        careerPath1.addSpace(new PayRaise("Pay Raise"));
        careerPath1.addSpace(new OrangeSpace("Orange Space"));
        return careerPath1;
    }

    private Path generateCareerPath2() {
        Path careerPath2 = new Path("Career Path");
        careerPath2.addSpace(new OrangeSpace("Orange Space"));
        careerPath2.addSpace(new PayDay("Pay Day"));
        for( int i = 0; i < 3; i++)
            careerPath2.addSpace(new OrangeSpace("Orange Space"));
        careerPath2.addSpace(new PayDay("Pay Day"));
        for( int i = 0; i < 3; i++)
            careerPath2.addSpace(new OrangeSpace("Orange Space"));
        careerPath2.addSpace(new BlueSpace("Blue Space"));
        careerPath2.addSpace(new OrangeSpace("Orange Space"));
        careerPath2.addSpace(new WhichPathSpace("Which Path?"));
        return careerPath2;
    }

    private Path generateCareerPath3() {
        Path careerPath3 = new Path("Career Path 3");

        for(int i = 0; i < 3; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new BlueSpace("Blue Space"));
        careerPath3.addSpace(new JobSearchSpace("Job Search Space"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayDay("Pay Day"));
        for(int i = 0; i < 3; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayRaise("Pay Raise"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new BlueSpace("Blue Space"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayDay("Pay Day"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new HaveTwinSpace("Have a Twin!"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayDay("Pay Day"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new BlueSpace("Blue Space"));
        for(int i = 0; i < 2; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayRaise("Pay Raise"));
        for(int i = 0; i < 3; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new BlueSpace("Blue Space"));
        careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new PayDay("Pay Day"));
        for(int i = 0; i < 3; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new WhichPathSpace("Which Path?"));
        return careerPath3;
    }

    private Path generateChangeCareerPath2() {
        Path changeCareerPath2 = new Path("Change Career Path 2");
        changeCareerPath2.addSpace(new CareerChoice("Career Choice Space"));
        changeCareerPath2.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath2.addSpace(new BlueSpace("Blue Space"));
        for(int i = 0; i < 2; i++)
            changeCareerPath2.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath2.addSpace(new PayRaise("Pay Raise"));
        changeCareerPath2.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath2.addSpace(new PayDay("Pay Day"));
        changeCareerPath2.addSpace(new BlueSpace("Blue Space"));
        changeCareerPath2.addSpace(new OrangeSpace("Orange Space"));
        return changeCareerPath2;
    }

    private Path generateFamilyPath2() {

        Path familyPath2 = new Path("Family Path 2");

        familyPath2.addSpace(new GetMarriedSpace("Get Married"));
        for(int i = 0; i < 2; i++)
            familyPath2.addSpace(new OrangeSpace("Orange Space"));
        familyPath2.addSpace(new BlueSpace("Blue Space"));
        familyPath2.addSpace(new BuyHouseSpace("Buy A House"));
        for(int i = 0; i < 3; i++)
            familyPath2.addSpace(new OrangeSpace("Orange Space"));
        familyPath2.addSpace(new HaveBabySpace("Have A Baby"));
        familyPath2.addSpace(new OrangeSpace("Orange Space"));
        familyPath2.addSpace(new BlueSpace("Blue Space"));
        for(int i = 0; i < 3; i++)
            familyPath2.addSpace(new OrangeSpace("Orange Space"));
        return familyPath2;
    }

    private Path generateCareerPath4(){

        Path careerPath4 = new Path("Career Path 4");

        for(int i = 0; i < 2; i++)
            careerPath4.addSpace(new OrangeSpace("Orange Space"));
        careerPath4.addSpace(new PayDay("Pay Day"));
        for(int i = 0; i < 2; i++)
            careerPath4.addSpace(new OrangeSpace("Orange Space"));
        return careerPath4;
    }

    private Path generateFamilyPath1() {

        Path familyPath = new Path("Family Path 1");

        familyPath.addSpace(new GetMarriedSpace("Get Married Space"));
        for(int i = 0; i < 2; i++)
            familyPath.addSpace(new OrangeSpace("Orange Space"));
        familyPath.addSpace(new BuyHouseSpace("Buy a House Space"));
        for(int i = 0; i < 2; i++)
            familyPath.addSpace(new OrangeSpace("Orange Space"));
        familyPath.addSpace(new BlueSpace("Blue Space"));
        familyPath.addSpace(new OrangeSpace("Orange Space"));
        familyPath.addSpace(new HaveBabySpace("Have a Baby Space"));
        return familyPath;
    }


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