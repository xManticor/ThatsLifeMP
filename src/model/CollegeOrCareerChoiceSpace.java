package model;

public class CollegeOrCareerChoiceSpace extends MagentaSpace {

    public CollegeOrCareerChoiceSpace(String type) {
        super(type);
    }

    public CareerCard selectCareerCard(Deck careerDeck){
        return (CareerCard) careerDeck.drawCard();
    }

    public SalaryCard selectSalaryCard(Deck salaryDeck) {
        return (SalaryCard) salaryDeck.drawCard();
    }
}
