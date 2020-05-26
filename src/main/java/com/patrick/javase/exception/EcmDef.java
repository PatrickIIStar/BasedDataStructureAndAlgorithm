package main.java.com.patrick.javase.exception;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/25 22:41
 * @declaration
 */
public class EcmDef {
    public static int ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0) {
            throw new EcDef("负数");
        }
        return i / j;
    }

    public static void main(String[] args) {
        int i = -1;
        int j = -1;
        try {
            System.out.println(ecm(i, j));
        } catch (EcDef ecDef) {
            System.out.println(ecDef.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("除数为0");
        }
    }

    public static class EcDef extends Exception {
        static final long serialVersionUID = -3387516124229948L;

        public EcDef(String msg) {
            super(msg);
        }
    }
}
