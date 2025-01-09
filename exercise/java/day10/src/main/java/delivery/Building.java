package delivery;

import java.util.ArrayList;
import java.util.List;

public class Building {

    public static final char UP = '(';
    public static final char DOWN = ')';
    public static final String ELF_SYMBOL = "🧝";

    public static int whichFloor(String instructions) {
        List<Pair<Character, Integer>> val = new ArrayList<>();


        return instructions.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> instructions.contains(ELF_SYMBOL) ?
                        elfMap(c) :
                        normalMap(c))
                .sum();

    }

    private static int normalMap(char c) {
        return c == UP ? 1 : -1;
    }

    private static int elfMap(char c) {
        return switch (c) {
            case DOWN -> 3;
            case UP -> -2;
            default -> 0;
        };
    }

    public record Pair<K, V>(K key, V value) {
    }
}
