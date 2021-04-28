package DataStructures.StringManipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringManipulation {

    public static int countVowels(String string) {
        if (string == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : string.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public static String reverseString(String string) {
        if (string == null)
            return "";

        // StringBuilder have a reverse method
        StringBuilder revString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--)
            revString.append(string.charAt(i));

        return revString.toString();
    }

    public static String reverseWords(String string) {
        if (string == null)
            return "";

        String[] words = string.trim().split(" ");
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }

    public static boolean areRotations(String string1, String string2) {
        if (string1 == null || string2 == null)
            return false;

        return (string1.length() == string2.length() && (string1 + string2).contains(string2));
    }

    public static String removeDuplicates(String string) {
        if (string == null)
            return "";

        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : string.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static char mostRepeatedChar(String string) {
        if (string == null || string.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII = 256;
        int[] counter = new int[ASCII];
        for (var ch : string.toCharArray())
            counter[ch]++;

        int max = 0;
        char maxCh = ' ';
        for (var i = 0; i < counter.length; i++)
            if (counter[i] > max) {
                max = counter[i];
                maxCh = (char) i;
            }

        return maxCh;
    }

    public static String capitalize(String string) {
        if (string == null || string.trim().isEmpty())
            return "";

        String[] words = string.trim().replaceAll(" +", " ").split(" ");

        for (int i = 0; i < words.length; i++)
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();

        return String.join(" ", words);
    }

    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null)
            return false;

        var chars1 = first.toLowerCase().toCharArray();
        Arrays.sort(chars1);

        var chars2 = second.toLowerCase().toCharArray();
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static boolean areAnagrams2(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] counter = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase();
        for (var i = 0; i < first.length(); i++)
            counter[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (counter[index] == 0)
                return false;

            counter[index]--;
        }

        return true;
    }

    public static boolean isPalindrome(String string) {
        if (string == null)
            return false;

        // check if string equal it's reverse
        // or pointers and that is much faster
        int left = 0;
        int right = string.length() - 1;

        while (left < right)
            if (string.charAt(left++) != string.charAt(right--))
                return false;

        return true;
    }
}
