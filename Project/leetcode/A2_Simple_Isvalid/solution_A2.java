package leetcode.A2_Simple_Isvalid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class solution_A2 {
    public static boolean isValid(String s){
        // 如果字符串为空
        if (null == s || s.length() == 0) {
            return false;
        }
        // 如果字符串长度不为偶数
        if (s.length() % 2 != 0) {
            return false;
        }
        // 将字符串=转换为字符数组
        char[] chars = s.toCharArray();
        // 通过map建立左右括号的配对关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        // 遍历字符数组
        for (int i = 0; i < chars.length; i++) {
            // 如果第一个元素就是右括号，直接false
            if (i == 0 && map.containsKey(s.charAt(i))) return false;
            // 获取每一个数值
            char c = s.charAt(i);
            // 当遍历到的是左括号
            if (!map.containsKey(c)) {
                // 入栈
                stack.push(c);
            }
            // 不论何种形式，只要满足条件，右括号前一个元素都是与之配对的左括号
            // 而上一个左括号肯定已经入栈且为栈顶元素（栈：后进先出）
            else {
                // 如果栈为空，或是栈顶元素不与右括号对应，则为false
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                // 如果满足条件，将栈顶元素弹出
                stack.pop();
            }
        }
        // 如果最后栈为空了，则配对完成
        return stack.isEmpty();
    }
}
