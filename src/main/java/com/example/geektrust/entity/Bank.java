package com.example.geektrust.entity;

public class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public boolean equalsName(String bankName){
        return bankName.equalsIgnoreCase(name);
    }
}
