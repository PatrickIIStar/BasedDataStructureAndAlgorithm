package main.java.com.patrick.leetcode;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 22:18
 * @declaration 将有序数组转换成平衡二叉树
 * 1、直接转换 按照数组转换成AVL树的方法,添加一个节点后再判断是否要进行旋转
 * 2、因为数组有序，将数组从中间分为两部分，左边为左子树，右边为右子树
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }


    public static TreeNode add(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
        } else if (root.right == null) {
            root.right = node;
        } else {
            add(root.right, node);
        }
        if (getHeight(root.right) > getHeight(root.left) + 1) {
            rightRotate(root);
        }
        return root;
    }

    public static void rightRotate(TreeNode root) {
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = root.left;
        newNode.right = root.right.left;
//        root.setVal(root.right.val);
        root.val = root.right.val;
        root.left = newNode;
        root.right = root.right.right;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.left == null ? 0 : getHeight(root.left), root.right == null ? 0 : getHeight(root.right)) + 1;
    }


    public static TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);
        return root;
    }



    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        TreeNode res = sortedArrayToBST(nums);
        System.out.println(getHeight(res.right));
    }
}

class TreeNode {
    TreeNode right;
    TreeNode left;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
