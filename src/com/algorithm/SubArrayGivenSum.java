package com.algorithm;

public class SubArrayGivenSum {

    public static void  main(String args[]) {
        int[] input = {0,4,12,2,10,6,9,13,3,11,7,15} ;
        int sum = 14;

        new SubArrayGivenSum().findGivenSum1(input,sum);
        new SubArrayGivenSum().findGivenSum2(input,sum);


    }

    public void findGivenSum1(  int[] input, int sum ) {
        int curr_sum ;
        for(int i=0;i<input.length ;i++) {
            curr_sum = input[i];
            for (int j=i+1;j<input.length ;j++) {

                curr_sum = curr_sum + input[j] ;
                if(curr_sum == sum) {
                    System.out.println("The sub Array range for current sum is : "+i +"" +j);
                }
            }
        }

    }



    public void findGivenSum2( int[] input, int sum ) {

        int curr_sum = input[0];
        int start = 0 ;
        for (int i=1;i<input.length ;i++) {


            if(curr_sum>sum && start<i-1) {
                curr_sum = curr_sum - input[start];
                start ++ ;
            }

            curr_sum = curr_sum + input[i];


/*

            if(curr_sum>sum && start <i-1) {
                curr_sum = curr_sum - input[start] ;
                start ++ ;
            }
            if(curr_sum == sum) {
                System.out.println("found sum at : " + start +"" + i);
            }

            curr_sum = curr_sum + input[i];
*/

        }

    }

}
