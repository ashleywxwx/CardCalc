package com.recursivechaos.cardcalc.domain.card;

/**
 * @author Andrew Bell
 *
 */
public class Discover extends Card {

    private static double INTEREST_RATE = 1;

    public Discover(double balance) {
        super(INTEREST_RATE, balance);
    }

}
