package delivery;

import java.util.ArrayList;
import java.util.List;

public class Building {
    public static int whichFloor(String instructions) {
        List<Pair<Character, Integer>> val = new ArrayList<>();

        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);

            val.add(instructions.contains("🧝") ?
                    new Pair<>(c, elfMap(c)) :
                    new Pair<>(c, normalMap(c)));
        }

        return val.stream().mapToInt(Pair::value).sum();
    }

    private static int normalMap(char c) {
        return c == '(' ? 1 : -1;
    }

    private static int elfMap(char c) {
        return switch (c) {
            case ')' -> 3;
            case '(' -> -2;
            default -> 0;
        };
    }

    public record Pair<K, V>(K key, V value) {
    }
}
