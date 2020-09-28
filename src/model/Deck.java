package model;

import java.util.*;

/**
 * The deck class. This class has the array list of cards.
 */
public class Deck {

  private String name;
  private ArrayList<Card> cards;

  /**
   * The deck constructor. This sets the name and the arraylist of cards.
   * @param name
   */
  public Deck(String name) {
    this.name = name;
    cards = new ArrayList<Card>();
  }

  /**
   * This method simply adds a card.
   * @param card the card to be added
   */
  public void addCard(Card card) {
    cards.add(card);
  }

  /**
   * This method simply returns the deck
   * @return the array list of card
   */
  public ArrayList<Card> getDeck() {
    return cards;
  }

  /**
   * A getter method, this returns the name.
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * This method simply gets the top card then deletes it.
   * @return the top card
   */
  public Card drawCard() {
    Card tempcard = cards.get(0);
    cards.remove(0);
    return tempcard;
  }

  /**
   * This method simply gets the  card that doesn't require a degree.
   * @return the card without degree.
   */
  public Card drawDegreeCard(){
    Card tempcard;
    for(int i = 0; i < cards.size(); i++) {
      if(!((CareerCard) cards.get(i)).isDegreeRequired()) {
        tempcard = cards.get(i); // Should not go here
         cards.remove(i);
        return tempcard;
      }
    }
    return cards.get(0);
  }
}