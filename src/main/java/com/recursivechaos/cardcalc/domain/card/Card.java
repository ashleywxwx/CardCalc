package com.recursivechaos.cardcalc.domain.card;

/**
 * 
 * A card carries a balance, and has in interest rate set by the
 * implementation's constructor.
 *
 * @author Andrew Bell
 */
public abstract class Card {

    private double balance;
    private double interestRate;

    public Card(double interestRate, double balance) {
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

}
