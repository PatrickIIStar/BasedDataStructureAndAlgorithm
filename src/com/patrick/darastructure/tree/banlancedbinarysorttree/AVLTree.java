package com.patrick.darastructure.tree.banlancedbinarysorttree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/20 8:59
 * @declaration 平衡二叉排序树 AVL
 */
public class AVLTree {
    private TreeNode root;
    private static AVLTree avlTree = null;

    private AVLTree() {
    }

    // 获得一个对象
    public static AVLTree getInstance() {
        if (avlTree == null) {
            avlTree = new AVLTree();
        }
        return avlTree;
    }


    /**
     * @param node 添加的结点
     * @return void
     * @declaration 添加一个结点，并在添加完成后判断是否需要旋转该树
     */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        add(root, node);
        // 如果左子树与右子树的高度差大于1
        // 对整棵树进行相对应的操作
        // LL旋、RR旋、LR旋或RL旋
        if (leftHeight() > rightHeight() + 1) {
            rightDoubleRotate(root);
            return;
        }

        if (rightHeight() > leftHeight() + 1) {
            leftDoubleRotate(root);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            infixOrder(root);
        }
    }

    // 整棵树的高度
    public int treeHeight() {
        return treeHeight(root);
    }


    /**
     * @param root BST
     * @param node 添加的结点
     * @return void
     * @declaration 向BST中添加一个结点
     */
    private void add(TreeNode root, TreeNode node) {
        // 如果节点为空，不添加
        if (node == null) {
            return;
        }
        // 如果要添加的节点的值比当前节点值小
        if (node.getVal() < root.getVal()) {
            // 如果当前节点的左节点为空
            if (root.left == null) {
                //将该节点挂到当前节点的左节点
                root.left = node;
            } else {
                // 如果当前节点的左结点不为空
                // 递归，找到符合条件的结点
                add(root.left, node);
            }
            // 要添加的结点值不小于当前节点的值
            // 进行同样操作
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                add(root.right, node);
            }
        }
    }

    // 中序遍历
    private void infixOrder(TreeNode root) {
        if (root.left != null) {
            infixOrder(root.left);
        }
        System.out.println(root.getVal());
        if (root.right != null) {
            infixOrder(root.right);
        }
    }

    /**
     * @return int  左子树的高度
     * @declaration 左子树的高度
     */
    private int leftHeight() {

        if (root.left == null) {
            return 0;
        }
        return treeHeight(root.left);
    }


    /**
     * @return int  右子树的高度，如果右子树为空，则为0
     * @declaration 右子树的高度
     */
    private int rightHeight() {

        if (root.right == null) {
            return 0;
        }
        return treeHeight(root.right);
    }

    /**
     * @param root 树的根
     * @return int   树的高度
     * @declaration 求树root的高度
     */
    private int treeHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        // 取左右子树中最大的再加上根节点就是树的高度
        return Math.max(root.left == null ? 0 : treeHeight(root.left), root.right == null ? 0 : treeHeight(root.right)) + 1;
    }

    /**
     * @param root 树的根root
     * @return void
     * @declaration 对树root进行左旋
     * <p>
     * 步骤：
     * 1、声明一个新的结点，值与根节点的值相同
     * 2、新节点的左子节点指向根节点的左子节点
     * 3、新节点的右子节点指向根节点的右子节点的左子节点
     * 4、根节点的值改为根节点的右子节点的值
     * 5、根节点的左子节点指向新节点
     * 6、根节点的右子节点指向根节点的右子节点的右子节点(跳过根节点的右子节点)
     */
    private void leftRotate(TreeNode root) {
        // 创建一个新节点，其值等于根节点的值
        TreeNode newNode = new TreeNode(root.getVal());
        // 新节点的左子节点指向根节点的左子节点
        newNode.left = root.left;
        // 新节点的右子节点指向根节点的右子节点的右子节点
        newNode.right = root.right.left;
        // 根节点的值改为根节点的右子节点的值
        root.setVal(root.right.getVal());
        // 根节点的右子节点指向根节点的右子节点的右子节点
        root.right = root.right.right;
        // 根节点的左子节点指向新节点
        root.left = newNode;
    }

    /**
     * @param root 树的根root
     * @return void
     * <p>
     * 步骤与左旋相反
     * @declaration 对树进行右旋操作
     */
    private void rightRotate(TreeNode root) {

        TreeNode newNode = new TreeNode(root.getVal());
        newNode.right = root.right;
        newNode.left = root.left.right;
        root.setVal(root.left.getVal());
        root.left = root.left.left;
        root.right = newNode;
    }

    /**
     * @param root
     * @declaration 先对左子树进行左旋操作，在对树进行右旋操作
     * <p>
     * 说明：
     * 如果根节点的左子树的右子树的高度大于左子树的左子树的高度，直接对树进行旋转操作的话
     * 旋转后的树依然不是一棵平衡二叉树
     * 所以要先对根节点的左子树进行左旋操作，让左子树的左子树高度大于左子树的右子树高度
     */
    private void rightDoubleRotate(TreeNode root) {
        // 如果左子结点不为空且左子结点的右子树的高度大于左子结点的左子树高度
        if (root.left != null && treeHeight(root.left.right) > treeHeight(root.left.left)) {
            // 对左子树进行左旋
            leftRotate(root.left);
        }
        // 然后对整个树进行右旋
        rightRotate(root);
    }

    /**
     * @param root 树的根root
     * @return void
     * @declaration 先对右子树进行右旋操作，再对整棵树进行左旋操作
     * 与先左旋再右旋相反的操作
     */
    private void leftDoubleRotate(TreeNode root) {
        // 如果右子节点存在且右子节点的左子树的高度大于右子节点的右子树的高度
        if (root.right != null && treeHeight(root.right.left) > treeHeight(root.right.right)) {
            // 对右子树进行右旋
            rightRotate(root.right);
        }
        // 对整个树左旋
        leftRotate(root);
    }
}
