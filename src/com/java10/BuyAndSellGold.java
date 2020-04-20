package com.java10;
import java.util.*;

public class BuyAndSellGold  {

    int dayToBuy = 0 ;
    int dayToSell = 0;

    public static void main(String[] args) {
        new BuyAndSellGold();
    }

    public BuyAndSellGold() {
        // You can initiate and calculate things here
        int buyDay = getBuyDay();
        int sellDay = getSellDay() ;

        int totalNumberOfDays = 10 ;
       // int totalNumberOfDays = API.getNumDays() ;
        int[] priceArray = new int[totalNumberOfDays];
       /* for(int i = 0 ;i<totalNumberOfDays ;i++) {
            int priceForDay = API.getPriceOnDay(i);
            priceArray[i] = priceForDay ;
        }*/

        priceArray = new int[]{10, 2, 45, 78, 23};

        int maxProfit = findMaxProfit(priceArray) ;
        System.out.println("max profit  is : " + maxProfit) ;
        System.out.println("day to buy  : " + dayToBuy) ;
        System.out.println("day to sell : " + dayToSell) ;
    }

    public int findMaxProfit(int prices[]) {
        int minprice =prices[0];
        int minPriceIndex = 0;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minPriceIndex = i ;
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
                dayToSell = i ;
                dayToBuy = minPriceIndex ;
            }
        }
        return maxprofit;
    }


    public int getSellDay() {
        return dayToSell;
    }

    public int getBuyDay() {
        return dayToBuy ;
    }


}
/*
public class BuyAndSellGold implements SolutionInterface {
    public BuyAndSellGold() {
        // You can initiate and calculate things here
        int buyDay = getBuyDay();
        int sellDay = getSellDay() ;

        int totalNumberOfDays = API.getNumDays() ;
        int[] priceArray = new int[totalNumberOfDays];
        for(int i = 0 ;i<totalNumberOfDays ;i++) {
            int priceForDay = API.getPriceOnDay(i);
            priceArray[i] = priceForDay ;
        }

        int maxProfit = maxProfit(priceArray) ;
        System.out.println("REsult is : " + maxProfit) ;
    }

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


    */
/**
     * Return the day which you buy gold. The first day has number zero. This method is
     * called first, and only once.
     *//*

    public int getBuyDay() {
        int result = 0 ;

        int totalNumberOfDays = API.getNumDays() ;
        int[] priceArray = new int[totalNumberOfDays];
        for(int i = 0 ;i<totalNumberOfDays ;i++) {
            int priceForDay = API.getPriceOnDay(i);
            priceArray[i] = priceForDay ;
        }


        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
                result = i ;
            }

        }


        return result;
    }

    */
/**
     * Return the day to sell gold on. This day has to be after (greater than) the buy
     * day. The first day has number zero (although this is not a valid sell day). This
     * method is called second, and only once.
     *//*

    public int getSellDay() {
        // Write your code here
        return -2;
    }
}
*/
