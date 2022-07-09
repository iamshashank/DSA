package com.company;

public class Google_HARD_WierdBinarytree {
    TreeNode root;
    private class TreeNode{
        public TreeNode left = null, right = null;
        public int len;
        public String val;
        public boolean isLeaf = false;

        TreeNode(int l){
            this.len = l;
        }
        TreeNode(String val){
            this.val = val;
            this.len = val.length();
            this.isLeaf = true;
        }
    }

    private char charAt(int i){
        if(i > root.len) return '\0';
        TreeNode node = root;
        while(node != null){
            if(node.isLeaf) return node.val.charAt(i);

            if(i < node.left.len){
                node = node.left;
            }else{
                int l = 0;
                if(node.left != null) l = node.left.len;
                i = i-l; // we are skipping i-l char in left subtree
                node = node.right;
            }
        }
        return '\0';
    }

    private String substring_at(int l, int r){
        // iterate till entire substring is on same subtree
        TreeNode node = root;
        return substring(node, l,r);
    }

    private String substring(TreeNode node, int l, int r){
        if(node.isLeaf) return node.val.substring(l,r+1);
        int size = r-l+1;
        while(node.len >= size){
            if(node.isLeaf){
                return node.val.substring(l,r+1);
            }

            if(node.left != null && node.left.len >= size){
                node = node.left;
                continue;
            }

            break; // now we have split
        }
        // number of char to find in left tree

        int x = 0;
        String left = "", right = "";
        if(node.left != null) {
            x = node.left.len - l;
            left = substring(node.left, l, node.left.len - 1);
        }
        if(node.right != null){
            right = substring(node.right, 0, size-x-1);
        }
        return left+right;
    }

    public void setup(){
        root = new TreeNode(26);
        root.left = new TreeNode("ABCDE");
        root.right = new TreeNode(21);
        root.right.left = new TreeNode("FGHIJKLMNO");
        root.right.right = new TreeNode("PQRSTUVWXYZ");
        System.out.println(charAt(0));
        System.out.println(charAt(4));
        System.out.println(charAt(6));
        System.out.println(charAt(15));
        System.out.println(charAt(25));
        System.out.println(substring_at(0,4));
        System.out.println(substring_at(4,15));
        System.out.println(substring_at(4,22));
        System.out.println(substring_at(0,25));
    }
}
