package model;

import java.util.*;

import javax.swing.Action;

public class Driver {

  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);

    System.out.println("Game Start");

    // TO DO:
    // scanf for num of players

    System.out.println("Enter number of players: ");
    int playernum = kb.nextInt();
    Game thatslife = new Game(playernum);

    Deck actionDeck = thatslife.generateActionDeck();
    Deck blueDeck = thatslife.generateBlueDeck();
    Deck careerDeck = thatslife.generateCareerDeck();
    Deck salaryDeck = thatslife.generateSalaryDeck();
    Deck houseDeck = thatslife.generateHouseDeck();

    // if(actionDeck.)
    ActionCard ac = (ActionCard) actionDeck.drawCard();
    BlueCard bc = (BlueCard) blueDeck.drawCard();
    CareerCard cc = (CareerCard) careerDeck.drawCard();
    SalaryCard sc = (SalaryCard) salaryDeck.drawCard();
    HouseCard hc = (HouseCard) houseDeck.drawCard();

    System.out.println(ac.getName());
    System.out.println(ac.getAmount());
    System.out.println(bc.getName());
    // System.out.println(bc.getAmount());
    System.out.println(cc.getName());
    System.out.println(cc.getMaxRaise());
    System.out.println(sc.getName());
    // System.out.println(sc.getAmount());
    System.out.println(hc.getName());
    System.out.println(hc.getValue());

    /*
     * // Career career[0] = new CareerCard("Lawyer", 8); career[1] = new
     * CareerCard("Accountant", 7); career[2] = new CareerCard("Athlete", 6);
     * players[0].setCareer(career[0]); players[1].setCareer(career[1]);
     * players[2].setCareer(career[2]);
     * 
     * // Blues blues[0] = new ComputerRepair("Computer Consultant"); blues[1] = new
     * Lawsuit("Lawyer"); blues[2] = new SalaryTaxDue("Accountant");
     * blues[0].blueCardCondition(players[0], players, blues[0].getName()); // wait
     * brb brb ulet baba lang ako baso blues[1].blueCardCondition(players[1],
     * players, blues[1].getName()); blues[2].blueCardCondition(players[2], players,
     * blues[2].getName());
     * 
     * // Houses houses[0] = new HouseCard("Apartment", 150000); houses[1] = new
     * HouseCard("Cabin", 120000); houses[2] = new HouseCard("Bungalow", 135000);
     * players[0].setHouse(houses[0]); players[1].setHouse(houses[1]);
     * players[2].setHouse(houses[2]);
     * 
     * // Salary // Must be random generated values of cards salary[0] = new
     * SalaryCard("25000", 25000, 1500); salary[1] = new SalaryCard("17500", 17500,
     * 1150); salary[2] = new SalaryCard("21500", 21500, 1300);
     * players[0].setSalary(salary[0]); players[1].setSalary(salary[1]);
     * players[2].setSalary(salary[2]);
     * 
     * System.out.println(salary[0].getSalary()); //
     * System.out.println(salary[1].getSalary()); //
     * System.out.println(salary[2].getSalary());
     * 
     * //players[0].addCash(salary[0].getSalary());
     * //players[1].removeCash(salary[1].getTaxDue());
     */
  }
}