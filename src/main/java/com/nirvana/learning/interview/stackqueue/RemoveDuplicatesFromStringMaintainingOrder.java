package com.nirvana.learning.interview.stackqueue;

import java.util.*;

/**
 * Date 02/29/2019
 *
 * @author Krishna Verma
 * <p>
 * Given a string remove duplicates from the string maintaining order
 * and getting lexicographically smallest string.
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/remove-duplicate-letters/">...</a>
 */
public class RemoveDuplicatesFromStringMaintainingOrder {
    public static void main(String[] args) {
        RemoveDuplicatesFromStringMaintainingOrder rm = new RemoveDuplicatesFromStringMaintainingOrder();
        System.out.println(rm.removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.compute(s.charAt(i), (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }

        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.get(ch) - 1);
            if (visited.contains(ch)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peekFirst() > ch && count.get(stack.peekFirst()) > 0) {
                visited.remove(stack.peekFirst());
                stack.pollFirst();
            }

            stack.offerFirst(ch);
            visited.add(ch);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }
}
