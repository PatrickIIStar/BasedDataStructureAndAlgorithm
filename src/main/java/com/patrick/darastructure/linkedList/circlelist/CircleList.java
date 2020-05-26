package main.java.com.patrick.darastructure.linkedList.circlelist;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/9 9:31
 */


public class CircleList {
    /**
     *
     * @declaration  环形链表增加节点
     * @author PatrickStar
     * @param node   增加的节点
     * @param head   环形链表的第一个节点
     * @return void
     * @date 2020/5/9 17:59
     */
    public static void addNode(ListNode node, ListNode head){
        // 如果只有一个结点且不为环，将其变为环
        if (head.next==null){
            head.next = head;
        }

        //找到环形链表的最后一个节点
        ListNode temp = head;
        while (temp.next!=head){
            temp = temp.next;
        }

        // 添加新节点，新节点指向第一个结点
        node.next = head;
        temp.next = node;
    }

    
    /**
     *
     * @declaration  约瑟夫环
     * @author PatrickStar
     * @param head   环形链表的第一个节点
     * @param start  开始的结点
     * @param k      数多少次
     * @return void
     * @date 2020/5/9 18:02
     */
    public static void josephus(ListNode head, int start, int k){
        // 链表为空，直接输出信息并返回
        if(head==null){
            System.out.println("空");
            return;
        }

        // 如果起始位置或K不合法，输出信息并返回
        if(start<=0||k<=0){
            System.out.println("输入错误");
            return;
        }


        ListNode pCur = head;  // 当前节点的上一个节点，最初指向第一个节点，为辅助结点，帮助链表删除出局结点
        ListNode cur = head;  // 当前节点最初指向第一个结点，游戏时指向出局的结点

        //将pCur指向最后一个节点(初始时cur的前一个结点)
        while (pCur.next!=head){
            pCur = pCur.next;
        }

        // 游戏开始前将cur和pCur移动到指定位置，cur指向游戏开始时的结点
        for(int i=1;i<start;i++){
            pCur = pCur.next;
            cur = cur.next;
        }

        // 如果链表还有两个或两个以上的结点，继续游戏
        while (cur.next!=cur){
            // cur每移动k-1次，就将移动后指向的结点删除
            for (int i = 1; i < k; i++) {
                cur = cur.next;  // 后移
                pCur = pCur.next; // 辅助接点跟着后移
            }

            // 先输出出局结点的信息
            System.out.println("出去:"+cur.val);
            cur = cur.next; // cur后移，指向出局结点后面的一个元素
            pCur.next = cur;// 辅助接点的next域指向删除结点后的元素
        }

        // 链表只剩下最后一个节点，将其输出
        System.out.println("剩下"+cur.val);
    }
}
