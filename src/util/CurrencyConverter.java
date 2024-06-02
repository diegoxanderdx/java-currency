package util;

import java.util.Scanner;

public class CurrencyConverter {
    private static final String[] currencies = {
            "", "ARS", "AUD", "BOB", "BRL", "CAD", "CLP", "COP", "CRC", "CUP",
            "DOP", "EUR", "GBP", "GTQ", "HNL", "JPY", "MXN", "CNY", "NIO", "PAB",
            "PEN", "PYG", "USD", "UYU"
    };

    public static int getCurrencyChoice(Scanner scanner, String currencyType) {
        int choice = 0;
        while (true) {
            System.out.println("""
                                Enter a number between 1 and 23 to choose a %s Currency
                                1 Argentine Peso              13 Guatemalan Quetzal
                                2 Australian Dollar           14 Honduran Lempira
                                3 Bolivian Boliviano          15 Japanese Yen
                                4 Brazilian Real              16 Mexican Peso
                                5 Canadian Dollar             17 Chinese Renminbi
                                6 Chilean Peso                18 Nicaraguan Córdoba
                                7 Colombian Peso              19 Panamanian Balboa
                                8 Costa Rican Colon           20 Peruvian Sol
                                9 Cuban Peso                  21 Paraguayan Guaraní
                                10 Dominican Peso             22 United States Dollar
                                11 Euro                       23 Uruguayan Peso
                                12 Pound Sterling
                                -------->
                                """.formatted(currencyType));
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 23) {
                    break;
                } else {
                    System.out.println("Invalid number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }

    public static String getCurrencyCode(int choice) {
        return currencies[choice];
    }

    public static double getAmount(Scanner scanner) {
        double amount = 0.0;
        while (true) {
            System.out.print("Enter the amount to convert: ");
            String input = scanner.next();
            try {
                input = input.replace(",", ".");
                amount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return amount;
    }
}
