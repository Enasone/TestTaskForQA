package bankproduct.model;

import bankproduct.abstractmodel.AbstractDeposit;

import java.math.BigDecimal;

public class Deposit extends AbstractDeposit {

    public Deposit(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }
}
