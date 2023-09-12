package ru.bankproduct.unit;

import bankproduct.model.CreditCard;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bankproduct.utils.BigDecimalUtils.bd;

@DisplayName("Unit test - Проверка функций CreditCard")
public class CreditCardUnitTest extends BaseTest {

    @DisplayName("Проверка задолжности по карте")
    @ParameterizedTest(name = "Баланс карты пользователя = {0}")
    @ValueSource(doubles = {100.00, 99.99, 199.49, 00.09, 55.90})
    void creditCardArrearsRequestTest(Double arrearsValue) {
        CreditCard creditCard = new CreditCard("Рубль", bd(arrearsValue), "Кредитная карта", bd(50));

        var actualResult = creditCard.balanceRequest();
        Assertions.assertThat(actualResult)
                .as("Получение значения по задолжности карты")
                .isEqualTo(bd(arrearsValue));
    }

    @DisplayName("Списание баланса с кредитной карты")
    @ParameterizedTest(name = "При списании баланса {0} на {1} ожидается результат {2}")
    @CsvSource(delimiter = '|', textBlock = """
            100.00  |  100.00  | 0
            150.50  |  0.50    | 150.00
            100.00  |  0.01    | 99.99
            75.75   |  20.23   | 55.52
            145.31  |  251.00  | -105.69
            -162.41 |  521.45  | -683.86
            """)
    void creditCardMagazineTest(Double firstNumber, Double secondNumber, Double expectedResult) {
        CreditCard creditCard = new CreditCard("Рубль", bd(firstNumber), "Кредитная карта", bd(50));

        var actualResult = creditCard.magazine(bd(secondNumber));
        Assertions.assertThat(actualResult)
                .as("Разность")
                .isEqualTo(bd(expectedResult));
    }

    @DisplayName("Проверка баланса карты")
    @ParameterizedTest(name = "Баланс карты пользователя = {0}")
    @ValueSource(doubles = {100.00, 99.99, -199.49, 00.09, -55.90})
    void creditCardBalanceTest(Double balanceUser) {
        CreditCard creditCard = new CreditCard("Рубль", bd(balanceUser), "Кредитная карта", bd(50));

        var actualResult = creditCard.balanceRequest();
        Assertions.assertThat(actualResult)
                .as("Получение значения баланса карта")
                .isEqualTo(bd(balanceUser));
    }
}
