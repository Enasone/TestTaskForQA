package bankproduct.model;

import bankproduct.abstractmodel.AbstractCreditCard;

import java.math.BigDecimal;

public class CreditCard extends AbstractCreditCard {

    public CreditCard(String currency, BigDecimal balance, String name, BigDecimal interestRate) {
        super(currency, balance, name, interestRate);
    }
}
