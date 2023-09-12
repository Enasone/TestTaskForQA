package bankproduct.abstractmodel;

import java.math.BigDecimal;

import static bankproduct.utils.BigDecimalUtils.bd;

public abstract class AbstractDeposit extends AbstractProduct {

    public AbstractDeposit(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }

    public String closure(AbstractDeposit deposit) {
        deposit.currency = "Валюта не выбрана";
        deposit.balance = bd(0);
        deposit.name = "Депозит закрыт";
        return "Депозитный счёт закрыт";
    }

    ;
}
