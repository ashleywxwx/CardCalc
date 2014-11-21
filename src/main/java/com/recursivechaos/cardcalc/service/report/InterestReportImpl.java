package com.recursivechaos.cardcalc.service.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.recursivechaos.cardcalc.domain.Person;
import com.recursivechaos.cardcalc.domain.Wallet;
import com.recursivechaos.cardcalc.domain.card.Card;
import com.recursivechaos.cardcalc.service.calculator.Calculator;
import com.recursivechaos.cardcalc.service.finder.CardFinder;

public class InterestReportImpl implements InterestReport {

    List<Person> persons = new ArrayList<>();
    Calculator calc;
    CardFinder finder;

    public InterestReportImpl(Person person, Calculator calc, CardFinder finder) {
        this.persons.add(person);
        this.calc = calc;
        this.finder = finder;
    }

    public InterestReportImpl(List<Person> persons, Calculator calc, CardFinder finder) {
        this.persons = persons;
        this.calc = calc;
        this.finder = finder;
    }

    public Double getTotalSimpleInterest() {
        Double sumInt = 0.0;

        for (Card card : finder.getAllCards(persons)) {
            sumInt += calc.getSimpleInterest(card); // obj will be card
        }

        return sumInt;
    }

    public Map<Card, Double> getInterestPerCard() {
        Map<Card, Double> cardInterest = new HashMap<>();

        for (Card card : finder.getAllCards(persons)) {
            cardInterest.put(card, calc.getSimpleInterest(card));
        }

        return cardInterest;
    }

    public Map<Wallet, Double> getInterestPerWallet() {
        Map<Wallet, Double> walletInterest = new HashMap<>();

        for (Entry<Wallet, List<Card>> entry : finder.getCardsByWallet(persons).entrySet()) {
            walletInterest.put(entry.getKey(), calc.getSimpleInterest(entry.getValue()));
        }

        return walletInterest;
    }

    public Map<Person, Double> getInterestPerPerson() {
        Map<Person, Double> personInterest = new HashMap<>();

        for (Entry<Person, List<Card>> entry : finder.getCardsByPerson(persons).entrySet()) {
            personInterest.put(entry.getKey(), calc.getSimpleInterest(entry.getValue()));
        }

        return personInterest;
    }
}
