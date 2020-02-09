package com.capgemini;

import java.math.BigInteger;
import java.util.*;

public class UniqueAnagramTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BigInteger> results = new ArrayList<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            results.add(getUniqueAnagramCount(input));
        }
        results.stream().forEach(System.out::println);
    }

    private static BigInteger getUniqueAnagramCount(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];
            if (map.containsKey(x)) {
                int count = map.get(x);
                count++;
                map.put(x, count);
            } else
                map.put(x, 1);
        }

        BigInteger result = findFactorial(chars.length);
        Set set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            char key = iterator.next();
            int count = map.get(key);
            BigInteger factorialCount = findFactorial(count);
            result = result.divide(factorialCount);
        }
        return result;
    }

    public static BigInteger findFactorial(int num) {
        if (num == 0)
            return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
