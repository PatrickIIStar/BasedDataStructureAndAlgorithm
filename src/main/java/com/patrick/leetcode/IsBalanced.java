package main.java.com.patrick.leetcode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/21 10:43
 * @declaration   判断是否是一棵AVL树
 */

public class IsBalanced {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right))<=1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }
}
