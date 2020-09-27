package model;

public class CollegeCareerChoiceSpace extends MagentaSpace {

    public CollegeCareerChoiceSpace(String type) {
        super(type);
    }

    public CareerCard selectCareerCard(Deck careerDeck){
        return (CareerCard) careerDeck.drawCard();
    }

    public SalaryCard selectSalaryCard(Deck salaryDeck) {
        return (SalaryCard) salaryDeck.drawCard();
    }
}
