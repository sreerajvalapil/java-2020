package com.java10;
import java.util.*;

public class BuyAndSellGold  {

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
