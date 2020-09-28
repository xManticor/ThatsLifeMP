package model;
/**
 *  CareerCard card class, a class under Card class, this class indicates all the state and behaviour of the Career Card.
 *
 */
public class CareerCard extends Card {
    private String type = "Career";
    private boolean isDegreeRequired;
    protected int maxRaise;
    protected int raise;
    /**
     * This is an CareerCard standard constructor that accepts a String as a name that is to be assigned to the CareerCard.
     * @param name the name of the Career Card to be assigned, also the name inherited from Card class.
     * @param maxRaise the maximum raise to be assigned in the career card.
     * @param isDegreeRequired the requried degree to be assigned to the career.
     */
    public CareerCard(String name, int maxRaise, boolean isDegreeRequired) {
        super(name);
        this.maxRaise = maxRaise;
        this.isDegreeRequired = isDegreeRequired;
    }
    /**
     * A getter method. This method simply returns the maximum raise of the career card.
     * @return the maximum raise of the Card.
     */
    public int getMaxRaise() {
        return this.maxRaise;
    }
    /**
     * A getter method. This method simply returns the  raise of the career card.
     * @return the raise of the Card.
     */
    public int getRaise() {
        return this.raise;
    }

    /**
     * This method checks whether the career required a degree.
     * @return boolean
     */
    public boolean isDegreeRequired() {
        if (this.name.equals("Lawyer"))
            this.isDegreeRequired = true;

        if (this.name.equals("Accountant"))
            this.isDegreeRequired = true;

        if (this.name.equals("Computer Consultant"))
            this.isDegreeRequired = true;

        if (this.name.equals("Doctor"))
            this.isDegreeRequired = true;

        if (this.name.equals("Server"))
            this.isDegreeRequired = false;

        if (this.name.equals("Racecar Driver"))
            this.isDegreeRequired = false;

        if (this.name.equals("Athlete"))
            this.isDegreeRequired = false;

        return this.isDegreeRequired;
    }
}