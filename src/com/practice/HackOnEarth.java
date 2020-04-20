package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HackOnEarth {
    public static void main(String[] args) {
        //sockMerchant(10,new int[]{10,2,15,34,78,2,15,87,34,10});
       // countingValleys(8,"UDDDUDUU");
        jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}) ;

/*        -9 -9 -9  1 1 1
        0 -9  0  4 3 2
                -9 -9 -9  1 2 3
        0  0  8  6 6 0
        0  0  0 -2 0 0
        0  0  1  2 4 0*/

     int[][] arr= new int[][]{
             { -9 ,-9, -9 , 1, 1, 1},
             { 0 ,-9, 0 , 4, 3, 2},
             { -9 ,-9, -9 , 1, 2, 3},
             { 0 ,0, 8 , 6, 6, 0},
             { 0 ,0, 0 , -2, 0, 0},
             { 0 ,0, 1 , 2, 4, 0}} ;

        int[][] arr1= new int[][]{
        { -1, -1, 0 ,-9 ,-2 ,-2},
            {       -2 ,-1, -6, -8, -2, -5},
                {   -1 ,-1, -1, -2, -3, -4},
                    {-1 ,-9, -2, -4, -4, -5},
                        {-7 ,-3, -3, -2, -9, -9},
                            {-1, -3, -1, -2, -4, -5}};


        System.out.println("max hour glass sum is : " + hourglassSum(arr1));
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        List<Integer> myList = Arrays.stream(ar).boxed().collect(Collectors.toList());
        Map<Integer,Long> myMap =
                myList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long result = myMap.entrySet().stream()
                .map(integerLongEntry -> integerLongEntry.getValue()/2)
                .reduce(0l, Long::sum);
        return (int)result;
        /*
        System.out.println("Result is ... : "+result);
        System.out.println("Result 1 ... : "+1/2);

        List<Integer> sortedList = myList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        sortedList.stream().forEach(System.out::println);*/



    }

    // Complete the countingValleys function below.

    static int countingValleys(int n, String s) {
    char[] charArray = s.toCharArray();
    int result = 0;
    int level = 0;
    for(int i =0 ;i<charArray.length;i++ ) {
        if(charArray[i] =='D') {
            level --;
        }
        if(charArray[i] =='U') {
            level ++;
        }
        if(charArray[i] =='U' && level ==0) {
            result ++ ;
        }
    }
    return result;
    }

   // Complete the jumpingOnClouds function below.
   //jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}) ;
    static int jumpingOnClouds(int[] c) {
        int minJumps = 0 ;
        int i = 0 ;
        while(i <c.length ) {
            if(i==c.length-1)
                break;
            if(i+2 <c.length && c[i+2] == 0) {
                i = i +2;
                minJumps ++;
            } else if (i+1 <c.length  && c[i+1] == 0) {
                i ++;
                minJumps ++ ;
            }
        }
        return minJumps ;
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

    long charCount = s.chars().filter(char1->char1=='a').count();
    long lengthOfS = s.length();
    if(n>lengthOfS) {
        charCount = charCount * (n/lengthOfS) ;
        long r = n % lengthOfS;
        charCount = charCount + s.substring(0,(int)r)
                .chars().filter(char1->char1=='a').count();

    } else if ( n< lengthOfS) {
        charCount= s.substring(0,(int)n)
        .chars().filter(char1->char1=='a').count();
    }

    return charCount ;
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    int length = q.length;
    int i = 1 ;
   /* while(length) {

    }*/
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int result  = 0 ;
        for(int i = 0 ; i<6 ; i ++) {
            for ( int j = 0;j<arr[i].length  ;j ++) {
                if(i<4 && j <4) {
                    int currentSum = findSum(arr,i,j) ;
                  System.out.println(" Sum at " +i + " and " +j+ " is " +currentSum);
                    if(currentSum>result) {
                        result = currentSum ;
                    }
                }
            }
        }
        return result ;
    }

    private static int findSum(int[][] arr,int a, int b) {
        int sum = Integer.MIN_VALUE ;
        for(int i = a ; i<a+3 ; i ++) {
            for ( int j = b;j<b +3  ;j ++) {
            if(!(i == a+1 && j ==b) && !(i == a+1 && j ==b+2)) {
                System.out.println(" summing ...................... : " + arr[i][j]);
                sum = sum + arr[i][j] ;
            }
            }
        }
        return sum ;
    }


}
