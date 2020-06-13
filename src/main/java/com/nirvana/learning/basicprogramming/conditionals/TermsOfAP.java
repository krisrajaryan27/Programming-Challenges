package com.nirvana.learning.basicprogramming.conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TermsOfAP {
    static Integer max_value = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> apList = new ArrayList<>();

        for (int i = 1; i <= max_value; i++) {
            int seriesItem = 3 * i + 2;
            if (apList.size() < x) {
                if (seriesItem % 4 != 0) {
                    apList.add(seriesItem);
                }
            } else {
                break;
            }
        }
        Iterator iterator = apList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
