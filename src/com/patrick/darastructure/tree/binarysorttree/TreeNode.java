package com.patrick.darastructure.tree.binarysorttree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/18 9:04
 * @declaration
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
