package com.nirvana.learning.interview.bits;

import java.util.LinkedList;
import java.util.List;

/**
 * Date 03/12/2019
 *
 * @author Krishna Verma
 * <p>
 * Get first n gray code
 * Reference
 * https://leetcode.com/problems/gray-code/
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(4));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}
