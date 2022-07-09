package com.company.prefixtree_trie;

/**
 * The distance between 2 binary strings is the sum of their lengths after removing the common prefix.
 * For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.
 *
 * Given a list of binary strings, pick a pair that gives you maximum distance among all possible pair and return that distance.
 */

public class Google_DistanceBetween2BinaryString {
    public int findLength(String[] a){
        BinaryTrie b = new BinaryTrie(a);
        return b.maxDistance;
    }

    private class BinaryTrie{
        private TreeNode root;
        int maxDistance;
        BinaryTrie(String[] a){
            root = new TreeNode('\0'); // null
            for(String t : a) insert(t);
            maxDistance = 0;
            maxDist();
        }

        private void insert(String a){
            TreeNode curr = root;
            for(char c : a.toCharArray()){
                if(c == '0'){
                    if(curr.left == null){
                        TreeNode t = new TreeNode(c);
                        curr.left = t;
                    }
                    curr = curr.left;
                }else{
                    if(curr.right == null){
                        TreeNode t = new TreeNode(c);
                        curr.right = t;
                    }
                    curr = curr.right;
                }
            }
            curr.end = true;
        }

        private int findDist(TreeNode node){
            if(node == null) return 0;
            int l = findDist(node.left);
            int r = findDist(node.right);

            // whenever there is split into left and right we take a measurement
            // or where a node ends for cases like 11001, 110 in this case answer is 2
            if(node.end || (node.right != null && node.left != null))
                maxDistance = Math.max(maxDistance, l+r);

            return 1 + Math.max(l,r);
        }

        private int maxDist(){
            return this.findDist(root);
        }
    }

    private class TreeNode{
        char c;
        // left is 0 and right is 1
        TreeNode left = null, right = null;
        boolean end = false;
        TreeNode(char c){
            this.c = c;
        }
    }

}
