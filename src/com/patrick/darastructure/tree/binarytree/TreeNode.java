package com.patrick.darastructure.tree.binarytree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 10:24
 * @declaration 二叉树结点以及相关操作
 */
public class TreeNode {
    private final int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    /**
     * @declaration 中序遍历二叉树
     */
    public void midOrder(TreeNode node) {
        if (node.left != null) {
            midOrder(node.left);
        }

        System.out.println(node.toString());

        if (node.right != null) {
            midOrder(node.right);
        }
    }

    /**
     * @declaration 先序遍历二叉树
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.toString());
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * @declaration 先序查找
     */
    public TreeNode preSearch(TreeNode node, int key) {
        TreeNode temp = null;
        if (node.getKey() == key) {
            return node;
        }

        if (node.left != null) {
            temp = preSearch(node.left, key);
        }
        if (node.right != null) {
            return temp != null ? temp : preSearch(node.right, key);
        }
        return null;
    }

    /**
     * @declaration 中序查找
     */
    public TreeNode midSearch(TreeNode node, int key) {
        TreeNode temp = null;

        if (node.left != null) {
            temp = midSearch(node.left, key);
        }

        if (node.getKey() == key) {
            return node;
        }

        if (node.right != null) {
            return temp != null ? temp : preSearch(node.right, key);
        }

        return null;
    }

    /**
     * @declaration 删除节点
     */
    public void deleteNode(TreeNode node, int key) {
        if (node.left != null && node.left.getKey() == key) {
            node.left = null;
            return;
        }
        if (node.right != null && node.right.getKey() == key) {
            node.right = null;
            return;
        }
        if (node.left != null) {
            deleteNode(node.left, key);
        }
        if (node.right != null) {
            deleteNode(node.right, key);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
