package com.company.dfs;

/**
 * https://www.youtube.com/watch?v=VZvU1_oPjg0
 * 753. Cracking the Safe
 * Hard
 *
 * There is a safe protected by a password. The password is a sequence of n digits where each digit can be in the range [0, k - 1].
 *
 * The safe has a peculiar way of checking the password. When you enter in a sequence, it checks the most recent n digits that were entered each time you type a digit.
 *
 *     For example, the correct password is "345" and you enter in "012345":
 *         After typing 0, the most recent 3 digits is "0", which is incorrect.
 *         After typing 1, the most recent 3 digits is "01", which is incorrect.
 *         After typing 2, the most recent 3 digits is "012", which is incorrect.
 *         After typing 3, the most recent 3 digits is "123", which is incorrect.
 *         After typing 4, the most recent 3 digits is "234", which is incorrect.
 *         After typing 5, the most recent 3 digits is "345", which is correct and the safe unlocks.
 *
 * Return any string of minimum length that will unlock the safe at some point of entering it.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 2
 * Output: "10"
 * Explanation: The password is a single digit, so enter each digit. "01" would also unlock the safe.
 *
 * Example 2:
 *
 * Input: n = 2, k = 2
 * Output: "01100"
 * Explanation: For each possible password:
 * - "00" is typed in starting from the 4th digit.
 * - "01" is typed in starting from the 1st digit.
 * - "10" is typed in starting from the 3rd digit.
 * - "11" is typed in starting from the 2nd digit.
 * Thus "01100" will unlock the safe. "01100", "10011", and "11001" would also unlock the safe.
 *
 *
 *
 * Constraints:
 *
 *     1 <= n <= 4
 *     1 <= k <= 10
 *     1 <= kn <= 4096
 *
 */

public class CrackingTheSafe {
    int n, k;
    int[] v;
    String finalAnswer = "";
    int counter = 0;
    int totalNodes;
    public String crackSafe(int n1, int k1) {
        //de Bruijn Sequence
        // https://www.youtube.com/watch?v=VZvU1_oPjg0
        // we need to generate all possible numbers of N digits using 0 to K-1 digits
        // so 1 possible passowrd for this lock will be to append all possible numbers generated above into a long string
        // but we need to find the min len string
        // So in question this we have to generate the shortest string in which we can find all the posssible numbers generated above as a substring
        // so will 1st generate the long string using dfs and then we will shrink that string
        n = n1;
        k = k1;
        totalNodes = (int) Math.pow(k,n);
        v = new int[10009];
        String initial = "";
        for(int i=0;i<n;i++) initial += '0';
        if(k==1) return initial; // if only 1 digit available to use
        dfs(initial, "");
        return finalAnswer;
    }

    public void dfs(String node, String ans){
        // no need to search if we founf the finalAnswer
        // we only need 1 possible solution
        if(finalAnswer != "") return;

        if(counter == totalNodes){
//            System.out.println(ans.length());
            // now we apply our string compression logic
            // len of value at each node is `n` we keep the first number as it is and from the next we only remove first N-1 letters as they were copied from the prev number

            if(n==1){
                finalAnswer = ans;
                return;
            }
            String realAns = ans.substring(0, n); // keep the 1st node as it is
            int j = n;
            while(j<ans.length()){
                realAns += ans.substring(j+n-1, j+n);
                j = j+n;
            }
            finalAnswer = realAns;
            return;
        }

        for(int i =0;i<k;i++){
            // no need to search if we founf the finalAnswer
            // we only need 1 possible solution
            if(finalAnswer != "") return;

            // take the last N-1 char from current and add 1 of the possible [0..K-1] to form a new node in graph
            // our end game is to keep generating the new nodes and eventually generate all totalNodes and traverse them once
            String newNode = node.substring(1);

            newNode += i;
//            System.out.println(newNode);
            int newNodeInt = (newNode == "") ? 0 : Integer.parseInt(newNode);
            if(v[newNodeInt] == 1) continue; // we have already generated and visited this node
            v[newNodeInt] = 1;
            counter++;
            String tempAns = ans + newNode; // append to the long answer generated with this path
            dfs(newNode, tempAns);
            // backtracking since we are geenarting all new nodes using recusrion
            counter--; v[newNodeInt] = 0;
        }

    }
}
