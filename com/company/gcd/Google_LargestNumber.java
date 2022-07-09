package com.company.gcd;

/**
 * Give ans rray if integer arr = [2,3,8,6]
 * 1. For each pair of integers from arr find absolute diff between 2 and if that is not present in the array put it in arr
 * 2. repeat step 1 till no new number can be added to them arr
 */


/**
 * This is trick question what we need to observe that the final arr will contains alll numbers which are multiple of GCD of the org array
 * so in above sample the GCD is 1 (smallest number which can divide all the numbers in the array)
 * so final arr will be [0*1, 1*1, 2*1, 3*1 , 4,5,6,7,8]
 * and if you need the Kth largest numbr in final arr it will = (len(final_arr)-k)*GCD
 * final arr will have max(arr)/GCD + 1 elements
 */

public class Google_LargestNumber {

    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public int largestNumber(int[] a, int k){
        int max = a[0];
        int gcd = a[0];
        for(int v =1;v<a.length;v++){
            int i = a[v];
            gcd = gcd(gcd, i);
            max = Math.max(max, i);
        }
//        System.out.println("GCD "+ gcd);
//        System.out.println("MAX "+ max);
        int lenOfFinalArr = (max/gcd)+1;
        return (lenOfFinalArr-k)*gcd;
    }
}
