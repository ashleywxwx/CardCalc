package com.recursivechaos.cardcalc.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A person holds wallets.
 *
 * @author Andrew Bell
 */
public class Person {

    private List<Wallet> wallets = new ArrayList<>();

    /**
     * Adds another wallet to the person
     * 
     * @param wallet
     */
    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

}
