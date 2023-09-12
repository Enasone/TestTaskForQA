package ru.bankproduct.unit;

import bankproduct.model.Card;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bankproduct.utils.BigDecimalUtils.bd;

@DisplayName("Unit test - Проверка функций Card")
public class CardUnitTest extends BaseTest {

    @DisplayName("Пополнение баланса на карту")
    @ParameterizedTest(name = "При пополнении баланса {0} на {1} ожидается результат {2}")
    @CsvSource(delimiter = '|', textBlock = """
            100.00  |  100.00  | 200.00
            150.50  |  0.50    | 151.00
            """)
    void cardReplenishmentTest(Double firstNumber, Double secondNumber, Double expectedResult) {
        Card card = new Card("Рубль", bd(firstNumber), "Карта");

        var actualResult = card.replenishment(bd(secondNumber));
        Assertions.assertThat(actualResult)
                .as("Суммирование")
                .isEqualTo(bd(expectedResult));
    }

    @DisplayName("Списание баланса с карты")
    @ParameterizedTest(name = "При списании баланса {0} на {1} ожидается результат {2}")
    @CsvSource(delimiter = '|', textBlock = """
            100.00  |  100.00  | 0
            150.50  |  0.50    | 150.00
            100.00  |  0.01    | 99.99
            75.75   |  20.23   | 55.52
            145.31  |  251.00  | -105.69
            -162.41 |  521.45  | -683.86
            """)
    void cardMagazineTest(Double firstNumber, Double secondNumber, Double expectedResult) {
        Card card = new Card("Евро", bd(firstNumber), "Карта");

        var actualResult = card.magazine(bd(secondNumber));
        Assertions.assertThat(actualResult)
                .as("Разность")
                .isEqualTo(bd(expectedResult));
    }

    @DisplayName("Прокерка баланса карты")
    @ParameterizedTest(name = "Баланс карты пользователя = {0}")
    @ValueSource(doubles = {100.00, 99.99, -199.49, 00.09, -55.90})
    void cardCheckBalanceTest(Double balanceUser) {
        Card card = new Card("Доллар", bd(balanceUser), "Карта");

        var actualResult = card.balanceRequest();
        Assertions.assertThat(actualResult)
                .as("Баланс счета")
                .isEqualTo(bd(balanceUser));
    }
}
