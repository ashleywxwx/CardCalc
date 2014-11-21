package com.recursivechaos.cardcalc.domain;

import java.util.ArrayList;
import java.util.List;

import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * A wallet holds cards.
 * 
 * @author Andrew Bell
 *
 */
public class Wallet {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
