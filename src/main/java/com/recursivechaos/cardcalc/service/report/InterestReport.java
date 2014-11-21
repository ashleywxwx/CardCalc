package com.recursivechaos.cardcalc.service.report;

import java.util.Map;

import com.recursivechaos.cardcalc.domain.Person;
import com.recursivechaos.cardcalc.domain.Wallet;
import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * Provides interface for consumers of the Interest Report
 * 
 * @author abell
 *
 */
public interface InterestReport {

    /**
     * Returns the total interest for all persons
     * 
     * @return total simple interest
     */
    public Double getTotalSimpleInterest();

    /**
     * Returns a Map of each card and it's respective interest
     * 
     * @return
     */
    public Map<Card, Double> getInterestPerCard();

    /**
     * Returns a Map of each Wallet and it's respective interest
     * 
     * @return
     */
    public Map<Wallet, Double> getInterestPerWallet();

    /**
     * Returns a Map of each Person and it's respective interest
     * 
     * @return
     */
    public Map<Person, Double> getInterestPerPerson();

}
