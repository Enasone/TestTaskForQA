package ru.bankproduct.unit;

import bankproduct.model.Deposit;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static bankproduct.utils.BigDecimalUtils.bd;

@DisplayName("Unit test - Проверка функций Deposit")
public class DepositUnitTest extends BaseTest {

    @DisplayName("Проверка закрытия счёта")
    @Test
    void depositClosureTest() {
        Deposit deposit = new Deposit("Доллар", bd(100), "Карта");

        String actualResult = deposit.closure(deposit);

        Assertions.assertThat(actualResult)
                .as("Значение закрытого счёта")
                .isEqualTo("Депозитный счёт закрыт");
        Assertions.assertThat(deposit.balanceRequest())
                .as("Баланс депозита")
                .isEqualTo(bd(0));
    }

    @DisplayName("Прокерка баланса депозита")
    @ParameterizedTest(name = "Баланс карты пользователя = {0}")
    @ValueSource(doubles = {100.00, 99.99, -199.49, 00.09, -55.90})
    void depositCheckBalanceTest(Double balanceDeposit) {
        Deposit deposit = new Deposit("Доллар", bd(balanceDeposit), "Карта");

        var actualResult = deposit.balanceRequest();
        Assertions.assertThat(actualResult)
                .as("Баланс депозита")
                .isEqualTo(bd(balanceDeposit));
    }

    @DisplayName("Пополнение счёта на депозите")
    @ParameterizedTest(name = "При пополнении баланса {0} на {1} ожидается результат {2}")
    @CsvSource(delimiter = '|', textBlock = """
            100.00  |  100.00  | 200.00
            150.50  |  0.50    | 151.00
            """)
    void depositReplenishmentTest(Double firstNumber, Double secondNumber, Double expectedResult) {
        Deposit deposit = new Deposit("Рубль", bd(firstNumber), "Карта");

        var actualResult = deposit.replenishment(bd(secondNumber));
        Assertions.assertThat(actualResult)
                .as("Суммирование")
                .isEqualTo(bd(expectedResult));
    }
}
