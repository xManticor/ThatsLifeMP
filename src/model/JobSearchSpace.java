package model;

public class JobSearchSpace extends MagentaSpace {

    public JobSearchSpace(String type) {

        super(type);
    }

    public CareerCard takeCareerCard(Deck careerDeck){
        return (CareerCard) careerDeck.drawCard();
    }

    public SalaryCard takeSalaryCard(Deck salaryDeck) {
        return (SalaryCard) salaryDeck.drawCard();
    }
}
