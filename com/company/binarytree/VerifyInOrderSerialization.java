package com.company.binarytree;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * Medium
 *
 * One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
 *
 * Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
 *
 * It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid.
 *
 *     For example, it could never contain two consecutive commas, such as "1,,3".
 *
 * Note: You are not allowed to reconstruct the tree.
 *
 *
 *
 * Example 1:
 *
 * Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 *
 * Example 2:
 *
 * Input: preorder = "1,#"
 * Output: false
 *
 * Example 3:
 *
 * Input: preorder = "9,#,#,1"
 * Output: false
 */

public class VerifyInOrderSerialization {
    public boolean isInorder(String inorder) {
        //n/2 , n/2-1
        String[] p = inorder.split(",");
        if(p.length%2 == 0) return false;

        // it has to be ODD len
        for(int i= p.length-1;i>=0;i--){
            // start from last and see parent of each
            // if parent also # then invalid node
            int  parent;
            if(i%2 == 0){
                parent = (i/2) -1;
            }else{
                parent = i/2;
            }
            if(p[parent] == "#") return false;
        }
        return true;
    }


    public boolean preOrder(String preorder){
        String[] s = preorder.split(",");
        Stack<String> st = new Stack<>();
        for(String c : s){
            st.push(c);
            while(st.size()>2){
                String s1 = st.pop();
                String s2 = st.pop();
                if(s1.equals("#") && s2.equals("#")){
                    String s3 = st.pop();
                    if(s3.equals("#")) return false;
                    st.push("#");
                }else{
                    // put them back
                    st.push(s2);// first s2 will go
                    st.push(s1);
                    break;
                }
            }
            System.out.println(st);
        }

        return st.size() == 1 && st.peek().equals("#");
    }

}