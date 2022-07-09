package com.company.string;

/**
 *
 * 482. License Key Formatting
 * Easy
 *
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 *
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 *
 * Return the reformatted license key.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 *
 * Example 2:
 *
 * Input: s = "2-5g-3-J", k = 2
 * Output: "2-5G-3J"
 * Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 *
 */

public class Google_LicensekeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        int c = 0;
        String withoutDash = "";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) =='-') {
                c++;
            }else{
                withoutDash += s.charAt(i);
            }
        }
        int numOfChar = withoutDash.length();
        if(numOfChar == 0) return "";
        int charLeft = numOfChar%k; // char left for 1st group
        int fullSizeGroup = numOfChar/k;
        String ans = "";
        if(charLeft > 0){
            ans = withoutDash.substring(0, charLeft);
            ans = ans + "-";
        }

        int t = 0;
        for(int i = charLeft; i<withoutDash.length();i++){
            if(t == k){
                ans = ans + "-";
                t = 0;
            }
            ans = ans + withoutDash.charAt(i);
            t++;
        }
        if(ans.charAt(ans.length()-1) == '-'){
            ans = ans.substring(0, ans.length()-1);
        }
        return ans.toUpperCase();
    }
}
