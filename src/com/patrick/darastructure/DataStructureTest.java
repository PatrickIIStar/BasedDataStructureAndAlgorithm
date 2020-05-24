package com.patrick.darastructure;

import com.patrick.darastructure.graph.MatrixGraph;


/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/4/20 23:05
 */
public final class DataStructureTest {
    public static void main(String[] args) {


//******************************************************************************************************
/*  单链表
        SingleStuLinkedList singleStuLinkedList = new SingleStuLinkedList();
        SingleStuLinkedList ss = new SingleStuLinkedList();
        Stu stu1 = new Stu(1, "zzz");
        Stu stu2 = new Stu(2, "xxx");
        Stu stu3 = new Stu(3, "sss");
        Stu stu4 = new Stu(4, "s");
        Stu stu5 = new Stu(5, "3");
        StuNode stuNode1 = new StuNode(stu1);
        StuNode stuNode2 = new StuNode(stu2);
        StuNode stuNode3 = new StuNode(stu3);
        StuNode stuNode4 = new StuNode(stu4);
        StuNode stuNode5 = new StuNode(stu5);
        singleStuLinkedList.rearAdd(stuNode1);
        singleStuLinkedList.rearAdd(stuNode2);
        singleStuLinkedList.rearAdd(stuNode3);
        singleStuLinkedList.rearAdd(stuNode4);
        singleStuLinkedList.rearAdd(stuNode5);
        //singleStuLinkedList.delete(1);
        //singleStuLinkedList.del(5);
        System.out.println("原来的链表：");
        singleStuLinkedList.list();
        //System.out.println(SingleStuLinkedList.getSize(singleStuLinkedList.getHead()));
        //System.out.println(SingleStuLinkedList.findLastIndexNode(singleStuLinkedList.getHead(),3));

        System.out.println();
        System.out.println("反转后的链表：");
        ss.setHead(SingleStuLinkedList.reverse(singleStuLinkedList.getHead()));
        ss.list();
        System.out.println();

        System.out.println("链表逆序输出：");
        SingleStuLinkedList.reversePrint(singleStuLinkedList.getHead());
        System.out.println();

        System.out.println("合并链表：");
        SingleStuLinkedList s  = new SingleStuLinkedList();
        s.setHead(SingleStuLinkedList.merge(singleStuLinkedList.getHead(),ss.getHead()));
        ss.list();
        singleStuLinkedList.list();
*/

//***************************************************************************************

        /* 约瑟夫环
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        //CircleList.addNode(aa, first);
        CircleList.addNode(second, first);
        CircleList.addNode(third, first);
        CircleList.addNode(fourth, first);
        CircleList.addNode(fifth, first);
        ListNode temp = first.next;

        while (temp.next!=first){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);

        System.out.println();
        CircleList.josephus(first,1,1);

*/

//***************************************************************************************************
/*     链表栈
        LinkedStack stack = new LinkedStack(2);
        ListNode head = new ListNode(-1);
        ListNode s = new ListNode(2);
        ListNode m = new ListNode(3);
        head.next = s;
        s.next = m;
        stack.push(s);
        //stack.push(new ListNode(2));
        //stack.push(new ListNode(3));
        ListNode value = stack.pop();
        //System.out.println(value==s);
        System.out.println(head.next==value);
        //ListNode value2 = stack.pop();
        //ListNode value3 = stack.pop();
        //stack.list();
        ListNode temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
*/





        /*   哈希表
        HashTable hashTable = new HashTable(5);
//        hashTable.add(new Node(5,0));
//        hashTable.add(new Node(1,1));
//        hashTable.add(new Node(2,2));
//        hashTable.add(new Node(3,3));
        hashTable.add(111,111);
        hashTable.list();
//        hashTable.search(0);
//        hashTable.delete(0);
//        LinkedList linkedList = new LinkedList();
//        System.out.println(hashTable.linkedLists[4].head==null);

         */
/*
        BinaryTree btree = new BinaryTree();
        btree.root = new TreeNode(1);
        btree.root.left = new TreeNode(0);
        btree.root.right = new TreeNode(2);
        btree.preOrder();
        System.out.println();
        System.out.println(btree.preSearch(3));
//        btree.midSearch(1);
        btree.deleteNode(4);
        btree.preOrder();
 */


        /* 线索二叉树
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(14);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.root = treeNode;
        treeNode.left = treeNode1;
        treeNode.right = treeNode4;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode4.left = treeNode5;
        treeNode4.right = new TreeNode(5);
//        threadedBinaryTree.infixThreadBinaryTree();
//        System.out.println(treeNode.left);
//        threadedBinaryTree.infixOrderThreadingBinaryTree();
        threadedBinaryTree.preThreadBinaryTree();
        threadedBinaryTree.preOrderThreadedBinaryTree();
         */


        /* BST
        int[] arr = {7,3,10,1,5,9,12};
        BinarySortTree binarySortTree = BinarySortTree.getInstance();
        for (int value : arr) {
            binarySortTree.add(new TreeNode(value));
        }
        binarySortTree.infixOrder();
//        System.out.println(binarySortTree.isExists(0));
        System.out.println();
//        System.out.println(binarySortTree.getMin());

        binarySortTree.delNode(3);
        binarySortTree.delNode(5);
        binarySortTree.infixOrder();
        System.out.println(new ArrayList<Integer>());

         */


        /*   AVL树
//        int[] arr = {4,3,6,5,7,8};
        int[] arr={1,2,3,4,5};
        AVLTree avlTree = AVLTree.getInstance();
        for (int value : arr) {
            avlTree.add(new TreeNode(value));
        }
//        System.out.println(avlTree.leftHeight());
//        System.out.println(avlTree.rightHeight());
//        avlTree.rightRotate();
//        avlTree.rightDoubleRotate();
        System.out.println(avlTree.treeHeight());
//        avlTree.infixOrder();
         */


        // 图
        MatrixGraph matrixGraph = new MatrixGraph(5);
        String[] vertexes = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexes) {
            matrixGraph.insertVertex(vertex);
        }

        matrixGraph.insertEdge("A", "B", 1);
        matrixGraph.insertEdge("A", "C", 1);
        matrixGraph.insertEdge("B", "C", 1);
//        matrixGraph.insertEdge("B","D",1);
//        matrixGraph.insertEdge("B","E",1);

        matrixGraph.showMatrix();
        matrixGraph.dfs("C");
//        matrixGraph.bfs("A");

    }
}
