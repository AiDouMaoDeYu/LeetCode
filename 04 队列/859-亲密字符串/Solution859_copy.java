public class Solution859_copy {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ab";
        boolean b1 = new Solution859_copy().buddyStrings(s,goal);
        System.out.println(b1);
    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;

        }

        int len = s.length();
        if(s.equals(goal)){
            int[] count = new int[26];
            for (int i = 0; i < len; i++) {
                //如果差值相同，说明存在相同字母
                count[s.charAt(i) - 'a']++;
                if(count[s.charAt(i) - 'a'] > 1){
                    return true;
                }
            }
        }else{
            int left = -1,right = -1;
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) != goal.charAt(i)){
                    if(left == -1){
                        left = i;
                    }else if(right == -1){
                        right = i;
                    }else{
                        return false;
                    }
                }
            }
            return (right != -1 && s.charAt(left) == goal.charAt(right) && s.charAt(right) == goal.charAt(left));
        }

        return false;
    }
    
}
