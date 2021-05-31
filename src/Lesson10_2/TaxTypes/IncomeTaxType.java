package Lesson10_2.TaxTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IncomeTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(13)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
