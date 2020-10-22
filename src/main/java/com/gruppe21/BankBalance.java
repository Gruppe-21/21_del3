package com.gruppe21;

public class BankBalance {

    private int balance = 1000; // Player has 1000 as starting balance


    public int getBankBalance(){
        return balance;
    }

    public void setBankBalance(int balance){
        this.balance = balance;
    }

    // add value of parameter "amount" to current balance
    public int addBankBalance(int amount) {
        setBankBalance(getBankBalance() + amount);
        return balance;
    }

    // remove value of parameter "amount" from current balance
    // uses Math.abs to get the numerical value of int
    // balance cannot be of negative value
    public int removeBankBalance(int amount) {
        setBankBalance(getBankBalance() - Math.abs(amount));
        if (balance < 0){
            setBankBalance(0);
            return balance;
        } else {
            return balance;
        }
    }

}
