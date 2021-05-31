package Lesson10_2.TaxTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProgressiveTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(100000)) > 0) {
            return amount.multiply(BigDecimal.valueOf(15)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        } else {
            return amount.multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        }
    }
}
