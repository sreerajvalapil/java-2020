package com.java8;

public class ClonableDemo implements Cloneable {

    private String dname;

    public ClonableDemo(String dname) {
        this.dname = dname;
    }

    public String getName() {
        return dname;
    }
    // Overriding clone() method of Object class
    public Object clone()throws CloneNotSupportedException{
        return (ClonableDemo)super.clone();
    }

    public static void main(String[] args) {
        ClonableDemo obj1 = new ClonableDemo("Tommy");
        try {
            ClonableDemo obj2 = (ClonableDemo) obj1.clone();
            System.out.println(obj2.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}