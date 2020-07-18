package com.nirvana.learning.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=virtusa
 *
 * @author Krishna Verma
 */
public class CountTripletsSolution {
    public static void main(String[] args) {
        long r = 3;
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(9L);
        list.add(9L);
        list.add(27L);
        list.add(81L);
        System.out.println(countTriplets(list, r));
        System.out.println(countTripletsM2(list, r));
    }

    public static long countTriplets(List<Long> arr, long r) {
        long total = 0;
        Map<Long, Long> count = new HashMap<>(); // count of ints
        Map<Long, Long> tuplets = new HashMap<>(); // map 2nd -> count of links

        for (int i = 0; i < arr.size(); ++i) {
            long val = arr.get(i);
            // inc total
            if (val % r == 0 && tuplets.containsKey(val / r)) {
                total += tuplets.get(val / r);
            }
            if (tuplets.containsKey(val)) {
                tuplets.put(val, tuplets.get(val) + count.get(val / r));
            } else if (val % r == 0 && count.containsKey(val / r)) {
                tuplets.put(val, count.get(val / r));
            }
            if (count.containsKey(val))
                count.put(val, count.get(val) + 1);
            else
                count.put(val, 1L);
        }

        return total;
    }

    private static long countTripletsM2(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (potential.containsKey(key) && a % r == 0) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;
    }
}
