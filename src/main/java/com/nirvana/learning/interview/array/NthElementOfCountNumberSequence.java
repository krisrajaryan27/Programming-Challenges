package com.nirvana.learning.interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 07/20//2018
 *
 * @author Krishna Verma
 * <p>
 * Given a sequence like
 * 1 11 21 1211 111221 312211
 * Print nth element of this sequence.
 */
public class NthElementOfCountNumberSequence {

    public static void main(String[] args) {
        NthElementOfCountNumberSequence nes = new NthElementOfCountNumberSequence();
        for (int i = 1; i <= 10; i++) {
            List<Integer> result = nes.nthElement(i);
            result.forEach(System.out::print);
            System.out.println();
        }
    }

    public List<Integer> nthElement(int n) {
        int i = 1;
        List<Integer> current = new ArrayList<>();
        current.add(1);
        List<Integer> result = new ArrayList<>();
        while (i < n) {
            int count = 1;
            int index = 0;
            for (int j = 1; j < current.size(); j++) {
                if (current.get(index) == current.get(j)) {
                    count++;
                } else {
                    result.add(count);
                    result.add(current.get(index));
                    count = 1;
                    index = j;
                }
            }
            result.add(count);
            result.add(current.get(index));
            current = result;
            result = new ArrayList<>();
            i++;
        }
        return current;
    }
}
