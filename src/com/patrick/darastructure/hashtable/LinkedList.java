package com.patrick.darastructure.hashtable;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/15 17:57
 * @declaration  链表
 */

public class LinkedList {
    private Node head = null;

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void delete(int id) {

    }

    public Node search(int id) {
        if (head==null){
            return null;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.getKey() == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void list() {
        Node temp = head;
        if (head == null) {
            System.out.print("链表空");
        } else {
            while (temp != null) {
                System.out.print(temp.toString() + "->");
                temp = temp.next;
            }
        }
    }
}
