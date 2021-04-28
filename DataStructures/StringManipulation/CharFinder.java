package DataStructures.StringManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    private final String str;

    public CharFinder(String str) {
        this.str = str;
    }

    public char findFirstNonRepeatingChar() {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toLowerCase().toCharArray();

        for (char ch : chars) {
            var index = map.getOrDefault(ch, 0);
            map.put(ch, index + 1);
        }

        for (char ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }

    public char findFirstRepeatingChar() {
        Set<Character> set = new HashSet<>();
        var chars = str.toLowerCase().toCharArray();

        for (char ch : chars)
            set.add(ch);

        for (char ch : chars) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

    // public char findFirstNonRepeatingCharh(String str) {
    // str = str.toLowerCase();
    // Map<Character, Integer> map = new HashMap<>();
    //
    // for (int i = 0; i < str.length(); i++) {
    // char ch = str.charAt(i);
    // if (map.containsKey(ch)) {
    // int val = map.get(ch);
    // map.replace(str.charAt(i), (val + 1));
    // }
    // else
    // map.put(str.charAt(i), 1);
    // }
    //
    // System.out.println(map);
    //
    // for (int i = 0; i < str.length(); i++) {
    // char ch = str.charAt(i);
    //
    // if (map.get(ch) == 1)
    // return ch;
    // }
    //
    // return Character.MIN_VALUE;
    // }
}
