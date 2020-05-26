package main.java.com.patrick.javase.designpattern.singletonpattern;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 22:33
 * @declaration  懒汉式
 */
public class LazySingleton {
    private int temp;
    private static LazySingleton lazySingleton = null;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (lazySingleton==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
