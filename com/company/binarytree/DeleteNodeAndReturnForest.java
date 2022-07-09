package com.company.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndReturnForest {
    Set<Integer> set;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for(int i =0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        ans = new ArrayList<>();
        ans.add(root);
        for(int i =0;i<ans.size() && set.size() > 0;i++){
            // TreeNode t = ans.get(i);
            // if(set.contains(t.val)){
            //   ans.remove(i);
            //   set.remove(t.val);
            // }
            TreeNode t = dfs(ans.get(i));
            if(t == null){
                ans.remove(i);
                i--; // this is part of the trick
            }
        }
        return ans;
    }

    public TreeNode dfs(TreeNode root){
        if(root == null) return null;
        if(set.contains(root.val)){
            set.remove(root.val);
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }else{
            root.left = dfs(root.left);
            root.right = dfs(root.right);
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
