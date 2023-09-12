package bankproduct.abstractmodel;

import java.math.BigDecimal;

public abstract class AbstractCard extends AbstractProduct {

    public AbstractCard(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }

    public BigDecimal magazine(BigDecimal minus) {
        balance = balance.subtract(minus);
        return balance;
    }

    ;
}
