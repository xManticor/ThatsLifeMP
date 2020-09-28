package model;

/**
 * SalaryCard class that inherits Card parent class
 */
public class SalaryCard extends Card {
    protected String type = "Salary";
    protected int salary;
    protected int taxDue;

    /**
     * SalaryCard constructor that takes in a String, salary, and taxDue
     * @param name name of the Salary card
     * @param salary value of the salary card
     * @param taxDue taxdue of the salary card
     */
    public SalaryCard(String name, int salary, int taxDue) {
        super(name);
        this.taxDue = taxDue;
        this.salary = salary;
    }

    /**
     * Gets salary of the Card
     * @return salary
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Gets the tax due of the card
     * @return taxDue
     */
    public int getTaxDue() {
        return this.taxDue;
    }
}