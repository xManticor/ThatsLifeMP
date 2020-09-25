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
  private SalaryCard salary;
  private CareerCard career;
  private HouseCard house;
  private Path path;
  private int loan;
  private boolean married = false;
  private boolean retired = false;

  /**
   * This method basically returns/gets the name of the player.
   *
   * @return the name of the player
   */

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

  public String getCareer() {

    return career.getName();
  }

  /**
   * This method basically returns/gets the salary of the player.
   *
   * @return the amount of salary of the player
   */

  public int getSalary() { // int for now

    return this.salary.getSalary();
  }

  /**
   * This method basically returns/gets the tax due of the player.
   *
   * @return the amount of tax due of the player
   */

  public int getTaxDue() { // int for now

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

  public Path getPath() {
    return path;
  }
}