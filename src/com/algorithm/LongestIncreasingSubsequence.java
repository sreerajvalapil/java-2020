package com.algorithm;

public class LongestIncreasingSubsequence {

    public static void  main(String args[]) {
        System.out.println("Good morning .......... LIS program");
        int[] input = {0,4,12,2,10,6,9,13,3,11,7,15} ;
        new LongestIncreasingSubsequence().computeLIS(input);
        //https://www.youtube.com/watch?v=E6us4nmXTHs

    }

    public void computeLIS(int[] input) {
        int l = input.length;
        System.out.println("lis : " + lis(input,l));

    }

    public int lis(int[] input,int length) {
        if(length == 1)
            return 1;
        int max_lis = 1 ;
        for (int i=1;i<length ;i++) {
            int res = lis(input,i);

            if(input[i-1]<input[length-1] && res +1 > max_lis ) {
                max_lis = res +1 ;
            }
        }
       System.out.println(" lis at length : " + length + " is .. :" +max_lis);
        return  max_lis;
    }


}
