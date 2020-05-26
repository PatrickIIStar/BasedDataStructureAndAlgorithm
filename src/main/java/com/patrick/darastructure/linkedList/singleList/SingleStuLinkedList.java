package main.java.com.patrick.darastructure.linkedList.singleList;

import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/6 15:59
 */
public class SingleStuLinkedList {
    private StuNode head = new StuNode(new Stu(0, null));

    public StuNode getHead() {
        return head;
    }

    public void setHead(StuNode head) {
        this.head = head;
    }


    /**
     * @param stuNode 要添加的结点
     * @return void
     * @declaration 向链表中直接添加一个节点(尾插法)
     * @author PatrickStar
     * @date 2020/5/7 20:49
     */
    public void rearAdd(StuNode stuNode) {
        StuNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = stuNode;
    }


    /**
     * @param stuNode 要添加的结点
     * @return void
     * @declaration 按序号顺序添加结点
     * @author PatrickStar
     * @date 2020/5/7 20:50
     */
    public static void addByOrder(StuNode stuNode, StuNode head) {
        StuNode temp = head;
        //boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.stu.getNo() > stuNode.stu.getNo()) {
                break;
            }
            temp = temp.next;
        }
        stuNode.next = temp.next;
        temp.next = stuNode;
    }



    /**
     * @param No 要删除的结点的序号
     * @return void
     * @declaration 删除与No相同序号的结点
     * @author PatrickStar
     * @date 2020/5/7 20:50
     */
    public void delete(int No) {
        StuNode temp = head;
        while (temp.next != null) {
            if (temp.next.stu.getNo() == No) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
    }


    /**
     * @param No 要删除的结点序号
     * @return void
     * @declaration 删除与No相同的第一次出现的结点
     * @author PatrickStar
     * @date 2020/5/7 20:51
     */
    public void del(int No) {
        StuNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.stu.getNo() == No) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        }
    }


    /**
     * @param head 链表的头节点
     * @return int     链表的节点数
     * @declaration 求链表节点数(不计算头节点)
     * @author PatrickStar
     * @date 2020/5/7 20:51
     */
    public static int getSize(StuNode head) {
        StuNode temp = head.next;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    /**
     * @param head  链表的头节点
     * @param index 倒数第index
     * @return com.patrick.SingleList.StuNode 倒数第index个节点
     * @declaration 求链表的倒数第index个结点
     * @author PatrickStar
     * @date 2020/5/7 20:52
     */
    public static StuNode findLastIndexNode(StuNode head, int index) {
        // 链表为空，返回null
        if (head.next == null) {
            return null;
        }

        // 获取链表长度
        int size = getSize(head);

        // index格式错误，返回null
        if (index <= 0 || index > size) {
            return null;
        }

        // 遍历，第size-index个结点为倒数第index个结点
        StuNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * @param head 链表的头节点
     * @return void
     * @declaration 将链表逆序
     * @author PatrickStar
     * @date 2020/5/7 20:53
     */
    public static StuNode reverse(StuNode head) {
        if (head.next == null || head.next.next == null) {
            return null;
        }
        StuNode newNode = new StuNode(new Stu(0, null));
        StuNode cur = head.next; // temp指向链表的第一个结点
        StuNode next = null; // 指向temp.next
        while (cur != null) {
            /*
            head.next = cur.next;    // 头节点指向该节点的下一个结点
            StuNode temp = cur;      // temp暂时存放该节点
            cur = cur.next;          // cur后移
            headAdd(temp,newNode);   // 将该节点按头插入方式插入新链表
             */
            next = cur.next;         // 该节点的下一个结点
            cur.next = newNode.next; // 将遍历到的结点的next域指向newNode的第一个结点
            newNode.next = cur;      // newNode的头节点指向该节点
            cur = next;              // 指针后移
        }
        head.next = newNode.next;
        return newNode;      // 旧链表的头节点指向新链表的第一个结点
    }

    /**
     * @param head 链表头节点
     * @return void
     * @declaration 逆序输出链表结点
     * @author PatrickStar
     * @date 2020/5/7 21:18
     * 用栈的先入先出原则逆序输出
     */
    public static void reversePrint(StuNode head) {
        if (head.next == null) {
            System.out.println("空");
            return;
        }
        StuNode temp = head.next;
        Stack<StuNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    /**
     * @param stuNode 要插入的结点
     * @param head    链表的头节点
     * @return void
     * @declaration 向链表中插入一个节点(头插法)
     * @author PatrickStar
     * @date 2020/5/7 20:53
     */
    public static void headAdd(StuNode stuNode, StuNode head) {
        StuNode temp = head.next;   // temp指向链表的第一个节点
        head.next = stuNode;        // 头节点指向新加的结点
        stuNode.next = temp;        // 新加的结点指向temp(就是原来链表的第一个节点)
    }


    // 两个指针分别遍历，小的直接尾插入新的链表
    public static StuNode merge(StuNode headA, StuNode headB) {
        if (headA.next==null||headB.next==null){
            return headA.next==null?headB:headA;
        }
        StuNode tempA = headA.next;
        StuNode tempB = headB.next;
        StuNode newNode = new StuNode(new Stu(0,null));
        while (tempA!=null&&tempB!=null){
            if (tempA.stu.getNo()>tempB.stu.getNo()){
                newNode.next = tempB;
                newNode = newNode.next;
                tempB = tempB.next;
            }else {
                newNode.next = tempA;
                newNode = newNode.next;
                tempA = tempA.next;
            }
        }
        //newNode.next=(tempA==null?tempB:tempA);
        return  newNode;
    }

    /**
     * @return void
     * @declaration 清空链表
     * @author PatrickStar
     * @date 2020/5/7 20:54
     */
    public void clear() {
        head.next = null;
        head.stu.setName(null);
        head.stu.setNo(0);
    }


    /**
     * @return void
     * @declaration 遍历链表
     * @author PatrickStar
     * @date 2020/5/7 20:54
     */
    public void list() {
        if (head.next == null) {
            System.out.println("空");
            return;
        }
        StuNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

