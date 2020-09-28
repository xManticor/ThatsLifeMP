package model;

import java.util.*;

public class Deck {

  private String name;
  private ArrayList<Card> cards;

  public Deck(String name) {
    this.name = name;
    cards = new ArrayList<Card>();
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public ArrayList<Card> getDeck() {
    return cards;
  }

  public String getName() {
    return name;
  }

  public Card drawCard() {
    Card tempcard = cards.get(0);
    cards.remove(0);
    return tempcard;
  }

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

  public Card draw2ndCard(){
    Card temp2card;
    temp2card = cards.get(1);
    cards.remove(1);
    return temp2card;
  }

  public Card drawTopCard () {
    return cards.get(0);
  }

  public String toString() {
    return "";
  }
}