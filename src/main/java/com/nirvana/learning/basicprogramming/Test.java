package com.nirvana.learning.basicprogramming;


public class Test {


    //1. List of Integers
    //2. Factorial of all those nos.
    // 3. Square Root
    // Arrange in descending order

//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(2, 5, 7, 6, 4, 8);
//        Map<Integer, Float> collect = list.stream().map(n -> {
//            int num = factorial(n);
//            double sq = Math.sqrt(num);
//            return sq;
//        }).collect(Collectors.toMap(Double::intValue, Double::floatValue));
//        collect.forEach((integer, aFloat) -> System.out.println(integer+" "+aFloat));
//
//
//    }
//
//    private static int factorial(Integer n) {
//        if (n == 0 || n == 1) {
//            return 1;
//        }
//        if (n < 0) {
//            return 1;
//        }
//        return n * factorial(n - 1);
//    }

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        List<String> nameList = new ArrayList<>();
//        for (String emailId : map.keySet()) {
//            if (emailId.contains("@gmail.com")) {
//                nameList.add(emailId);
//            }
//        }
//       Collections.sort(nameList);
//        nameList.forEach(System.out::println);

//        String[] str = {"Krishna", "Verma"};
//        String[] str1 = {"Pooja", "Verma"};
//        Set<String> set = new HashSet<>();
//        for (String string : str) {
//            set.add(string);
//        }
//        for (String string : str1) {
//            set.add(string);
//        }
//        String[] result = set.toArray(new String[0]);
//        Arrays.stream(result).forEach(val -> System.out.println(val));

        String email = "krisv.nit16@gmail.com";
        String[] emailArr = email.split("@");
        String emailSubstr = emailArr[0] + "_" ;
        email = emailSubstr + emailArr[1];
        System.out.println(email);
    }
}
