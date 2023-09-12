package bankproduct.model;

import bankproduct.abstractmodel.AbstractCard;

import java.math.BigDecimal;

public class Card extends AbstractCard {

    public Card(String currency, BigDecimal balance, String name) {
        super(currency, balance, name);
    }
}
