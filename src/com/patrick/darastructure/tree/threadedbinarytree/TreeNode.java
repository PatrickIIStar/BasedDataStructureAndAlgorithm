package com.patrick.darastructure.tree.threadedbinarytree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 10:24
 * @declaration  二叉树结点
 */
public class TreeNode {
    private int key;
    public TreeNode left;
    public TreeNode right;
    public boolean isThreadLeft = false; // 指向左子树为false, 指向前驱为true
    public boolean isThreadRight = false; // ---右子树 false, 后继 true

    public TreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void midOrder(TreeNode node) {
        if (node.left != null) {
            midOrder(node.left);
        }

        System.out.println(node.toString());

        if (node.right != null) {
            midOrder(node.right);
        }
    }

    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.toString());
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public TreeNode preSearch(TreeNode node, int key) {
        TreeNode temp = null;
        if (node.getKey() == key) {
            return node;
        }

        if (node.left != null) {
            temp = preSearch(node.left, key);
        }
        if (node.right!=null) {
            return temp != null ? temp : preSearch(node.right, key);
        }
        return null;
    }


    public TreeNode midSearch(TreeNode node, int key) {
        TreeNode temp = null;

        if (node.left != null) {
            temp =  midSearch(node.left, key);
        }

        if (node.getKey() == key) {
            return node;
        }

        if (node.right != null) {
            return temp != null ? temp : preSearch(node.right, key);
        }

        return null;
    }

    public void deleteNode(TreeNode node, int key){
        if (node.left!=null&&node.left.getKey()==key){
            node.left = null;
            return;
        }
        if (node.right!=null&&node.right.getKey()==key){
            node.right=null;
            return;
        }
        if (node.left!=null){
            deleteNode(node.left,key);
        }
        if (node.right!=null){
            deleteNode(node.right,key);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
