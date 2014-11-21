package com.recursivechaos.cardcalc.service.calculator;

import java.util.List;

import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * @author Andrew Bell
 *
 */
public class CalculatorImpl implements Calculator {

    private static int PERIOD = 1;

    public Double getSimpleInterest(Card card) {
        double interest = 0;
        interest = (card.getBalance() * card.getInterestRate() * PERIOD) / 100;
        return interest;
    }

    public Double getSimpleInterest(List<Card> cards) {
        double interest = 0;
        for (Card card : cards) {
            interest += getSimpleInterest(card);
        }
        return interest;
    }

}
