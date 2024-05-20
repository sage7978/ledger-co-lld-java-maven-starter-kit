package com.example.geektrust.entity;

import java.util.HashMap;

public class BorrowerEntries {
    private static BorrowerEntries ins = null;
    private final HashMap<String, Borrower> hashMap;

    private BorrowerEntries() {
        this.hashMap = new HashMap<>();
    }

    public static BorrowerEntries getInstance(){
        if(ins == null){
            ins = new BorrowerEntries();
        }
        return ins;
    }

    public Borrower fetchBorrower(String name){
        if(!hashMap.containsKey(name)){
            hashMap.put(name, new Borrower(name));
        }
        return hashMap.get(name);
    }
}
