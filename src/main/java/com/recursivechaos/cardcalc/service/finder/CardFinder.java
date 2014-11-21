package com.recursivechaos.cardcalc.service.finder;

import java.util.List;
import java.util.Map;

import com.recursivechaos.cardcalc.domain.Person;
import com.recursivechaos.cardcalc.domain.Wallet;
import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * Provides ability to get cards grouped by objects
 * 
 * @author Andrew Bell
 *
 */
public interface CardFinder {

    /**
     * Returns all cards for all people provided
     * 
     * @param persons
     * @return List<Card> of all cards from persons
     */
    public List<Card> getAllCards(List<Person> persons);

    /**
     * Returns all Wallets, with their respective cards mapped to them
     * 
     * @param persons
     * @return Map<Wallet, List<Card>> containing all cards
     */
    public Map<Wallet, List<Card>> getCardsByWallet(List<Person> persons);

    /**
     * Returns all Persons with their cards mapped to them
     * 
     * @param persons
     * @return Map<Person, List<Card>> containing all cards
     */
    public Map<Person, List<Card>> getCardsByPerson(List<Person> persons);

}
