package main.java.com.patrick.darastructure.hashtable;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/15 17:56
 * @declaration  链表节点
 */
public class Node {
    private int key;
    private int value;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
