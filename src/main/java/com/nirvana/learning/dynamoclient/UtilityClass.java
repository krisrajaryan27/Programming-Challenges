package com.nirvana.learning.dynamoclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author KrishnaV
 */
public class UtilityClass {

    final static int CURRENCY_ID = 6;

    static String getCurrencyIdFromLine(Map<String, Map<Integer, String>> attributeMap){
        return attributeMap.values()
                .stream()
                .map(lineMap -> lineMap.get(CURRENCY_ID))
                .filter(Objects::nonNull)
                .findAny()
                .orElse(null);
    }

    public static void main(String[] args) {
        Map<String, Map<Integer, String>> attributeMap = new HashMap<>();
        Map<Integer, String> lineMap = new HashMap<>();
        for(int i=0;i<10;i++){
            lineMap.put(i, "Line"+i);
            attributeMap.put("Segment"+i,lineMap);
        }

        System.out.println(getCurrencyIdFromLine(attributeMap));
    }
}
