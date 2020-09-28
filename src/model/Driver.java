package model;

import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);

    System.out.println("Game Start");

    System.out.println("Enter number of players: ");
    int playernum = kb.nextInt();
    Game thatslife = new Game(playernum);
  }
}