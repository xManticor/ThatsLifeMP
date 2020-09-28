package model;

/**
 * Player class this class indicates the state and behaviour of the player.
 * 
 */
public class Player {
  private String name;
  private int cash = 200000;
  private int children = 0;
  private int raiseCounter = 0;
  private boolean collegeDegree = false;
  private SalaryCard salary;
  private CareerCard career;
  private HouseCard house;
  private Path path;
  private int location = 0;
  private int loan = 0;
  private boolean married = false;
  private boolean retired = false;

  /**
   * Player constructor
   */
  public Player(){
  }

  /**
   * Gets the player name
   * @return name of player
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name of the Player
   * @param name name to be set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method basically returns/gets the cash of the player.
   *
   * @return the amount of cash of the player
   */
  public int getCash() {
    return this.cash;
  }

  /**
   * This method returns/gets the career card of the player.
   *
   * @return the amount of cash of the player
   */
  public CareerCard getCareer() {
    return this.career;
  }

  /**
   * This method basically returns/gets the salary card of the player.
   *
   * @return the amount of salary of the player
   */
  public SalaryCard getSalary() {
    return this.salary;
  }

  /**
   * Gets the salary amount of the player's salary card
   * @return
   */
  public int getPlayerSalary() {
    return this.salary.salary;
  }

  /**
   * This method returns/gets the tax due of the player.
   *
   * @return the amount of tax due of the player
   */
  public int getTaxDue() {
    return this.salary.taxDue;
  }

  /**
   * This method basically returns/gets the current raise counter of the player.
   *
   * @return the amount of tax due of the player
   */
  public int getRaiseCounter() {

    return this.raiseCounter;
  }

  /**
   * This method basically returns/gets the max raise of the player.
   *
   * @return the amount of tax due of the player
   */
  public int getMaxRaise() { // int for now

    return this.career.maxRaise;
  }

  /**
   * Gets the location of the player
   * @return location
   */
  public int getLocation() {
    return location;
  }

  /**
   * Sets the location of the player
   * @param location index to set the player location
   */
  public void setLocation(int location) {
    this.location = location;
  }

  /**
   * Checks if player has college degree
   * @return collegeDegree
   */
  public boolean hasCollegeDegree() {
    return collegeDegree;
  }

  /**
   * Gets the number of children of the player
   * @return children
   */
  public int getChildren() {
    return children;
  }

  /**
   * Gets the loan of the player
   * @return loan
   */
  public int getLoan() {
    return loan;
  }

  /**
   * Method for paying loan
   * @param multiplierLoan loan multiplier
   */
  public void payLoan(int multiplierLoan) {
    loan -= 25000 * multiplierLoan;
    payCash(25000 * multiplierLoan);
  }

  /**
   * Gets the HouseCard of the player
   * @return house
   */
  public HouseCard getHouse() {
    return this.house;
  }

  /**
   * Sets the house of the player
   * @param house HouseCard to be set on the player
   */
  public void setHouse(HouseCard house) {
    this.house = house;
  }

  /**
   * This method basically gets the amount to be added to the cash of the player.
   *
   * @param amount refers the amount to be added to the player's cash.
   */
  public void addCash(int amount) {
    this.cash += amount;
  }

  /**
   * Method for the player to pay
   * @param amount amount to be paid
   */
  public void payCash(int amount) {
    this.cash -= amount;
  }

  /**
   * Sets the path of the player
   * @param path path to be set on the player
   */
  public void setPath(Path path) {
    if(this.path != null) {
      for(Space space : this.path.getSpaces()) {
        space.removePlayer(this);
      }
    }
    this.path = path;
    this.location = 0;
  }

  /**
   * Adds a child to the player
   * @param child number of child to be added to the player
   */
  public void addChild(int child){
    children += child;
  }

  /**
   * This method basically gets the amount to be added to the salary of the
   * player.
   *
   * @param amount refers the amount to be added to the player's salary.
   */
  public void addSalary(int amount) {
    this.salary.salary += amount;
  }

  /**
   * This method basically gets the amount to be added to the tax due of the
   * player.
   *
   * @param amount refers the amount to be added to the player's tax due.
   */
  public void addTaxDue(int amount) {
    this.salary.taxDue += amount;
  }


  /**
   * This method basically adds the counter to the player's raise.
   */
  public void addRaiseCounter() {
    this.raiseCounter++;
  }

  /**
   * Adds loan to the player loan
   */
  public void addLoan(){
    this.loan += 25000;
  }

  /**
   * This method sets the career of the player with a Career Card
   *
   */
  public void setCareer(CareerCard career) { // int for now

    this.career = career;
  }

  /**
   * Sets the salary card of the player with the given Salary Card
   * @param salary SalaryCard to be set on the player
   */
  public void setSalary(SalaryCard salary) {
    this.salary = salary;
  }

  /**
   * This method basically gets the amount to be subtracted the cash of the
   * player.
   *
   * @param amount refers the amount to be subtracted to the player's cash.
   */
  public void removeCash(int amount) {
    this.cash -= amount;
  }

  /**
   * Checks if player is married
   * @return married
   */
  public boolean isMarried() {
    return married;
  }

  /**
   * Sets the player if married
   * @param married sets true/false married
   */
  public void setMarried(boolean married) {
    this.married = married;
  }

  /**
   * Sets the player to retire
   * @param retired sets to true/false retired
   */
  public void setRetired(boolean retired) {
    this.retired = retired;
  }

  /**
   * Sets the player to have a college degree
   * @param collegeDegree sets to true/false collegeDegree
   */
  public void setCollegeDegree(boolean collegeDegree) {
    this.collegeDegree = collegeDegree;
  }

  /**
   * Gets the path of the player
   * @return path
   */
  public Path getPath() {
    return path;
  }
}