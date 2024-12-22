package games;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.SequencedMap;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class FizzBuzz {
    public static final int MIN = 1;
    public static final int MAX = 100;
    private final SequencedMap<Integer, String> mapping;

    public FizzBuzz(SequencedMap<Integer, String> mapping) {
        this.mapping = mapping;
    }

    public Optional<String> convert(int input) {
        return isOutOfRange(input)
                ? empty()
                : of(convertSafely(input));
    }

    private String convertSafely(Integer input) {
        return mapping.entrySet().stream()
                .filter(p -> matchingDivisors(input, p))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(input.toString());
    }

    private boolean matchingDivisors(Integer input, Map.Entry<Integer, String> entry) {
        return is(entry.getKey(), input);
    }

    private boolean is(Integer divisor, Integer input) {
        return input % divisor == 0;
    }

    private boolean isOutOfRange(Integer input) {
        return input < MIN || input > MAX;
    }
}
