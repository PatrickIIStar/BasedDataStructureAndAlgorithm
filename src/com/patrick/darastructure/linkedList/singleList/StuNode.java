package com.patrick.darastructure.linkedList.singleList;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/6 15:57
 */
public class StuNode {
    public Stu stu;
    public StuNode next;

    //构造函数
    public StuNode(Stu stu) {
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "StuNode{" +
                "No=" + stu.getNo() +
                ","+
                "Name=" + stu.getName()+
                '}';
    }
}
