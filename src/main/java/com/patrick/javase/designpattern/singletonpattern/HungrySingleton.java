package main.java.com.patrick.javase.designpattern.singletonpattern;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/17 22:26
 * @declaration  单例模式(饿汉模式)
 */
public class HungrySingleton {
    private int mmm;
    private static final HungrySingleton hungrySingleton = new HungrySingleton();


    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
