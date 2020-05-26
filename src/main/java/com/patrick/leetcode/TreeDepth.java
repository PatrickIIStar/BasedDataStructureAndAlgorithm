package main.java.com.patrick.leetcode;

import main.java.com.patrick.darastructure.tree.binarysorttree.TreeNode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/19 10:05
 * @declaration  二叉树的最大深度和最小深度
 */
public class TreeDepth {
    public static int maxDepth(TreeNode root){
        int leftDepth = 0;
        int rightDepth = 0;
        if (root==null){
            return 0;
        }
        if (root.left!=null){
            leftDepth = maxDepth(root.left);
        }
        if (root.right!=null){
            rightDepth = maxDepth(root.right);
        }
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }


    public static int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        if (root.left!=null&&root.right==null){
            return 1+minDepth(root.left);
        }
        if (root.right!=null&&root.left==null){
            return 1+minDepth(root.right);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
