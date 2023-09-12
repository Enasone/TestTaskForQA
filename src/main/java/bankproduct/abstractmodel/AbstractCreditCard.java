package bankproduct.abstractmodel;

import java.math.BigDecimal;

public abstract class AbstractCreditCard extends AbstractCard {

    protected BigDecimal interestRate;

    public AbstractCreditCard(String currency, BigDecimal balance, String name, BigDecimal interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    public BigDecimal arrearsRequest() {
        return interestRate;
    }

    ;
}
