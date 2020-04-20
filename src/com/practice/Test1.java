package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("Good morning");
       // new Test1().myMethod();
        new Test1().mythod2() ;
    }

    private void mythod2() {
        String s = "Sreeraj thi valapil" ;
       char[] array1 =  s.toCharArray();
        for(int i =0;i<array1.length ;i++) {
            //System.out.println("Charecter is ... :" +array1[i]);
        }
        Integer[] array2 = new Integer[] {67,23,45,9,1,34} ;
        Arrays.sort(array2);

        //System.out.println("Sorting Result is .. :");
        //Arrays.asList(array2).stream().forEach(System.out::println);

        String[] strArray = new String[] {"John", "Mary", "Bob"};
       // Stream.of(strArray).forEach(System.out::println);
        //foreach consumer
        //filter predicate
        //map Function


        List<String> l3 = Stream.of(strArray).filter(Objects::nonNull)
                .map(s1 -> s1+"123")
                .collect(Collectors.toList());
        l3.stream().forEach(System.out::println);




    }


    private void myMethod() {
        //combine two array to third array
        Integer[] array1 = new Integer[] {1,56,78,23} ;
        Integer[] array2 = new Integer[] {1,56,78,23} ;
        System.arraycopy(array1,0,array2,array2.length-1,array1.length);
        System.out.println("Array1 length is ... :" + array1.length);
        System.out.println("Array2 length is ... :" + array2.length);

        List<Integer> list1 = Arrays.asList(array1);
        List<Integer> list2 = Arrays.asList(array2);
       // list1.addAll(list2) ;

        List<Integer> lis3 = Arrays.asList(12,23) ;
        List<Integer> lis4 = Arrays.asList(12,23,45,66) ;
        //lis3.add(1212);
        List<Integer> list5 = new ArrayList<>();list5.add(10);
        List<Integer> list6 = new ArrayList<>();list5.add(12) ;
        list5.addAll(list6);

        System.out.println("Done");

    }
}
