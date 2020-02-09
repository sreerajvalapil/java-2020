package com.innerClass;

public class StaticInnerClass {

    public static void main (String args[]) {
        // 1. One way to call function
        new SreeInner().printValues();
    }

    public void processMainClassFunction() {
        StaticInnerClass obj= new StaticInnerClass();
        StaticInnerClass.SreeInner innerObj = new StaticInnerClass.SreeInner();

        // 2. Second way to call function
        innerObj.printValues();

    }

    static class SreeInner {
        public void printValues() {
            System.out.println("This is awsome.......");
        }
    }
}
