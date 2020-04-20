package com.practice;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        new ConsumerTest().method1();
    }

    private void method1() {
        Consumer<Bank> bankConsumer = (bank)-> {
           bank.setCountryName("India");
           bank.setRbiName("Reserve Bank India");
        } ;

        Bank hdfc = new Bank(199,"New Helhi");
        Bank icic = new Bank(200,"Mumbai");
        bankConsumer.accept(hdfc);
        bankConsumer.accept(icic);



    }
}

class Bank{
    private String countryName ;
    private String rbiName;
    private int bankCode;
    private String bankHeadLocation;


    public Bank(String countryName, String rbiName) {
        this.countryName = countryName;
        this.rbiName = rbiName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Bank(int bankCode, String bankHeadLocation) {
        this.bankCode = bankCode;
        this.bankHeadLocation = bankHeadLocation;
    }

    public void setRbiName(String rbiName) {
        this.rbiName = rbiName;
    }
}
