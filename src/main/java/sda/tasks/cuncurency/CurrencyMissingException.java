package sda.tasks.cuncurency;

public class CurrencyMissingException extends RuntimeException {
    public CurrencyMissingException(String message) {
        super(message);
    }
}
