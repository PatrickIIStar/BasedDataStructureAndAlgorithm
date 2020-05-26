package main.java.com.patrick.javase;

import main.java.com.patrick.javase.exception.EcmDef;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 22:50
 * @declaration  JavaSE测试函数
 */
public class JavaSETest {

    public static void main(String[] args) {
        int i = 0;
        int j = -1;
        try {
            System.out.println(EcmDef.ecm(i,j));
        } catch (EcmDef.EcDef | ArithmeticException ecDef) {
            System.out.println(ecDef.getMessage());
        }
    }
}
