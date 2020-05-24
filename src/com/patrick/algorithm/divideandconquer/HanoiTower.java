package com.patrick.algorithm.divideandconquer;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/24 16:11
 * @declaration
 */
public class HanoiTower {
    private static final HanoiTower hanoiTower = new HanoiTower();
    private int moveCount;
    private HanoiTower(){}

    public static HanoiTower getInstance(){
        return hanoiTower;
    }

    public void hanoiTower(int num){
        hanoiTower(num,'A','B','C');
    }

    public int getMoveCount(){
        return moveCount;
    }

    private void hanoiTower(int num, char a, char b, char c){
        if (num==1){
            System.out.println(a+"->"+b);
            moveCount++;
            return;
        }
        moveCount++;
        hanoiTower(num-1,a,c,b);
        System.out.println(a+"->"+b);
        hanoiTower(num-1,b,a,c);
    }
}
