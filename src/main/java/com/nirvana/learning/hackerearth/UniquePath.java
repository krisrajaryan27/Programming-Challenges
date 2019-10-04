package com.nirvana.learning.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UniquePath {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aRows = Integer.parseInt(bufferedReader.readLine().trim());
        int aColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < aRows; i++) {
            String[] aRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> aRowItems = new ArrayList<>();

            for (int j = 0; j < aColumns; j++) {
                int aItem = Integer.parseInt(aRowTempItems[j]);
                aRowItems.add(aItem);
            }

            a.add(aRowItems);
        }

        int result = uniquePathsWithObstacles(a);
        System.out.println(result);


        bufferedReader.close();
    }

    public static int uniquePathsWithObstacles(List<List<Integer>> a) {
        Integer[][] array = convertListToArray(a);
        int m = array.length;
        if (m == 0 || array[0].length == 0) {
            return 0;
        }
        int n = array[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    dp[j] = 0;
                } else if (j == 0) {
                    dp[j] = (i > 0 && dp[j] == 0) ? 0 : 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }

    private static Integer[][] convertListToArray(List<List<Integer>> a) {
        Integer[][] array = a.stream()
                .map(l -> l.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        for(int i =0 ;i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                array[i][j]^=1;
            }
        }
        return array;
    }


}
