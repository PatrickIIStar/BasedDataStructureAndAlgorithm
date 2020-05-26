package main.java.com.patrick.darastructure.tree.threadedbinarytree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 10:24
 * @declaration 线索化二叉树结点
 */
public class TreeNode {
    private final int key;
    public TreeNode left;
    public TreeNode right;
    public boolean isThreadLeft = false; // 指向左子树为false, 指向前驱为true
    public boolean isThreadRight = false; // ---右子树 false, 后继 true

    public TreeNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
