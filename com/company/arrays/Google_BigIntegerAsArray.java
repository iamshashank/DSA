package com.company.arrays;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Google_BigIntegerAsArray {

    private class BigNumArray{
        public int[] val;
        private String sVal = null;
        final int sign;
        BigNumArray(String n){

            int posOrNeg = 1;
            int i = 0;
            if(n.charAt(0) == '-'){
                i = 1;
                posOrNeg = -1;
            }
            // remove zero in beginning
            while(i < n.length() && n.charAt(i) == '0'){
                i++;
            }
            if(i == n.length()){
                n = "0";
                posOrNeg = 0;
            }else{
                n = n.substring(i);
            }
            // set sign of the number
            sign = posOrNeg;

            sVal = n;
            val = new int[n.length()];
            for(i=0;i<n.length();i++){
                val[i] = Integer.valueOf(n.charAt(i)+"");
            }
        }

        BigNumArray(int[] a, int posOrNeg){
            int i = 0;
            while(i<a.length && a[i] == 0) i++;

            if(i == a.length){
                a = new int[]{0};
            }else{
                int j = 0;
                int[] x = new int[a.length-i];
                for(;i<a.length;i++) x[j++] = a[i];
                a = x;
            }
            sign = posOrNeg;
            val = a;
            sVal = "";
            for(i =0;i<a.length;i++) sVal += a[i];
        }

        public BigNumArray add(BigNumArray b){
            if(b.sign == 0) return new BigNumArray(sVal);
            if(sign == 0) return new BigNumArray(b.sVal);

            if(sign == b.sign) return new BigNumArray(add(this, b), sign);
            // sign not same
            int cmp = compareMagnitude(b);
            if(cmp == 0) return new BigNumArray("0");
            if(cmp == 1){
                return new BigNumArray(subtract(this, b), sign);
            }else{
                return new BigNumArray(subtract(b, this), b.sign);
            }
        }

        private int[] add(BigNumArray a, BigNumArray b){
            int i = a.val.length-1, j = b.val.length-1;
            int[] ans = new int[Math.max(a.val.length,b.val.length)+1];
            int k = ans.length-1;
            while(i>=0 && j >= 0){
                int t = val[i--]+b.val[j--] + ans[k];
                ans[k] = t%10;
                if(t>9) ans[k-1] = 1;
                k--;
            }
            while(i>=0){
                int t = val[i--]+ans[k];
                ans[k] = t%10;
                if(t>9) ans[k-1] = 1;
                k--;
            }
            while(j>=0){
                int t = b.val[j--]+ans[k];
                ans[k] = t%10;
                if(t>9) ans[k-1] = 1;
                k--;
            }
            return ans;
        }

        public BigNumArray subtract(BigNumArray b){
            if(b.sign == 0) return new BigNumArray(this.val, this.sign);
            if(sign == 0) return new BigNumArray(b.val, -1*this.sign);
            int cmp = compareMagnitude(b);
            if(cmp == 1){
                // a is greater
                if(sign == 1 && b.sign == 1) return new BigNumArray(subtract(this, b), sign);
                if(sign == 1 && b.sign == -1) return new BigNumArray(add(this, b), sign);
                if(sign == -1 && b.sign == 1) return new BigNumArray(add(this, b), sign);
                if(sign == -1 && b.sign == -1) return new BigNumArray(subtract(this, b), sign);
            }else{
                if(sign == 1 && b.sign == 1) return new BigNumArray(subtract(b, this), -1*b.sign);
                if(sign == 1 && b.sign == -1) return new BigNumArray(add(this, b), -1*b.sign);
                if(sign == -1 && b.sign == 1) return new BigNumArray(add(this, b), -1*b.sign);
                if(sign == -1 && b.sign == -1) return new BigNumArray(subtract(b, this), -1*b.sign);
            }
            return null;
        }
        private int[] subtract(BigNumArray a, BigNumArray b){
            int[] A = a.val.clone();
            int i = a.val.length-1, j = b.val.length-1, k = a.val.length-1;
            int[] ans = new int[a.val.length]; // a is always greater

            while(i>=0 || j>=0){
                int x = i < 0 ? 0 : A[i--];
                int y = j < 0 ? 0 : b.val[j--];
                int t = x-y;
                if(t<0) {
                    t += 10;
                    A[i] = A[i]-1;
                }
                ans[k--] = t;
            }
            return ans;
        }

        private int compareMagnitude(BigNumArray b){
            if(val.length > b.val.length){
                return 1;
            }else if(val.length < b.val.length){
                return -1;
            }else{
                // both equal
                return sVal.compareTo(b.sVal);
            }
        }

        public String toString(){
            if(sign == -1) return "-"+sVal;
            return sVal;
        }
    }

    public void setup(){
        BigNumArray a = new BigNumArray("-7777");
        BigNumArray b = new BigNumArray("-77");
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
    }
}
