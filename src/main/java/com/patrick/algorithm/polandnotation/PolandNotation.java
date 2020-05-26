package main.java.com.patrick.algorithm.polandnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/10 10:36
 */

public class PolandNotation {
    /**
     * @param expression 中缀表达式字符串
     * @return java.util.ArrayList<java.lang.String>
     * @declaration 中缀表达式字符串转换为列表
     * @author PatrickStar
     * @date 2020/5/10 21:43
     */
    public static ArrayList<String> toList(String expression) {
        ArrayList<String> list = new ArrayList<>();
        String str; // 拼接多位数
        char c;
        // 遍历字符串
        for (int i = 0; i < expression.length(); i++) {
            // 如果该字符不是数字，直接加入列表
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                list.add(c + "");
            } else {
                str = "";
                // 如果是数字，从该数字开始往后遍历
                for (int j = i; j < expression.length(); j++) {
                    // 如果与该数字紧邻的字符也是数字，将其拼接到一起
                    if (expression.charAt(j) >= 48 && (c = expression.charAt(j)) <= 57) {
                        str = str + c;
                        // 如果碰到非数字字符
                    } else {
                        // 保存位置信息，跳出循环
                        i = j - 1;
                        break;
                    }
                }
                // 将数字添加到列表
                list.add(str);
            }
        }
        // 返回该列表
        return list;
    }

    /**
     * @param expression 中缀表达式列表
     * @return java.util.ArrayList<java.lang.String>
     * @declaration 中缀表达式列表转换为后缀表达式列表(逆波兰表达式列表)
     * @author PatrickStar
     * @date 2020/5/10 21:44
     */
    public static ArrayList<String> getPolandExpression(ArrayList<String> expression) {
        ArrayList<String> nums = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        Map<String, Integer> priority = new HashMap<>(); // 优先级的映射
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("x", 2);
        priority.put("/", 2);
        priority.put("(", 0);  // 设置左括号优先级最低
        String operator = "+-*/xX";
        for (String item : expression) {
            // 如果是数字，直接加入列表
            if (item.matches("\\d+")) {
                nums.add(item);
                // 如果是操作符
            } else if (operator.contains(item)) {
                // 如果栈非空且栈顶优先级高于或等于该操作符优先级，将栈顶操作符加入nums列表
                // 直到栈为空或遇到优先级较低的操作符
                while (operators.size() > 0 && priority.get(item) <= priority.get(operators.peek())) {
                    nums.add(operators.pop());
                }
                // 如果栈空或栈顶优先级较低，直接将其入栈
                operators.push(item);
                // 如果不是操作符
                // 是"("，将其直接入栈
            } else if ("(".equals(item)) {
                operators.push(item);
                // 是右括号
            } else if (")".equals(item)) {
                while (!"(".equals(operators.peek())) {
                    // 如果栈顶是操作符，将其加入nums列表
                    // 直到遇见左括号
                    nums.add(operators.pop());
                }
                // 如果栈顶为左括号，将其丢弃
                operators.pop();
                // 既非操作符，也非数字和括号，抛出异常
            } else {
                throw new RuntimeException("字符错误");
            }
        }
        // 将operators栈里面剩下的操作符加入nums列表
        while (!operators.isEmpty()) {
            nums.add(operators.pop());
        }
        // 返回nums列表
        return nums;
    }

/*
    public static ArrayList<String> toPolandList(String polandExpression) {
        ArrayList<String> list = new ArrayList<>();
        String[] items = polandExpression.split(" ");
        Collections.addAll(list, items);
        return list;
    }
*/

    /**
     * @param polandExpression 后缀表达式列表
     * @return int
     * @declaration 根据后缀表达式列表求得计算结果
     * @author PatrickStar
     * @date 2020/5/10 21:44
     */
    public static int getPolandResult(ArrayList<String> polandExpression) {
        Stack<String> stack = new Stack<>();
        // 遍历后缀表达式列表
        for (String item : polandExpression) {
            // 碰到数字，将其入栈
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                // 碰到操作符
                // 从栈里面弹出最上面两个数字
                // 先弹出的为右操作数，后弹出的为左操作数
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                // 判断操作符，并将弹出的两个数字做相应操作
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                    case "X":
                    case "x":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("错误");
                }
                // 将计算后的结果再次入栈
                stack.push("" + res);
            }
        }
        // 后缀表达式遍历结束，栈里只剩一个元素，即计算结果
        // 返回该结果
        return Integer.parseInt(stack.pop());
    }
}
