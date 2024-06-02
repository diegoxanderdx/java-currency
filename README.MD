# CURRENCY CONVERTER

The currency converter is a project related to the Alura course on object-oriented programming in JAVA. This project involves consuming an API, [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/), using its standard mode. Based on the base currency provided by the user, an endpoint is consumed that returns a JSON. This JSON contains the conversion rates in key-value format for all currencies included in the API. The user selects the target currency and also enters the amount to perform the calculation and return the conversion result.

## Project Packages

### main
This folder contains:

- **Main.java**: It includes the main logic of the program and the user interaction.

### util
In this folder, we find:

- **CurrencyConverter.java**: It manages the logic to obtain currency options and the user's input amount.
- **ExchangeRateFetcher.java**: It performs the HTTP request to obtain the conversion rate and processes the JSON response.

### service
Inside this folder, we have:

- **ConversionService.java**: It contains the method to calculate the converted amount using the conversion rate.

## Handled exceptions:

- **When the user enters a number that is not within the range to choose the currency**
- **When the user enters a string to choose the currency**
- **When the user enters a decimal separated by a comma when entering the amount**
- **When the user enters a string when entering the amount**
- **When for some unknown reason the conversion rate is not found within the API being consumed**

## Screenshots

![Screenshoot 1](https://postimg.cc/ykyjTpyY)