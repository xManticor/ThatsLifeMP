package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The game class, this class contains all the generations of the cards, players and spaces.
 */
public class Game {

    private ArrayList<Player> players;
    private ArrayList<Player> retired;

    private Deck actionDeck = new Deck("Action Deck");
    private Deck blueDeck = new Deck("Blue Deck");
    private Deck careerDeck = new Deck("Career Deck");
    private Deck salaryDeck = new Deck("Salary Deck");
    private Deck houseDeck = new Deck("House Deck");

    private Path collegePath1;
    private Path careerPath1;

    int turn = 0;

    /**
     * Game constructor, this is where player, retired players arrays, cards and paths are created.
     *
     * @param numPlayers number of players
     */
    public Game(int numPlayers) {
        this.players = new ArrayList<>();
        this.retired = new ArrayList<>();

        // Generates players
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }

        //Generates all decks
        generateActionDeck();
        generateBlueDeck();
        generateCareerDeck();
        generateHouseDeck();
        generateSalaryDeck();
        generatePaths();
    }

    /**
     * The method of generated paths.
     */
    private void generatePaths() {
        Path careerPath4 = generateCareerPath4();
        Path familyPath2 = generateFamilyPath2(careerPath4);
        Path changeCareerPath2 = generateChangeCareerPath2(careerPath4);
        Path careerPath3 = generateCareerPath3(familyPath2, changeCareerPath2);
        Path familyPath1 = generateFamilyPath1(careerPath3);
        Path changeCareerPath1 = generateChangeCareerPath1(careerPath3);
        Path careerPath2 = generateCareerPath2(familyPath1, changeCareerPath1);
        collegePath1 = generateCollegePath1(careerPath2);
        careerPath1 = generateCareerPath1(careerPath2);
    }

    /**
     * This methods generate the college path 1
     * @param careerPath2 the connector
     * @return Path
     */
    private Path generateCollegePath1(Path careerPath2) {
        Path collegePath = new Path("College Path");
        collegePath.addSpace(new OrangeSpace("Start College"));
        collegePath.addSpace(new CollegeCareerChoiceSpace("College Career Choice"));
        for(int i = 0; i < 5; i++)
            collegePath.addSpace(new OrangeSpace("Orange Space"));
        collegePath.addSpace(new GraduateSpace("Graduation", careerPath2));

        return collegePath;
    }
    /**
     * This methods generate the career path 1
     * @param careerPath2 the connector
     * @return Path
     */
    private Path generateCareerPath1(Path careerPath2) {
        Path careerPath1 = new Path("Career Path");
        careerPath1.addSpace(new OrangeSpace("Start Career"));
        careerPath1.addSpace(new PayRaise("Pay Raise"));
        careerPath1.addSpace(new OrangeSpace("Orange Space", careerPath2));
        return careerPath1;
    }
    /**
     * This methods generate the college path 1
     * @param familyPath1 the connector
     * @param changeCareerPath1 2nd connector
     * @return Path
     */
    private Path generateCareerPath2(Path familyPath1, Path changeCareerPath1) {
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
        careerPath2.addSpace(new WhichPathSpace("Which Path?", familyPath1, changeCareerPath1));
        return careerPath2;
    }
    /**
     * This methods generate the career path 3
     * @param familyPath2 the connector
     * @param changeCareerPath2 2nd connector
     * @return Path
     */
    private Path generateCareerPath3(Path familyPath2, Path changeCareerPath2) {
        Path careerPath3 = new Path("Career Path 3");

        for(int i = 0; i < 3; i++)
            careerPath3.addSpace(new OrangeSpace("Orange Space"));
        careerPath3.addSpace(new BlueSpace("Blue Space"));
        careerPath3.addSpace(new PayDay("Pay Day"));
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
        careerPath3.addSpace(new HaveTwinSpace("Have A Twin"));
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
        careerPath3.addSpace(new WhichPathSpace("Which Path?", familyPath2, changeCareerPath2));
        return careerPath3;
    }
    /**
     * This methods generate the change career path 1
     * @param careerPath3 the connector
     * @return Path
     */
    private Path generateChangeCareerPath1(Path careerPath3){
        Path changeCareerPath1 = new Path("Change Career Path 1");

        changeCareerPath1.addSpace(new CareerChoice("Career Choice Space"));
        for(int i = 0; i < 2; i++)
            changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new PayDay("Pay Day"));
        for(int i = 0; i < 2; i++)
            changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new BlueSpace("Blue Space"));
        for(int i = 0; i < 2; i++)
            changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new PayDay("Pay  Day"));
        for(int i = 0; i < 2; i++)
            changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new BlueSpace("Blue Space"));
        changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new PayDay("Pay  Day"));
        for(int i = 0; i < 2; i++)
            changeCareerPath1.addSpace(new OrangeSpace("Orange Space"));
        changeCareerPath1.addSpace(new PayRaise("Pay Raise"));
        changeCareerPath1.addSpace(new OrangeSpace("Orange Space", careerPath3));

        return changeCareerPath1;
    }
    /**
     * This methods generate the career path 2
     * @param careerPath4 the connector
     * @return Path
     */
    private Path generateChangeCareerPath2(Path careerPath4) {
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
        changeCareerPath2.addSpace(new OrangeSpace("Orange Space", careerPath4));
        return changeCareerPath2;
    }
    /**
     * This methods generate the family path 2
     * @param careerPath4 the connector
     * @return Path
     */
    private Path generateFamilyPath2(Path careerPath4) {

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
        for(int i = 0; i < 2; i++)
            familyPath2.addSpace(new OrangeSpace("Orange Space"));
        familyPath2.addSpace(new OrangeSpace("Orange Space", careerPath4));
        return familyPath2;
    }
    /**
     * This methods generate the career path 4
     * @return Path
     */
    private Path generateCareerPath4(){

        Path careerPath4 = new Path("Career Path 4");

        for(int i = 0; i < 2; i++)
            careerPath4.addSpace(new OrangeSpace("Orange Space"));
        careerPath4.addSpace(new PayDay("Pay Day"));
        for(int i = 0; i < 2; i++)
            careerPath4.addSpace(new OrangeSpace("Orange Space"));
        careerPath4.addSpace(new RetirementSpace("Retirement Space"));
        return careerPath4;
    }
    /**
     * This methods generate the family path 1
     * @param careerPath3 the connector
     * @return Path
     */
    private Path generateFamilyPath1(Path careerPath3) {

        Path familyPath = new Path("Family Path 1");

        familyPath.addSpace(new GetMarriedSpace("Get Married"));
        for(int i = 0; i < 2; i++)
            familyPath.addSpace(new OrangeSpace("Orange Space"));
        familyPath.addSpace(new BuyHouseSpace("Buy a House"));
        for(int i = 0; i < 2; i++)
            familyPath.addSpace(new OrangeSpace("Orange Space"));
        familyPath.addSpace(new BlueSpace("Blue Space"));
        familyPath.addSpace(new HaveBabySpace("Have A Baby"));
        familyPath.addSpace(new OrangeSpace("Orange Space", careerPath3));
        return familyPath;
    }

    /**
     * This method generates all the action cards
     */
    public void generateActionDeck() {

        for (int i = 0; i < 20; i++) // 20
            actionDeck.addCard(new CollectFromBank("Collect From Bank", generateRandom(25000, 80000)));
        for (int i = 0; i < 20; i++) //20
            actionDeck.addCard(new PayTheBank("Pay The Bank", generateRandom(1000, 20000)));
        for (int i = 0; i < 3; i++) // 3
            actionDeck.addCard(new CollectFromPlayer("Collect From Player", generateRandom(1000, 15000)));
        for (int i = 0; i < 2; i++) //2
            actionDeck.addCard(new PayThePlayer("Pay The Player", generateRandom(1000, 15000)));
        for (int i = 0; i < 3; i++) //3
            actionDeck.addCard(new CollectFromAll("Collect From All", generateRandom(1000, 13500)));
        for (int i = 0; i < 2; i++) // 2
            actionDeck.addCard(new PayToAll("Pay To All", generateRandom(1000, 13500)));

        Collections.shuffle(actionDeck.getDeck());
    }
    /**
     * This method generates all the blue cards
     */
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
    /**
     * This method generates all the career cards
     */
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
    /**
     * This method generates all the salary cards
     */
    public void generateSalaryDeck() {

        for (int i = 0; i < 10; i++)
            salaryDeck.addCard(new SalaryCard("Salary", generateRandom(1, 10) * 10000, generateRandom(1, 10) * 1000));

        Collections.shuffle(salaryDeck.getDeck());
    }
    /**
     * This method generates all the house cards
     */
    public void generateHouseDeck() {
        for (int i = 0; i < 3; i++) {
            houseDeck.addCard(new HouseCard("Mansion", 100000));
            houseDeck.addCard(new HouseCard("Apartment", 50000));
            houseDeck.addCard(new HouseCard("Cabin", 20000));
        }
    }

    /**
     * This method sets the turn
     * @param turn the turn
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * This method returns all the players in array
     * @return Player[]
     */
    public Player[] getPlayers() {
        return players.toArray(new Player[0]);
    }
    /**
     * This method returns all the retired players in array
     * @return Player[]
     */
    public Player[] getRetiredPlayers() {
        return retired.toArray(new Player[0]);
    }

    /**
     * This method returns the number of players
     * @return number of players
     */
    public int getNumPlayers() {
        return players.size();
    }
    /**
     * This method returns the number of retired players
     * @return number of retired players
     */
    public int getNumRetired() {
        return retired.size();
    }

    /**
     * This method gets the career path 1
     * @return Path
     */
    public Path getCareerPath1() {
        return careerPath1;
    } /**
     * This method gets the college path 1
     * @return Path
     */

    public Path getCollegePath1() {
        return collegePath1;
    }

    /**
     * This returns the turn
     * @return turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * This player gets the current player
     * @return Player
     */
    public Player getCurrentPlayer() {
        if(turn >= 0 && turn < getNumPlayers()) {
            return players.get(turn);
        } else {
            return null;
        }
    }
    /**
     * This player gets the other other players
     * @return other players
     */
    public Player[] getOtherPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        for(Player otherPlayer : getPlayers()) {
            if(!getCurrentPlayer().equals(otherPlayer)) {
                players.add(otherPlayer);
            }
        }
        return players.toArray(new Player[0]);
    }

    /**
     * This method returns the house deck
     * @return Deck
     */
    public Deck getHouseDeck() {
        return houseDeck;
    }
    /**
     * This method returns the career deck
     * @return Deck
     */
    public Deck getCareerDeck() {
        return careerDeck;
    }
    /**
     * This method returns the blue deck
     * @return Deck
     */
    public Deck getBlueDeck() {
        return blueDeck;
    }
    /**
     * This method returns the action deck
     * @return Deck
     */
    public Deck getActionDeck() {
        return actionDeck;
    }
    /**
     * This method returns the salary deck
     * @return Deck
     */
    public Deck getSalaryDeck() {
        return salaryDeck;
    }



    /**
     * This method generates number that ranges from 1000 to 10000, then returns it.
     * 
     * @return random generated number
     */

    public int generateRandom(int lb, int ub) {
        return (int) (Math.random() * (ub - lb + 1) + lb);
    }
    /**
     * This method removes the player then adds it to the list of retired players.
     *
     */
    public void retirePlayer(Player player) {
        players.remove(player);
        retired.add(player);
    }
}