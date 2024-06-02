package service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateFetcher {
    private static final String API_URL_TEMPLATE = "https://v6.exchangerate-api.com/v6/22a494541381e337b242ea2a/latest/%s";

    public static double fetchConversionRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        String apiUrl = String.format(API_URL_TEMPLATE, baseCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonResponse = response.body();

        try {
            JsonObject responseObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject conversionRatesObject = responseObject.getAsJsonObject("conversion_rates");
            if (conversionRatesObject.has(targetCurrency)) {
                return conversionRatesObject.get(targetCurrency).getAsDouble();
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Error parsing JSON response: " + e.getMessage());
        }
        return -1;
    }
}