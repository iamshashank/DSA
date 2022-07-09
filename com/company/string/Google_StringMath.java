package com.company.string;

/**
 * I was asked this question on a google onsite. Given an index and an input string find the char at the given index of the string.
 * But here's the catch: if the index exceeds the length of the string, then you transform the string by removing the string's last character
 * and appending it to the front and appending this transformed string to the original string until you have a string length that exceeds the desired index.
 *
 * For example,if we have a string "abcd" and want to find the char at index 3 it would obviously be 'd'.
 * However, if we want to find the char at index 7 of "abcd" we would transform "abcd" to "abcddabc" and the char would be 'c'.
 * If we want to find the char at index 12 of "abcd" we would transform "abcd" to "abcddabc" and then again
 * transform to "abcddabccabcddab" and the char would be 'd.
 */


/**
 * O(1) solution
 * Let's take s = 'abcd' as an example.
 *
 *     Do the operation transform the string by removing the string's last character and appending it to the front for several times.
 *     (abcd)(dabc)(cdab)(bcda) (abcd)(dabc) ...
 *     Then, we can perform the operation len(s) times to get the original s.
 *     Also, the length of the repeated pattern is len(s) * len(s). (ex: abcd -> abcddabccdabbcda)
 *     So, we can do index % (len(s) ** 2)to get the position in the repeated pattern.
 *
 *     Let's observe the position of the character 'a' in the repeated pattern 'abcddabccdabbcda'.
 *     We can found that in the first part 'abcd', 'a' is at the position 0.
 *     In the second part 'dabc', 'a' is at the position 1.
 *     Then the position of 'a' increment at third part and increment again at the forth part.
 *     The character 'b' also has the same behavior but it starts from position 1, then 2 -> 3 -> 0.
 *     'c' : 2 ('abcd') -> 3 ('dabc') -> 0 ('cdab') -> 1 ('bcda')
 *     Therefore, we do nth_group, res = divmod(idx_in_square_n, len(s)).
 *     if nth_group == 0, which means that the answer is in the first part 'abcd', and res is the position of the answer in the 'abcd'.
 *     if nth group == 1 and res == 3, then the answer is s[res - nth_group] since 'dabc'[3]  (if we reverse this) -> 'abcd'[2].
 */
public class Google_StringMath {
    public char getChar(String s, int i){
        if(i<s.length()) return s.charAt(i);

        // the string will repeat when new len = len(s)*len(s)
        // (group1)(group2)(group3)(group4)| now repeating
        // (abcd)  (dabc)  (cdab)  (bcda)  |(abcd)... repeating
        int indexInNonRepeatingPortion = i % (s.length()*s.length());
        int group = indexInNonRepeatingPortion/s.length();
        int indexInGroup = indexInNonRepeatingPortion%s.length();
        int adjustedIndex = indexInGroup-group; // since we are not calculating the groups we adjust so that we can find the char from the group1
        if(adjustedIndex<0) adjustedIndex += s.length(); // rotating in reverse
        return s.charAt(adjustedIndex);
    }
}
