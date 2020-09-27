package model;

/**
 * Player class This class indicates the state and behaviour of the player.
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
   * This method basically returns/gets the name of the player.
   *
   * @return the name of the player
   */
  public Player(){
  }

  public String getName() {
    return this.name;
  }

  /**
   * Sets the name of the Player
   * @param name
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
   * This method basically returns/gets the career of the player.
   *
   * @return the amount of cash of the player
   */

  public CareerCard getCareer() {
    return this.career;
  }

  /**
   * This method basically returns/gets the salary of the player.
   *
   * @return the amount of salary of the player
   */

  public SalaryCard getSalary() {
    return this.salary;
  }

  public int getPlayerSalary() {
    return this.salary.salary;
  }

  /**
   * This method basically returns/gets the tax due of the player.
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

  public int getRaiseCounter() { // int for now

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

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

  public boolean hasCollegeDegree() {
    return collegeDegree;
  }

  public int getChildren() {
    return children;
  }

  public int getLoan() {
    return loan;
  }

  public void requestLoan(int multiplierLoan) {
    for(int i = 0; i < multiplierLoan; i++) addLoan();
    addCash(20000 * multiplierLoan);
  }

  public void payLoan(int multiplierLoan) {
    loan -= 25000 * multiplierLoan;
    payCash(25000 * multiplierLoan);
  }

  public HouseCard getHouse() {
    return this.house;
  }

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

  public void payCash(int amount) {
    this.cash -= amount;
  }

  public void setPath(Path path) {
    this.path = path;
    this.location = 0;
  }

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
   * This method basically adds the counter to the player's maximum raise.
   */

  public void addRaiseCounter() {
    this.raiseCounter++;
  }

  public void addLoan(){
    this.loan += 25000;
  }

  /**
   * This method basically returns/gets the tax due of the player.
   *
   * @return the amount of tax due of the player
   */

  public void setCareer(CareerCard career) { // int for now

    this.career = career;
  }

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

  public boolean isRetired() {
    return retired;
  }

  public boolean isMarried() {
    return married;
  }

  public void setMarried(boolean married) {
    this.married = married;
  }

  public void setRetired(boolean retired) {
    this.retired = retired;
  }

  public void setCollegeDegree(boolean collegeDegree) {
    this.collegeDegree = collegeDegree;
  }

  public Path getPath() {
    return path;
  }
}