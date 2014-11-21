package com.recursivechaos.cardcalc.service.calculator;

import java.util.List;

import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * Provides the math to perform interest calculations on the Card
 * 
 * @author Andrew Bell
 *
 */
public interface Calculator {

    /**
     * Get simple interest for just one card.
     * 
     * @param card
     * @return Total simple interest for card
     */
    public Double getSimpleInterest(Card card);

    /**
     * Get simple interest for many cards
     * 
     * @param cards
     * @return Combined total simple interest
     */
    public Double getSimpleInterest(List<Card> cards);

}
