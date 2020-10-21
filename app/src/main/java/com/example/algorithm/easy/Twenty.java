package com.example.algorithm.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Twenty {

    // 时间复杂度O(n)
    // 空间复杂度O(N + |E|)
    public boolean isValid(String abc) {
        int length = abc.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char temp = abc.charAt(i);
            if (pairs.containsKey(temp)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(temp)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(temp);
            }
        }

        return stack.isEmpty();
    }
}
