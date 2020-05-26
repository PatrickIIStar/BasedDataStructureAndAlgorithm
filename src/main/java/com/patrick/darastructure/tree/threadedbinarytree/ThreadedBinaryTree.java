package main.java.com.patrick.darastructure.tree.threadedbinarytree;


/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 15:07
 * @declaration 线索化二叉树，使结点中空的指针域指向其前驱或者后继
 */
public class ThreadedBinaryTree {
    public TreeNode root;  // 树的根节点
    private TreeNode pre;  // 当前节点的前驱结点

    /**
     * @declaration 中序遍历线索二叉树
     * 1、先在左子树找到叶子节点，也就是第一个 isThreadLeft 域为true的结点，将其输出
     * 2、如果它的右子节点指向其后继，则一直遍历
     * 3、否则就遍历他的右子节点
     * 4、当node为空，说明该线索二叉树遍历完成，结束
     */
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

    /**
     * @declaration 先序遍历线索二叉树
     * 1、先将当前节点信息输出
     * 2、遍历当前节点的左子树，直到遇见isThreadLeft为true的结点
     * 3、从该节点出发，遍历其后继或者右子节点，进入步骤2
     * 4、当node为空，说明该线索二叉树遍历完成，结束
     */
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


    /**
     * @declaration 中序线索化二叉树
     * 先线索化左子树，然后线索化当前节点，最后线索化右子树
     */
    private void infixThreadNode(TreeNode node) {
        // 空树
        if (node == null) {
            return;
        }

        // 线索化左子树
        infixThreadNode(node.left);

        // 线索化当前节点
        // 如果当前结点的左子结点为空
        if (node.left == null) {
            // 将左子节点的线索化标志置为true;
            // 并将左子节点指向其前驱
            node.isThreadLeft = true;
            node.left = pre;
        }

        // 处理后继
        // pre变为当前节点,node为当前节点的后继结点
        if (pre != null && pre.right == null) {
            pre.isThreadRight = true;
            pre.right = node;
        }

        pre = node;

        // 线索化右子树
        infixThreadNode(node.right);
    }

    /**
     * @declaration 先序线索化二叉树
     * 先处理当前节点，再处理左右子树
     */
    private void preThreadNode(TreeNode node) {
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
