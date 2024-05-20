package com.example.geektrust.entity;

public class Loan {
    private double principal;
    private int tenure;
    private double interest;

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

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Loan(double principal, int tenure, double interest) {
        this.principal = principal;
        this.tenure = tenure;
        this.interest = interest;
    }
}
