package Lesson10_2.TaxTypes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VatTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(18)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
