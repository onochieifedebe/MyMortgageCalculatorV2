package onochiendiichieandsons;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal ($1k - $1M): ",1_000, 1_000_000);

        double annualIntRate = readNumber("Annual Interest Rate: ", 1.0,30.0);

        int periodInYears = (int) readNumber("Period: ", 1, 30);

        printMortgage(principal, annualIntRate, periodInYears);

        printPaymentSchedule(principal, annualIntRate, periodInYears);
    }
    //<-----Outside Class Methods---------->

    private static void printMortgage(int principal, double annualIntRate, int periodInYears) {
        System.out.println("Mortgage: "+NumberFormat.getCurrencyInstance().format(mortgage(principal,
                annualIntRate,
                periodInYears)));
    }

    private static void printPaymentSchedule(int principal, double annualIntRate, int periodInYears) {
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println("________________");
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= periodInYears *MONTHS_IN_YR; numberOfPaymentsMade++) {
            double balance = loadBalance(principal, annualIntRate, periodInYears, numberOfPaymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double mortgage(
            int principal,
            double annualIntRate,
            int periodInYears) {

        double monthlyIntRate = (annualIntRate  / PERCENT) / MONTHS_IN_YR;
        int periodInMonths = periodInYears * MONTHS_IN_YR;

        double mortgage = principal * ((monthlyIntRate *
                Math.pow(1+monthlyIntRate,periodInMonths)) /
                (Math.pow(1+monthlyIntRate,periodInMonths) - 1));
        return mortgage;
    }

    public static double readNumber (String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a number between "+ min + " and "+ max);
        }
        return value;
    }

    public static double loadBalance(
            int principal,
            double annualIntRate,
            int periodInYears,
            short paymentsMade) {

        double monthlyIntRate = (annualIntRate  / PERCENT) / MONTHS_IN_YR;
        int periodInMonths = periodInYears * MONTHS_IN_YR;

        double balance = principal *
                ((Math.pow(1+monthlyIntRate,periodInMonths)-Math.pow(1+monthlyIntRate,paymentsMade))/
                (Math.pow(1+monthlyIntRate,periodInMonths)-1));
        return balance;
    }
}
