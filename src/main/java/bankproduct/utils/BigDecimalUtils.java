package bankproduct.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class BigDecimalUtils {

    public static BigDecimal bd(int value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal bd(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN);
    }
}
