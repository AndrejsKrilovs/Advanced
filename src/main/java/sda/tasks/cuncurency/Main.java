package sda.tasks.cuncurency;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();
        List<String> list = currencyExchangeService.getAllCurrenciesWeWorkWith();
        System.out.println(list);

        try {
            String number = "42c";
            Integer n = Integer.parseInt(number);
            System.out.println(n);
        } catch (NumberFormatException n) {
            System.out.println("0");
        }

        Map<String, String> result = currencyExchangeService.getValueByCurrency();
        System.out.println(result);

        try {
            String currentRate = currencyExchangeService.getRateByCurrency(null);
            System.out.println(currentRate);
        } catch (CurrencyMissingException c) {
            System.out.println("100");
        }

    }
}
