package model;

public class CareerCard extends Card {
    private String type = "Career";
    private boolean isDegreeRequired;
    int maxRaise;
    int raise;

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
        if (this.name == "Lawyer")
            this.isDegreeRequired = true;

        if (this.name == "Accountant")
            this.isDegreeRequired = true;

        if (this.name == "Computer Consultant")
            this.isDegreeRequired = true;

        if (this.name == "Doctor")
            this.isDegreeRequired = true;

        if (this.name == "Server")
            this.isDegreeRequired = false;

        if (this.name == "Racecar Driver")
            this.isDegreeRequired = false;

        if (this.name == "Athlete")
            this.isDegreeRequired = false;

        return this.isDegreeRequired;
    }

    @Override
    public String toString() {
        return this.name + " [" + ", " + this.maxRaise + "]";
    }
}