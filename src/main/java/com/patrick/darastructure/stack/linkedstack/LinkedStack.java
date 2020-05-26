package main.java.com.patrick.darastructure.stack.linkedstack;


/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/10 8:46
 */
public class LinkedStack {
    private final ListNode head = new ListNode(-1);
    private int count = 0;      // 记录栈中数据个数
    private final int size; // 栈的大小

    /**
     * @param size 栈的大小
     * @return
     * @declaration 构造一个大小为size的栈
     * @author PatrickStar
     * @date 2020/5/10 9:04
     */
    public LinkedStack(int size) {
        this.size = size;
    }

    /**
     * @return boolean
     * @declaration 判断是否为空
     * @author PatrickStar
     * @date 2020/5/10 9:05
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * @return
     * @declaration 判断是否满
     * @author PatrickStar
     * @date 2020/5/10 9:05
     */
    public boolean isFull() {
        return this.count == this.size;
    }

    /**
     * @param data 添加的数据
     * @return void
     * @declaration 入栈
     * @author PatrickStar
     * @date 2020/5/10 9:05
     */
    public void push(ListNode data) {
        if (isFull()) {
            System.out.println("满");
            return;
        }
        this.count++;
        data.next = head.next;
        head.next = data;
    }


    /**
     * @param
     * @return com.patrick.ListNode 出栈的数据
     * @declaration 出栈
     * @author PatrickStar
     * @date 2020/5/10 9:06
     */
    public ListNode pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            return null;
        }
        this.count--;
        ListNode temp = head.next;
        head.next = head.next.next;
        return temp;
    }


    // 遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("空");
            return;
        }

        ListNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
