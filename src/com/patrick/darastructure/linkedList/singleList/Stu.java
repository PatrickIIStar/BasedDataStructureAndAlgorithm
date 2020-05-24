package com.patrick.darastructure.linkedList.singleList;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/6 15:09
 */
public class Stu {
    private int no;
    private String name;
    public Stu(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public void setNo(int No){
        this.no = No;
    }

    public void setName(String Name){
        this.name = Name;
    }
}
