package com.string;

public class StringHandling {
    public static void main(String args[]) {
        String s = "\"VIDA\",\"Disturbance\"" ;
        String[] aa = s.replace("\"","").split(",");

        String[] aa1 = s.split("\",\"");

        System.out.println(aa1[0]); System.out.println(aa1[1]);

    }
}
