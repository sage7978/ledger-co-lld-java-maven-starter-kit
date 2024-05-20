package com.example.geektrust.entity;

public class EMI implements Comparable<EMI>{
    private int emiPaid;
    private double lumpSum;

    public EMI(int emiPaid, double lumpSum) {
        this.emiPaid = emiPaid;
        this.lumpSum = lumpSum;
    }

    public int getEmiPaid() {
        return emiPaid;
    }

    public void setEmiPaid(int emiPaid) {
        this.emiPaid = emiPaid;
    }

    public double getLumpSum() {
        return lumpSum;
    }

    public void setLumpSum(double lumpSum) {
        this.lumpSum = lumpSum;
    }

    @Override
    public int compareTo(EMI o) {
        return emiPaid-o.emiPaid;
    }
}
