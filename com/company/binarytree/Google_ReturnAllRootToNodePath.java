package com.company.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A binary tree, return all root-to-node paths. For example,
 * 1
 * / \
 * 2 3
 * \
 * 5
 * return : ["1","12","125","13"]
 */

public class Google_ReturnAllRootToNodePath {

    String pathToString(List<Integer> path){
        String t = "";
        for(int i : path) t += i;
        return t;
    }
    ArrayList<String> ans;
    void dfs(TreeNode node, List<Integer> path){
        if(node == null){
            return;
        }
        path.add(node.val);
        ans.add(pathToString(path));
        dfs(node.left, path);
        dfs(node.right, path);
        path.remove(path.size()-1);
    }

    public void setup(){
        ans = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        dfs(root, new ArrayList<>());
        System.out.println(ans);
    }

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
}
