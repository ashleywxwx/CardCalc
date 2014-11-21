package com.recursivechaos.cardcalc.test.service;

import com.recursivechaos.cardcalc.domain.Person;
import com.recursivechaos.cardcalc.domain.Wallet;
import com.recursivechaos.cardcalc.domain.card.Card;
import com.recursivechaos.cardcalc.domain.card.Discover;
import com.recursivechaos.cardcalc.domain.card.Mastercard;
import com.recursivechaos.cardcalc.domain.card.Visa;
import com.recursivechaos.cardcalc.service.calculator.Calculator;
import com.recursivechaos.cardcalc.service.calculator.CalculatorImpl;
import com.recursivechaos.cardcalc.service.finder.CardFinder;
import com.recursivechaos.cardcalc.service.finder.CardFinderImpl;
import com.recursivechaos.cardcalc.service.report.InterestReport;
import com.recursivechaos.cardcalc.service.report.InterestReportImpl;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrew Bell
 *
 */
public class InterestReportTest {

    static double START_BAL = 100.0;
    static double ERR_MARG = .01;

    Calculator intCalc = new CalculatorImpl();
    CardFinder finder = new CardFinderImpl();

    /**
     * 1 person has 1 wallet and 3 cards (1 Visa, 1 MC 1 Discover) Each Card has
     * a balance of $100 calculate the total interest(simple interest) for this
     * person and per card.
     */
    @Test
    public void multipleCardScenario() {
        // Build test data
        Person personA = new Person();
        Wallet walletA = new Wallet();

        Card cardA = new Visa(START_BAL);
        Card cardB = new Mastercard(START_BAL);
        Card cardC = new Discover(START_BAL);

        walletA.addCard(cardA);
        walletA.addCard(cardB);
        walletA.addCard(cardC);

        personA.addWallet(walletA);

        // Create service
        InterestReport report = new InterestReportImpl(personA, intCalc, finder);

        // Total Interest
        Double totalInterest = report.getTotalSimpleInterest();
        assertEquals(16, totalInterest, ERR_MARG);

        // Interest Per Card
        Map<Card, Double> cardInterest = report.getInterestPerCard();
        assertEquals(10, cardInterest.get(cardA), ERR_MARG);
        assertEquals(5, cardInterest.get(cardB), ERR_MARG);
        assertEquals(1, cardInterest.get(cardC), ERR_MARG);
    }

    /**
     * 1 person has 2 wallets Wallet 1 has a Visa and Discover , wallet 2 a MC
     * each card has $100 balance calculate the total interest(simple interest)
     * for this person and interest per wallet
     */
    @Test
    public void multipleWalletScenario() {
        Person personA = new Person();
        Wallet walletA = new Wallet();
        Wallet walletB = new Wallet();

        Card cardA = new Visa(START_BAL);
        Card cardB = new Discover(START_BAL);

        walletA.addCard(cardA);
        walletA.addCard(cardB);

        Card cardC = new Mastercard(START_BAL);
        Card cardD = new Mastercard(START_BAL);

        walletB.addCard(cardC);
        walletB.addCard(cardD);

        personA.addWallet(walletA);
        personA.addWallet(walletB);

        InterestReport report = new InterestReportImpl(personA, intCalc, finder);

        // Total interest for person
        Double interest = report.getTotalSimpleInterest();
        assertEquals(21, interest, ERR_MARG);

        // Interest per wallet
        Map<Wallet, Double> walletInterest = report.getInterestPerWallet();
        assertEquals(11, walletInterest.get(walletA), ERR_MARG);
        assertEquals(10, walletInterest.get(walletB), ERR_MARG);
    }

    /**
     * 2 people have 1 wallet each, person 1 has 1 wallet with 2 cards MC and
     * visa person 2 has 1 wallet 1 visa and 1 MC each card has $100 balance
     * calculate the total interest(simple interest) for each person and
     * interest per wallet
     */
    @Test
    public void multiplePeopleScenario() {
        Person personA = new Person();
        Wallet walletA = new Wallet();

        Card cardA = new Mastercard(START_BAL);
        Card cardB = new Visa(START_BAL);

        walletA.addCard(cardA);
        walletA.addCard(cardB);

        personA.addWallet(walletA);

        Person personB = new Person();
        Wallet walletB = new Wallet();

        Card cardC = new Visa(START_BAL);
        Card cardD = new Mastercard(START_BAL);

        walletB.addCard(cardC);
        walletB.addCard(cardD);

        personB.addWallet(walletB);

        List<Person> group = new ArrayList<>(Arrays.asList(personA, personB));

        InterestReport report = new InterestReportImpl(group, intCalc, finder);

        // Total interest for each person
        Map<Person, Double> personInterest = report.getInterestPerPerson();
        assertEquals(15, personInterest.get(personA), ERR_MARG);
        assertEquals(15, personInterest.get(personB), ERR_MARG);

        // Total interest for each wallet
        Map<Wallet, Double> walletInterest = report.getInterestPerWallet();
        assertEquals(15, walletInterest.get(walletA), ERR_MARG);
        assertEquals(15, walletInterest.get(walletB), ERR_MARG);

    }

}
