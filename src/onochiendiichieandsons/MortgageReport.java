package onochiendiichieandsons;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("________________");

        for (double balance :calculator.getRemainingBalances()){
            System.out.println(currency.format(balance));
        }
    }

    public void printMortgage() {
        System.out.println();
        System.out.println("Mortgage Amount");
        System.out.println("________________");
        System.out.println(currency.format(calculator.mortgage(
        )));
    }
}
