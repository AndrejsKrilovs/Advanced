package sda.tasks.cuncurency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class CurrencyExchangeService {
    private final static String FILE_NAME =
            "/home/andrejs-krilovs/Work/26_27_october_training/src/main/java/sda/tasks/currency/rates.txt";

    public List<String> getAllCurrenciesWeWorkWith() {
        final List<String> result = new ArrayList<>();
        try (final BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line.split("\\s")[0]);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("File not found.\n\r%s", e.getCause());
        } catch (IOException e) {
            System.err.printf("Input output exception.\n\r%s", e.getCause());
        }
        return result;
    }

    public Map<String, String> getValueByCurrency() {
        final Map<String, String> currencyKeyValue = new HashMap<>();
        try (final BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                currencyKeyValue.put(line.split("\\s")[0], line.split("\\s")[1]);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("File not found.\n\r%s", e.getCause());
        } catch (IOException e) {
            System.err.printf("Input output exception.\n\r%s", e.getCause());
        }
        return currencyKeyValue;
    }

    public String getRateByCurrency(final String currencyCode) {
        final Map<String, String> currencyMap = getValueByCurrency();
        if(currencyMap != null) {
            return currencyMap.get(currencyCode);
        } else {
            throw new CurrencyMissingException("Invalid currency");
        }
    }
}
