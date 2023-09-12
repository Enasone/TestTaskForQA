package bankproduct.abstractmodel;

import java.math.BigDecimal;

public abstract class AbstractProduct {

    protected String currency;
    protected BigDecimal balance;
    protected String name;

    public AbstractProduct(String currency, BigDecimal balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }

    public BigDecimal replenishment(BigDecimal sum) {
        balance = balance.add(sum);
        return balance;
    }

    public BigDecimal balanceRequest() {
        return balance;
    }

    ;
}
