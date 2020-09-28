package model;

public class CareerCard extends Card {
    private String type = "Career";
    private boolean isDegreeRequired;
    protected int maxRaise;
    protected int raise;

    public CareerCard(String name, int maxRaise, boolean isDegreeRequired) {
        super(name);
        this.maxRaise = maxRaise;
        this.isDegreeRequired = isDegreeRequired;
    }

    public int getMaxRaise() {
        return this.maxRaise;
    }

    public int getRaise() {
        return this.raise;
    }

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

    @Override
    public String toString() {
        return this.name + " [" + ", " + this.maxRaise + "]";
    }
}