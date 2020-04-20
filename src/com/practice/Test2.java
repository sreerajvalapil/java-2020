package com.practice;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
     new Test2().myMethod2();
    }

    private void myMethod2() {
        Bank b1 = new Bank(100,"A",800) ;
        Bank b2 = new Bank(101,"B",1000) ;
        Bank b3 = new Bank(103,"C",100) ;
        Bank b4 = new Bank(104,"D",60) ;

       /* List<Bank> bankList = new ArrayList<>(Arrays.asList(b1,b2,b3,b4)) ;
        Collections.sort(bankList,
                (o1, o2) -> Integer.valueOf(o1.getBankRank()).compareTo(Integer.valueOf(o2.getBankRank())));

        Collections.sort(bankList,
                Comparator.comparing(o -> Integer.valueOf(o.getBankRank())));


        bankList.stream().forEach(bank -> System.out.println(bank.bankRank));*/

       Map<Integer,Bank> bankMap = new HashMap<>() ;
       bankMap.put(1,b1) ;
       bankMap.put(2,b2) ;
       bankMap.put(3,b3) ;
       bankMap.put(4,b4) ;
       Set<Map.Entry<Integer,Bank>> mapEntrySet = bankMap.entrySet();
      // Collections.sort(mapEntrySet,Comparator.comparing(o -> o.)

        Set<Integer> mySet = new HashSet<>() ;
        mySet.add(100) ;mySet.add(20) ;
        mySet.add(50) ;mySet.add(200) ;






    }

    public void example() {
    }

    class Bank{
        private String countryName ;
        private String rbiName;
        private int bankCode;
        private String bankHeadLocation;
        private int bankRank;

        public Bank(int bankCode, String bankHeadLocation, int bankRank) {
            this.bankCode = bankCode;
            this.bankHeadLocation = bankHeadLocation;
            this.bankRank = bankRank;
        }

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

        public int getBankRank() {
            return bankRank;
        }
    }
}
