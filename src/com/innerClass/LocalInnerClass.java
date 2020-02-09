package com.innerClass;

public class LocalInnerClass {

    public static void main (String args[]) {

    }

    public void process() {
        // Local Inner class
        class Sree {
            public void compute() {
                System.out.println("Good morning......");
            }
        }

        Sree ob = new Sree();
                ob.compute();

    }

    public void process2() {

    }

}
