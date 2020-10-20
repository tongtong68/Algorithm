package com.example.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seventeen {
    String[] map1 = {"a", "b", "c"};
    String[] map2 = {"d", "e", "f"};
    String[] map3 = {"g", "h", "i"};
    String[] map4 = {"j", "k", "l"};
    String[] map5 = {"m", "n", "o"};
    String[] map6 = {"p", "q", "r", "s"};
    String[] map7 = {"t", "u", "v"};
    String[] map8 = {"w", "x", "y", "z"};

    // 时间复杂度 O(3*M * 4*N)
    // 空间复杂度 O(M + N)
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
