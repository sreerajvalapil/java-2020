package com.innerClass;

public class MemberInnerClass {

    public static void main (String args[]) {
        MemberInnerClass ob = new MemberInnerClass();
        SreeMemberInner aa =  ob.new SreeMemberInner();
    }

    class SreeMemberInner {
        public  void compute() {
            System.out.println("I am in the Member Inner class");
        }
    }



}
