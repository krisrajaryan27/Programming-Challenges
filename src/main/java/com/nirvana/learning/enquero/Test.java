package com.nirvana.learning.enquero;


public class Test {
    public static void main(String arg[]) {
        //7913

        //9laks 99 thousand 999
        System.out.println(convertNumIntoString(7913));


    }

    private static String convertNumIntoString(int num) { //9999
        StringBuilder sb = new StringBuilder();
        int mult = num / 10; //791
        if (mult < 10 && mult > 1) {
            sb.append(getMultiplier(mult)).append(" ").append(getUnitNum(num % 10));
        }
        int hundredTh = mult / 10; //79
        if(hundredTh >= 1 && hundredTh <10){
            sb.append(getUnitNum(hundredTh)).append(" ").append("hundred").append(" ").append(getMultiplier(mult/10)).append(" ").append(getUnitNum(num % 10));
        }

        if(hundredTh >=10 && hundredTh <100) {
            if (num % 100 < 20 && num%100 > 0) {
                sb.append(getUnitNum(hundredTh / 10)).append(" ").append("thousand").append(" ").append(getUnitNum(hundredTh % 10)).append(" ").append("hundred").append(" ").append(getUnitNum(num % 100));
            } else {
                sb.append(getUnitNum(hundredTh / 10)).append(" ").append("thousand").append(" ").append(getUnitNum(hundredTh % 10)).append(" ").append("hundred").append(" ").append(getMultiplier(mult/10)).append(getUnitNum(num % 10));
            }
        }
        return sb.toString();
    }



    public static String getMultiplier(int num) {
        String multiplier;
        switch (num) {
            case 2:
                multiplier = "twenty";
                break;
            case 3:
                multiplier = "thirty";
                break;
            case 4:
                multiplier = "forty";
                break;
            case 5:
                multiplier = "fifty";
                break;
            case 6:
                multiplier = "sixty";
                break;
            case 7:
                multiplier = "seventy";
                break;
            case 8:
                multiplier = "eighty";
                break;
            case 9:
                multiplier = "ninty";
                break;
            default:
                multiplier = null;
        }
        return multiplier;
    }

    private static String getUnitNum(int num) {
        String name;
        switch (num) {
            case 0:
                name = "zero";
                break;
            case 1:
                name = "One";
                break;
            case 2:
                name = "two";
                break;
            case 3:
                name = "three";
                break;
            case 4:
                name = "four";
                break;
            case 5:
                name = "five";
                break;
            case 6:
                name = "six";
                break;
            case 7:
                name = "seven";
                break;
            case 8:
                name = "eight";
                break;
            case 9:
                name = "nine";
                break;
            case 10:
                name = "ten";
                break;
            case 11:
                name = "eleven";
                break;
            case 12:
                name = "twelve";
                break;
            case 13:
                name = "thirteen";
                break;
            case 14:
                name = "fourteen";
                break;
            case 15:
                name = "fifteen";
                break;
            case 16:
                name = "sixteen";
                break;
            case 17:
                name = "seventeen";
                break;
            case 18:
                name = "eighteen";
                break;
            case 19:
                name = "nineteen";
                break;
            default:
                name = null;
                break;
        }
        return name;
    }


}