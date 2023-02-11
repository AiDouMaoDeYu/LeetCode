public class Solution859 {
    public static void main(String[] args) {
        String s = "aa";
        String goal = "aa";
        boolean b1 = new Solution859().buddyStrings(s,goal);
        System.out.println(b1);
        
    }
    
    //1.如果字符串不相等 存在可以交换的不同字符 算正确
    //2.如果字符串相等 存在可以交换的不同字符 算正确
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)){


        }
        int len = s.length();
        int left = -1;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) != goal.charAt(i)){
                if(left >= 0 ){
                    right = i;
                }else{
                    left = i;
                }
            }
        }
        if(right < left || right < 0){
            return false;

        }
        char ch = s.charAt(right);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(right, s.charAt(left));
        sb.setCharAt(left, ch);
        if(right > left && sb.toString().equals(goal)){
            return true;
        }
        return false;

    }

}


class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                //++作用是什么
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && s.charAt(first) == goal.charAt(second) &&
                    s.charAt(second) == goal.charAt(first));
        }
    }
}