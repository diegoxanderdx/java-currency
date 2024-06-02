package main;

import service.ConversionService;
import service.ExchangeRateFetcher;
import util.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("""
                ----------------------------------------------------
                -----------WELCOME TO CURRENCY CONVERSOR------------
                ----------------------------------------------------
                """);

        Scanner scanner = new Scanner(System.in);

        int baseChoice = CurrencyConverter.getCurrencyChoice(scanner, "Base");
        String baseCurrency = CurrencyConverter.getCurrencyCode(baseChoice);
        System.out.println("You have selected: " + baseCurrency + " as Base Currency \n \n");

        int targetChoice = CurrencyConverter.getCurrencyChoice(scanner, "Target");
        String targetCurrency = CurrencyConverter.getCurrencyCode(targetChoice);
        System.out.println("You have selected: " + targetCurrency + " as Target Currency \n \n");

        double amount = CurrencyConverter.getAmount(scanner);
        System.out.println("You have entered: " + amount + " as the amount to convert. \n \n");

        double conversionRate = ExchangeRateFetcher.fetchConversionRate(baseCurrency, targetCurrency);
        if (conversionRate != -1) {
            double convertedAmount = ConversionService.convertAmount(amount, conversionRate);
            System.out.println(amount + " " + baseCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Conversion rate for " + targetCurrency + " not found.");
        }
    }
}
