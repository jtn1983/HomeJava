package Lesson10_2;

import Lesson10_2.TaxTypes.TaxType;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private TaxType taxType;
    private TaxService taxService;

    public Bill(String amount, TaxType taxType, TaxService taxService) {
        this.amount = new BigDecimal(amount);
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public void payTaxes() {
        BigDecimal taxAmount = taxType.calculateTaxFor(amount);
        taxService.payOut(taxAmount);
    }
}
