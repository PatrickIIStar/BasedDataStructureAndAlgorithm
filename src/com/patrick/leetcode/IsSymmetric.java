package com.patrick.leetcode;

import com.patrick.darastructure.tree.binarysorttree.TreeNode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/19 10:01
 * @declaration  判断二叉树是否对称
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root){
        return root==null||isMirror(root.left,root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q){
        if (p==null&&q==null){
            return true;
        }
        if (p==null||q==null){
            return false;
        }
        return p.getVal()==q.getVal()&&isMirror(p.left,q.right)&&isMirror(p.right,q.left);
    }
}
