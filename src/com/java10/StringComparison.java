package com.java10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringComparison {
    public static void main(String[] args) {
        String s = "" ;
        System.out.println("aaaaaaaaa");

        //System.out.println("REsult : " +new StringComparison().indexOfDeviation("abc","abcd") );;

        System.out.println("REsult : " +new StringComparison(). string_contains("abc","abcd") );;


    }

    /**
     * Question 2: Returns the index at which 2 strings are unequal. Otherwise returns
     * -1.
     */
    public int indexOfDeviation(String str2, String str1) {
        char[] a = str2.toCharArray();
        char[] b = str1.toCharArray();
        // Write your code here
        if(!str2.equals(str1)) {
            int shorterLength = Math    .min(a.length, b.length);
            for (int i = 0; i < shorterLength; i++)
            {
                if (a[i] != b[i]) return i;
            }
            if (a.length != b.length) return shorterLength;
            return -1;
        }
        return -1;
    }

    /**
     * Question 3: Return a comma delimited, alphanumerically sorted, string of all the
     * common characters between two strings. Repeat characters do not need to be
     * included.
     */
    public String string_contains(String str2, String str1) {
        // Write your code here
        Set<String> charsSet1 = str2.chars()
                .mapToObj(Character ::toString).collect(Collectors.toSet());
        Set<String> charsSet2 = str1.chars()
                .mapToObj(Character ::toString).collect(Collectors.toSet());
        charsSet2.retainAll(charsSet1);

        List<String> charList = charsSet2.stream().sorted().collect(Collectors.toList());
        return charList.stream()
                .collect(Collectors.joining(","));
    }


}
