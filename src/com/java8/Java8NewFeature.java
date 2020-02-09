package com.java8;

public class Java8NewFeature {

    public static void main (String args[]) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The thread program executing ................");
            }
        });

        t.start();


        Runnable run = ()-> {
            System.out.println(" This is thred program ");
        } ;

        Thread t1 = new Thread(run) ;



    }
}
