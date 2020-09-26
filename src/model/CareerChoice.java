package model;

public class CareerChoice extends MagentaSpace
{
    public CareerChoice(String type)
    {
        super(type);
    }

    public void displayCareerCard(Deck careerDeck)
    {
        System.out.println(careerDeck.getDeck().get(0));
    }
}