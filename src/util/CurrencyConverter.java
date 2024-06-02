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
                                1 ARS ---> Argentine Peso              13 GTQ ---> Guatemalan Quetzal
                                2 AUD ---> Australian Dollar           14 HNL ---> Honduran Lempira
                                3 BOB ---> Bolivian Boliviano          15 JPY ---> Japanese Yen
                                4 BRL ---> Brazilian Real              16 MXN ---> Mexican Peso
                                5 CAD ---> Canadian Dollar             17 CNY ---> Chinese Renminbi
                                6 CLP ---> Chilean Peso                18 NIO ---> Nicaraguan Córdoba
                                7 COP ---> Colombian Peso              19 PAB ---> Panamanian Balboa
                                8 CRC ---> Costa Rican Colon           20 PEN ---> Peruvian Sol
                                9 CUP ---> Cuban Peso                  21 PYG ---> Paraguayan Guaraní
                                10 DOP ---> Dominican Peso             22 USD ---> United States Dollar
                                11 EUR ---> Euro                       23 UYU ---> Uruguayan Peso
                                12 GBP ---> Pound Sterling
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
