package com.patrick.darastructure.hashtable;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/15 17:56
 * @declaration  模拟哈希表
 */

public class HashTable {
    private final int size;
    private final LinkedList[] linkedLists;  // 链表数组

    public HashTable(int size) {
        this.size = size;
        this.linkedLists = new LinkedList[this.size];
        for (int i = 0; i < this.size; i++) {
            linkedLists[i] = new LinkedList();
        }
    }

    public void add(int key, int value){
        Node node = new Node(key, value);
        int index = hashCode(node.getKey());
        linkedLists[index].add(node);
    }

    public void delete(int id){
        int index = hashCode(id);
        linkedLists[index].delete(id);
    }

    public void search(int id){
        int index = hashCode(id);
        Node temp = linkedLists[index].search(id);
        if (temp!=null){
            System.out.println(temp.toString());
        }else {
            System.out.println("无此元素");
        }
    }

    public void list(){
        for (int i = 0; i < this.size; i++) {
            linkedLists[i].list();
            System.out.println();
        }
    }

    public int hashCode(int id) {
        return id % this.size;
    }
}
