package sda.tasks.exceptions.optional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JuniorDeveloperSenior {
    public String something = "";

    /**
     * Wrap provided Object with Optional
     */
    public Optional<Object> wrapProvidedValueWithOptional(Object obj) {
        return Optional.of(obj);
    }

    /**
     * return "default" if object inside optional not exists
     * return String if present
     */
    public String returnWordDefaultIfOptionalEmpty(Optional<String> optString) {
        return optString.orElse("default");
    }


    /**
     * create List with optional string. Add 3 elements to it.
     */
    public List<Optional<String>> createListOptString() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(item -> Optional.of(String.valueOf(item)))
                .collect(Collectors.toList());
    }

    /**
     * create empty optional
     */
    public Optional createEmptyOptional() {
        return Optional.empty();
    }

    /**
     * if Optional ifPresent, then change value something to "1"
     * Use only method ifPresent
     * ifPresent
     */
    public void ifOptionalPresentMakeChangeSomething(Optional<Object> objOpt) {
       objOpt.ifPresent(item -> this.something = "1");
    }
}
