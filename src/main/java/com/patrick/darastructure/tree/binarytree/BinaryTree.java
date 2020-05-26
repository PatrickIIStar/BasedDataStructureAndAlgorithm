package main.java.com.patrick.darastructure.tree.binarytree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/16 10:24
 * @declaration  二叉树
 */
public class BinaryTree {
    public TreeNode root;


    public void midOrder() {
        if (root != null)
            root.midOrder(root);
    }

    public void preOrder() {
        if (root != null)
            root.preOrder(root);
    }

    public TreeNode preSearch(int key) {
        if (root != null) {
            return root.preSearch(root,key);
        }
        return null;
    }

    public TreeNode midSearch(int key) {
        if (root != null) {
            return root.midSearch(root,key);
        }
        return null;
    }

    public void deleteNode(int key) {
        if (root != null) {
            if (root.getKey()==key){
                root=null;
            }else{
                root.deleteNode(root, key);
            }
        }
    }
}
