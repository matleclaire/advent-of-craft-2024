package games;

import net.jqwik.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static games.FizzBuzz.MAX;
import static games.FizzBuzz.MIN;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTests {
    private static final Set<String> fizzBuzzStrings = Set.of("Fizz", "Buzz", "FizzBuzz", "FizzWhizz", "BuzzWhizz", "Whizz", "Bang");
    public static LinkedHashMap<Integer, String> MAPPING = new LinkedHashMap<>();

    @BeforeAll
    static void beforeAll() {
        MAPPING.put(35, "BuzzWhizz");
        MAPPING.put(21, "FizzWhizz");
        MAPPING.put(15, "FizzBuzz");
        MAPPING.put(3, "Fizz");
        MAPPING.put(5, "Buzz");
        MAPPING.put(7, "Whizz");
        MAPPING.put(11, "Bang");
    }

    public static Stream<Arguments> validInputs() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(67, "67"),
                Arguments.of(82, "82"),
                Arguments.of(3, "Fizz"),
                Arguments.of(66, "Fizz"),
                Arguments.of(99, "Fizz"),
                Arguments.of(5, "Buzz"),
                Arguments.of(50, "Buzz"),
                Arguments.of(85, "Buzz"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(30, "FizzBuzz"),
                Arguments.of(45, "FizzBuzz"),
                Arguments.of(7, "Whizz"),
                Arguments.of(21, "FizzWhizz"),
                Arguments.of(35, "BuzzWhizz"),
                Arguments.of(11, "Bang")
        );
    }

    @ParameterizedTest
    @MethodSource("validInputs")
    void parse_successfully_numbers_between_1_and_100_samples(int input, String expectedResult) {
        assertThat(new FizzBuzz(MAPPING).convert(input))
                .isEqualTo(Optional.of(expectedResult));
    }

    @Property
    public void parse_return_valid_string_for_numbers_between_1_and_100(@ForAll("validIntegers") int x) {
        assertThat(isConvertValid(x)).isTrue();
    }

    @Provide
    Arbitrary<Integer> validIntegers() {
        return Arbitraries.integers().filter(x -> x >= MIN && x <= MAX);
    }

    @Property
    public void parse_fail_for_numbers_out_of_range(@ForAll("invalidIntegers") int x) {
        assertThat(isConvertValid(x)).isFalse();
    }

    @Provide
    Arbitrary<Integer> invalidIntegers() {
        return Arbitraries.integers().filter(x -> x < MIN || x > MAX);
    }

    private boolean isConvertValid(Integer x) {
        return new FizzBuzz(MAPPING).convert(x)
                .map(s -> validStringsFor(x).contains(s))
                .orElse(false);
    }

    private Set<String> validStringsFor(Integer x) {
        var strings = new HashSet<>(fizzBuzzStrings);
        strings.add(x.toString());
        return strings;
    }

}
