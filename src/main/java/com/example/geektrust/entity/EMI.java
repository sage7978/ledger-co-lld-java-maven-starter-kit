package com.example.geektrust.entity;

public class EMI implements Comparable<EMI>{
    public int emiPaid;
    public double lumpSum;

    public EMI(int emiPaid, double lumpSum) {
        this.emiPaid = emiPaid;
        this.lumpSum = lumpSum;
    }

    @Override
    public int compareTo(EMI o) {
        return emiPaid-o.emiPaid;
    }
}
