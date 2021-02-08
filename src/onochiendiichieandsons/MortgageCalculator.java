package onochiendiichieandsons;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private double annualIntRate;
    private int periodInYears;

    public MortgageCalculator(int principal, double annualIntRate, int periodInYears) {
        this.principal = principal;
        this.annualIntRate = annualIntRate;
        this.periodInYears = periodInYears;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getPeriodInMonths()];
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= balances.length; numberOfPaymentsMade++) {
            balances[numberOfPaymentsMade - 1] = loadBalance(numberOfPaymentsMade);
        }
        return balances;
    }


    public double mortgage() {

        double monthlyIntRate = getMonthlyIntRate();
        int periodInMonths = getPeriodInMonths();

        double mortgage = principal * ((monthlyIntRate *
                Math.pow(1 + monthlyIntRate, periodInMonths)) /
                (Math.pow(1 + monthlyIntRate, periodInMonths) - 1));
        return mortgage;
    }

    public double loadBalance(
            short paymentsMade) {

        double monthlyIntRate = getMonthlyIntRate();
        int periodInMonths = getPeriodInMonths();

        double balance = principal *
                ((Math.pow(1 + monthlyIntRate, periodInMonths) - Math.pow(1 + monthlyIntRate, paymentsMade)) /
                        (Math.pow(1 + monthlyIntRate, periodInMonths) - 1));
        return balance;
    }

    private int getPeriodInMonths() {
        return periodInYears * MONTHS_IN_YR;
    }

    private double getMonthlyIntRate() {
        return (annualIntRate / PERCENT) / MONTHS_IN_YR;
    }
}
