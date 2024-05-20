package com.example.geektrust.entity;

public class Loan {
    private static final double PERCENTAGE_DENOMINATOR             = 100.0;
    private static final int NUMBER_OF_MONTHS_IN_A_YEAR            = 12;
    private final double principal;
    private final int tenure;
    private final double rateOfInterest;

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
