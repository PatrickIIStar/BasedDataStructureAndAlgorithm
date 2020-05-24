package com.patrick.darastructure.tree.banlancedbinarysorttree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 8:58
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

    public void setVal(int val) {
        this.val = val;
    }
}
