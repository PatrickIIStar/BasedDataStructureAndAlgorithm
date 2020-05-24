package com.patrick.darastructure.tree.threadedbinarytree;

import com.patrick.darastructure.tree.binarytree.TreeNode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 15:07
 * @declaration 线索二叉树
 */
public class ThreadedBinaryTree {
    public TreeNode root;
    private TreeNode pre;

    public void infixOrderThreadedBinaryTree() {
        TreeNode node = root;
        while (node != null) {

            while (!node.isThreadLeft) {
                node = node.left;
            }

            System.out.println(node);

            while (node.isThreadRight) {
                node = node.right;
                System.out.println(node);
            }

            node = node.right;
        }
    }

    public void preOrderThreadedBinaryTree() {
        TreeNode node = root;

        while (node != null) {
            while (!node.isThreadLeft) {
                System.out.println(node);
                node = node.left;
            }
            System.out.println(node);
            node = node.right;
        }
    }

    public void infixThreadBinaryTree() {
        infixThreadNode(root);
    }

    public void preThreadBinaryTree() {
        preThreadNode(root);
    }


    public void infixThreadNode(TreeNode node) {
        if (node == null) {
            return;
        }
        infixThreadNode(node.left);

        if (node.left == null) {
            node.isThreadLeft = true;
            node.left = pre;
        }

        if (pre != null && pre.right == null) {
            pre.isThreadRight = true;
            pre.right = node;
        }

        pre = node;
        infixThreadNode(node.right);
    }


    public void preThreadNode(TreeNode node) {
        if (node == null) {
            return;
        }
        // 前驱
        if (node.left == null) {
            node.left = pre;
            node.isThreadLeft = true;
        }

        // 后继
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.isThreadRight = true;
        }

        pre = node;
        if (!node.isThreadLeft)
            preThreadNode(node.left);
        if (!node.isThreadRight)
            preThreadNode(node.right);
    }
}
