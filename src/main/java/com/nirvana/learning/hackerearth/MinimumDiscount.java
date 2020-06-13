package com.nirvana.learning.hackerearth;

import java.util.*;

/**
 * Min discount problem -
 * In simple words, there is an array - prices array : [5, 4, 5, 1, 3, 3, 8, 2]
 * The discount on the price is the first equal to or lowest element on the right side of current price. Output the total in the end and also list of items index that will not get any discount.
 * For example -
 * 5 - 4 = 1
 * 4 - 1 = 3
 * 5 - 1 = 4
 * 1 - 0 = 1 (This element didn't got any discount)
 * 3 - 3 = 0
 * 3 - 2 = 1
 * 8 - 2 = 6
 * 2 - 0 = 2 (This element will also not get discount as no equal to or less than price on right).
 * Output -
 * Total = 18
 * Elements ID not getting discount - 3, 7
 */

public class MinimumDiscount {

    public static void finalPrice(List<Integer> prices) {
        Integer[] discount = new Integer[prices.size()];
        Arrays.fill(discount, 0);
        Stack<Integer> stack = new Stack<>();
        List<Integer> finalPrice = new ArrayList<>();
        for (Integer i = prices.size() - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() > prices.get(i))
                stack.pop();
            if (!stack.isEmpty())
                discount[i] = stack.peek();
            stack.push(prices.get(i));
        }
        int total = 0;
        for (int i = 0; i < prices.size(); i++) {
            finalPrice.add(prices.get(i) - discount[i]);
            total += finalPrice.get(i);
        }
        System.out.println(total);
        for (int i = 0; i < discount.length; i++) {
            if (discount[i] == 0)
                System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pricesCount = scanner.nextInt();

        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < pricesCount; i++) {
            int pricesItem = scanner.nextInt();
            prices.add(pricesItem);
        }
        finalPrice(prices);
    }
}
