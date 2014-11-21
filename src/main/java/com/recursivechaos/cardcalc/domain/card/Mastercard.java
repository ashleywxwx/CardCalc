package com.recursivechaos.cardcalc.domain.card;

/**
 * @author Andrew Bell
 *
 */
public class Mastercard extends Card {

    private static double INTEREST_RATE = 5;

    public Mastercard(double balance) {
        super(INTEREST_RATE, balance);
    }

}
