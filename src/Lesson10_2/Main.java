package Lesson10_2;

import Lesson10_2.TaxTypes.*;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[]{
                new Bill("85", new IncomeTaxType(), taxService),
                new Bill("2000", new VatTaxType(), taxService),
                new Bill("400000", new ProgressiveTaxType(), taxService)
        };
        for (Bill bill : payments) {
            bill.payTaxes();
        }
    }
}
