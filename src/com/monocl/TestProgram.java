package com.monocl;

import java.util.HashMap;
import java.util.Map;

public class TestProgram {
    public static void main(String[] args) {
        System.out.println("Good morning ....");
        System.out.println("Result is ..... :" +new TestProgram().getHint("1807","7810"));
        System.out.println("Result profit  is ..... :" +new TestProgram().maxProfitEffective(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private void  test() {
        for (int i =0;i<=10;i ++) {

        }
        String s ="sreeraj" ;
    }

    private String getHint(String secret, String guess) {
    /* Input: secret = "1807", guess = "7810" ;
     Output: "1A3B" */
     int numberOfBull = 0 ;
     int numberOfCows = 0 ;
     char[] secretArray = secret.toCharArray();
     char[] guessArray = guess.toCharArray();
     Map<Character,Character> resultMap = new HashMap<>() ;
     for(int i = 0; i<secretArray.length ;i++) {
         //resultMap.put(secretArray[i],guessArray[i]) ;
         if(secretArray[i] == guessArray[i] ) {
             numberOfBull ++ ;
         } else {
             numberOfCows ++;
         }
     }
     return numberOfBull +"A"+numberOfCows+"B" ;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i =0;i<=prices.length;i++) {
            for(int j=i+1 ; j<prices.length ;j++) {
                if(prices[j]>prices[i]) {
                    int currentProfit = prices[j] -prices[i] ;
                    if(currentProfit>maxProfit) {
                        maxProfit = currentProfit ;
                    }
                }
            }
        }
        return maxProfit ;
    }

    public int maxProfitEffective(int[] prices) {
        int maxProfit= 0 ;
        int minPrice = prices[0];
        for(int i = 0 ; i< prices.length ; i ++) {
          if(prices[i] <minPrice) {
              minPrice = prices[i] ;
          } else if (prices[i] -minPrice > maxProfit) {
              maxProfit = prices[i] -minPrice ;
          }
        }
        return maxProfit ;
    }



}
