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
    Card tempcard;
    tempcard = cards.get(0);
    cards.remove(0);
    return tempcard;
  }

  public Card draw2ndCard(){
    Card temp2card;
    temp2card = cards.get(1);
    cards.remove(1);
    return temp2card;
  }

  public String toString() {
    return "";
  }
}