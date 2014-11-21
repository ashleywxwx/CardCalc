package com.recursivechaos.cardcalc.service.finder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.recursivechaos.cardcalc.domain.Person;
import com.recursivechaos.cardcalc.domain.Wallet;
import com.recursivechaos.cardcalc.domain.card.Card;

/**
 * @author Andrew Bell
 *
 */
public class CardFinderImpl implements CardFinder {

    public List<Card> getAllCards(List<Person> persons) {
        List<Card> cards = new ArrayList<>();
        for (Person person : persons) {
            for (Wallet wallet : person.getWallets()) {
                for (Card card : wallet.getCards()) {
                    cards.add(card);
                }
            }
        }
        return cards;
    }

    public Map<Wallet, List<Card>> getCardsByWallet(List<Person> persons) {
        Map<Wallet, List<Card>> walletList = new HashMap<>();
        for (Person person : persons) {
            for (Wallet wallet : person.getWallets()) {
                walletList.put(wallet, wallet.getCards());
            }
        }
        return walletList;
    }

    public Map<Person, List<Card>> getCardsByPerson(List<Person> persons) {
        Map<Person, List<Card>> personList = new HashMap<>();
        for (Person person : persons) {
            List<Person> lonePerson = new ArrayList<>(Arrays.asList(person));
            personList.put(person, getAllCards(lonePerson));
        }
        return personList;
    }

}
