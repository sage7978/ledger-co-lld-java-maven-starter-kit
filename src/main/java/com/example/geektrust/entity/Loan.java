package com.example.geektrust.entity;

public class Loan {
    private static double PERCENTAGE_DENOMINATOR             = 100.0;
    private static int NUMBER_OF_MONTHS_IN_A_YEAR            = 12;
    private double principal;
    private int tenure;
    private double rateOfInterest;

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Loan(double principal, int tenure, double rateOfInterest) {
        this.principal = principal;
        this.tenure = tenure;
        this.rateOfInterest = rateOfInterest;
    }

    public double getInterest(){
        return (principal * rateOfInterest * tenure) / PERCENTAGE_DENOMINATOR;
    }

    public int getTenureInMonths() {
        return NUMBER_OF_MONTHS_IN_A_YEAR * tenure;
    }

    public int getMonthlyEMI(){
        return (int)Math.ceil(getTotalAmount() / getTenureInMonths());
    }

    public double getTotalAmount(){
        return principal + getInterest();
    }
}
