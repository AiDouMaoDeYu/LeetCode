import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution20_copy {
    public static void main(String[] args) {
        String s = "([)]";
        boolean isValid = new Solution20_copy().isValid(s);
        System.out.println(isValid);        
    }

    /**
     * 代码简洁，方便
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();

        //先判断是否是双数
        if(len % 2 == 1){
            return false;
        }


        Map<Character,Character> pairs = new HashMap<>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};


        Deque<Character> list = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            
            if(pairs.containsKey(ch)){
                if(list.isEmpty() || list.peek() != pairs.get(ch)){
                    return false;
                }
                list.pop();
            }else{
                list.push(ch);
            }
            
        }
        return list.isEmpty();
    }

    /**
     * 厉害 厉害
     * @param s
     * @return
     */
    public boolean isValid_copy(String s) {
        char[] stack = new char[s.length()];
        int pointer = 0;
        //这个char有点意思
        char[] map = new char[128];
        map['('] = ')';
        map['{'] = '}';
        map['['] = ']';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[pointer++] = c;
            } else {
                if (pointer == 0 || map[stack[--pointer]] != c) {
                    return false;
                }
            }
        }
        return pointer == 0;
    }
    
}
