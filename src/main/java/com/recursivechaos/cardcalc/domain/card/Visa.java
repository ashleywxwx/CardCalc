package com.recursivechaos.cardcalc.domain.card;

/**
 * @author Andrew Bell
 *
 */
public class Visa extends Card {

    private static double INTEREST_RATE = 10;

    public Visa(double startingBalance) {
        super(INTEREST_RATE, startingBalance);
    }

}
