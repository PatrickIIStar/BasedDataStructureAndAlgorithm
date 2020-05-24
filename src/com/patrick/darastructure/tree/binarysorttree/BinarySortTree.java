package com.patrick.darastructure.tree.binarysorttree;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/18 9:06
 * @declaration BST  二叉排序树
 */
public class BinarySortTree {
    private TreeNode root;
    private final static BinarySortTree binarySortTree = new BinarySortTree();

    public static BinarySortTree getInstance() {
        return binarySortTree;
    }

    public void infixOrder() {
        if (root != null) {
            infixOrder(root);
        }
    }

    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    public boolean isExists(int val) {
        if (root == null) {
            return false;
        } else {
            return search(root, val) != null;
        }
    }

    public TreeNode getMin() {
        return getMin(root);
    }

    public void delNode(int val) {
        delNode(root, val);
    }

    /*************************************************************************************************/

    /**
     * @param root BST
     * @return void
     * @declaration 中序遍历BST
     */
    private void infixOrder(TreeNode root) {
        if (root.left != null) {
            infixOrder(root.left);
        }
        System.out.print(root.getVal() + "\t");
        if (root.right != null) {
            infixOrder(root.right);
        }
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


    /**
     * @param root BST
     * @param val  寻找的结点
     * @return com.patrick.darastructure.tree.binarysorttree.TreeNode
     * @declaration 获取BST中节点值与val相等的结点
     */
    private TreeNode search(TreeNode root, int val) {
        // 如果当前节点的值与规定值相等
        // 返回该节点
        if (root.getVal() == val) {
            return root;
            // 如果小于当前节点
        } else if (root.left != null && val < root.getVal()) {
            // 进入当前节点的左节点找
            return search(root.left, val);

            // 如果大于当前节点
        } else if (root.right != null && val >= root.getVal()) {
            // 进入当前结点的右节点找
            return search(root.right, val);
            // 找不到返回null
        } else {
            return null;
        }
    }

    /**
     * @param root BST
     * @param val  要寻找的结点
     * @return com.patrick.darastructure.tree.binarysorttree.TreeNode
     * @declaration 获取BST中节点值与val相等的结点的父节点
     */
    private TreeNode searchParent(TreeNode root, int val) {
        // 如果当前结点的左节点的值或着右节点的值等于规定的值
        // 返回当前节点
        if (root.left != null && root.left.getVal() == val || root.right != null && root.right.getVal() == val) {
            return root;
            // 如果不相等
            // 如果规定值小于当前节点，去左子节点
            // 反之去右子节点
        } else {
            if (root.left != null && val < root.getVal()) {
                return searchParent(root.left, val);
            } else if (root.right != null && val >= root.getVal()) {
                return searchParent(root.right, val);
            } else {
                return null;
            }
        }
    }


    /**
     * @param root 子树
     * @return com.patrick.darastructure.tree.binarysorttree.TreeNode   返回最小结点
     * @declaration 获取该子树中的最小结点
     */
    private TreeNode getMin(TreeNode root) {
        // 初始化min当前节点为最小结点
        TreeNode min = root;
        // 如果当前节点的左子节点非空
        // min的值就是当前节点的左子节点的值
        // 在BST中，左子结点的值最小，右子节点的值最大
        if (root.left != null) {
            min = getMin(root.left);
        }
        return min;
    }

// 非递归删除BST的结点

    /**
     * @param root BST
     * @param val  规定的val
     * @return void
     * @declaration 删除BST中的值为val的结点
     * 1、删除的结点为叶子节点
     *  1)找到目标节点target
     *  2)找到目标结点的父节点parent
     *  3)确定target是父节点的左节点还是右节点
     *  4)根据3来删除target结点  左子节点:parent.left = null,右子节点:parent.right = null
     * <p>
     * 2、删除的结点有两个子节点
     *  1)找到目标结点target
     *  2)找到目标节点target右子树的最大值,用temp保存
     *  3)找到temp的父节点parent
     *  4)将目标结点的值置为temp的结点的值
     * 5)删除temp结点
     *  5.1 temp为叶子节点，到情况1
     *  5.2 temp有右子节点，到情况3
     * <p>
     * 3、删除的结点有一个子节点
     *  1)找到目标节点target
     *  2)找到目标结点的父节点parent
     *  3)确定target是parent的左节点还是右节点
     *  4)确定target有左节点还是有右节点(target.left==null or target.right==null)
     *  5)删除该节点
     *      5.1)target有左子节点且target是parent的左子节点
     *      5.2)target有左子节点且target是parent的右子节点
     *      5.3)target有右子节点且target是parent的左子节点
     *      5.4)target有右子节点且target是parent的右子节点
     * <p>
     * 说明：如果找到target但是parent为null，说明target为根节点
     */
    private void delNode(TreeNode root, int val) {
        // 如果根节点为空
        if (root == null) {
            return;
        }
        // 在树中找要删除的结点
        TreeNode delNode = search(root, val);
        // 找要删除节点的父节点
        TreeNode delNodeParent = searchParent(root, val);

        // 如果找到该节点
        if (delNode != null) {
            // 如果无父节点，说明要删除的为根节点
            if (delNodeParent == null) {
                // 如果根节点无左右子树，说明该树只有一个结点，将其置空
                if (delNode.left == null && delNode.right == null) {
                    this.root = null;
                    // 如果根节点有左右子树
                } else if (delNode.left != null && delNode.right != null) {
                    delHasTwoChildNode(delNode);

                    // 如果根节点只有一边不为空
                } else {
                    // 如果根节点左边不为空
                    if (delNode.left != null) {
                        // 将根节点值置为左节点的值
                        delNode.setVal(delNode.left.getVal());
                        // 如果左子节点的右子节点不为空
                        if (delNode.left.right != null) {
                            // 将其挂到根节点的右节点上
                            delNode.right = delNode.left.right;
                        }

                        // 根节点的左子节点指向左子节点的左子节点
                        // 根节点的原左子节点就被回收
                        delNode.left = delNode.left.left;
                    } else {
                        // 根节点右边不空
                        delNode.setVal(delNode.right.getVal());
                        if (delNode.right.left != null) {
                            delNode.left = delNode.right.left;
                        }
                        delNode.right = delNode.right.right;
                    }
                }
                // 如果有父节点
            } else {
                // 且要删除的结点为叶节点
                if (delNode.left == null && delNode.right == null) {
                    // 如果该节点是父节点的左子节点，将父节点左子节点置空
                    if (isEqual(delNodeParent.left, delNode)) {
                        delNodeParent.left = null;
                    }
                    // 如果该节点是父节点的右子节点，将父节点的右子节点置空
                    if (isEqual(delNodeParent.right, delNode)) {
                        delNodeParent.right = null;
                    }
                    // 如果左节点和右节点都不空
                } else if (delNode.left != null && delNode.right != null) {
                    //删除该节点
                    delHasTwoChildNode(delNode);

                    // 如果待删除结点只有一个子节点
                } else {
                    // 如果只有左节点
                    if (delNode.left != null) {
                        // 如果该节点是父节点的左节点
                        if (isEqual(delNodeParent.left, delNode)) {
                            // 将父节点的左节点指向该节点的左节点，该节点被回收
                            // 和单链表删除结点操作原理一样
                            delNodeParent.left = delNode.left;
                        }
                        // 如果该节点是父节点的右节点
                        if (isEqual(delNodeParent.right, delNode)) {
                            // 父节点的右节点指向该节点的左节点，该节点也被回收
                            delNodeParent.right = delNode.left;
                        }
                        // 如果只有右结点，执行相同操作
                    } else {
                        if (isEqual(delNodeParent.left, delNode)) {
                            delNodeParent.left = delNode.right;
                        }
                        if (isEqual(delNodeParent.right, delNode)) {
                            delNodeParent.right = delNode.right;
                        }
                    }
                }
            }
        }
    }

    /**
     * @param delNode 要删除的结点，该节点有两个子节点
     * @return void
     * @declaration 删除有两个子节点的节点
     */
    private void delHasTwoChildNode(TreeNode delNode) {
        // 先找到要删除结点的右子树中的最小值
        TreeNode temp = getMin(delNode.right);
        // 找到最小值的父节点，用于删除最小值结点
        TreeNode delNodeParent = searchParent(delNode, temp.getVal());

        // 将要删除的结点的值置为最小值的结点，相当于交换位置，然后将该temp节点删除
        delNode.setVal(temp.getVal());


        // 如果该最小值的父节点不为空
        if (delNodeParent != null) {
            // 看不懂了/(ㄒoㄒ)/~~
            // 最小值的结点的子节点数最多有一个
            // 因为如果最小值结点还有左字节点，那么该节点一定不是最小值结点

            // 如果最小值在父节点的左边
            if (isEqual(delNodeParent.left, temp)) {
                // 如果最小值结点还有右子节点
                if (temp.right != null) {
                    // 将其右节点挂到父节点的左节点
                    delNodeParent.left = temp.right;
                    // 如果无右子节点
                    // 说明该节点为叶子节点
                } else {
                    // 就将其删除
                    delNodeParent.left = null;
                }

                // 如果最小值在父节点的右边
            } else if (isEqual(delNodeParent.right, temp)) {
                // 如果该最小值结点还有右子节点
                if (temp.right != null) {
                    // 将其右子节点挂到最小值结点父节点的右节点
                    delNodeParent.right = temp.right;
                    // 如果没有右子节点
                    // 说明该节点为叶子节点
                } else {
                    delNodeParent.right = null;
                }
            }
        }
    }

    private boolean isEqual(TreeNode node, TreeNode temp) {
        return node != null && node.getVal() == temp.getVal();
    }

    /**
     * @declaration 递归删除BST中的结点（惰性删除，不真的删除结点）
     * 1、如果要删除的值小于当前节点，去左子树中找
     * 2、如果要删除的值大于当前节点，去右子树找
     * 3、如果找到了，其左右子树都不为空，找到要删除结点的右子树中的最小值，将其值赋给要删除的结点
     * 然后把最小值结点删除
     * 4、如果为其他情况，即
     *  1、要删除的结点为叶子节点，将其置为空
     *  2、有一个子节点，就将其替换为左子节点(或右子节点)
     */
    private TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.getVal() < val) {
            root.left = deleteNode(root.left, val);
        } else if (root.getVal() > val) {
            root.right = deleteNode(root.right, val);
        } else if (root.left != null && root.right != null) {
            TreeNode temp = getMin(root.right);
            root.setVal(temp.getVal());
            root.right = deleteNode(root.right, temp.getVal());
        } else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }
}
