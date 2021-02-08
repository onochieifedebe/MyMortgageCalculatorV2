package onochiendiichieandsons;

public class Main {

    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal ($1k - $1M): ",1_000, 1_000_000);

        double annualIntRate = Console.readNumber("Annual Interest Rate: ", 1.0,30.0);

        int periodInYears = (int) Console.readNumber("Period: ", 1, 30);

        var mortgage1 = new MortgageCalculator(principal,annualIntRate,periodInYears);
        var mortgage1Report = new MortgageReport(mortgage1);

//        mortgage1Report.printMortgage();

        mortgage1Report.printPaymentSchedule();
    }
    //<-----Outside Class Methods---------->

}
