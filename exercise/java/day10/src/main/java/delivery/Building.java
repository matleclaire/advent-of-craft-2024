package delivery;

import java.util.ArrayList;
import java.util.List;

public class Building {

    public static final char UP = '(';
    public static final char DOWN = ')';
    public static final String ELF_SYMBOL = "🧝";

    public static int whichFloor(String instructions) {
        List<Pair<Character, Integer>> val = new ArrayList<>();

        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            val.add(instructions.contains(ELF_SYMBOL) ?
                    new Pair<>(c, elfMap(c)) :
                    new Pair<>(c, normalMap(c)));
        }

        return val.stream().mapToInt(Pair::value).sum();
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
