package Lesson10_2;

import java.math.BigDecimal;

public class TaxService {
    public void payOut(BigDecimal taxAmount) {
        System.out.println("Tax paid in the amount of " + taxAmount.toString());
    }
}
