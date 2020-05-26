package main.java.com.patrick.javase.innerclass;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 21:42
 * @declaration
 */
public class OuterClass {
    private static final int m = 8;

    public static class InnerClass {
        public int val;

        public InnerClass(int val) {
            this.val = val;
        }
    }

    public static int getM() {
        return m;
    }
}
