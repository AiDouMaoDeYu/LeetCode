import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution20 {
    public static void main(String[] args) {
        String s = "[([]])";
        boolean isValid = new Solution20().isValid(s);
        System.out.println(isValid);        
    }

    public boolean isValid(String s) {
        if(s.equals("") || s == null){
            return true;
        }
        String[] strArry = s.split("");
        Set<String> leftSet = new HashSet<>();
        leftSet.add("(");
        leftSet.add("[");
        leftSet.add("{");

        Set<String> rightSet = new HashSet<>();
        rightSet.add(")");
        rightSet.add("]");
        rightSet.add("}");

        Map<String,String> kinds = new HashMap<>();
        kinds.put(")", "(");
        kinds.put("]", "[");
        kinds.put("}", "{");


        List<String> list = new LinkedList<>();
        for (String string : strArry) {
            if(leftSet.contains(string)){
                list.add(string);
            }else if(rightSet.contains(string) && list.size() > 0){
                String node = list.get(list.size() - 1);
                if(kinds.get(string).equals(node)){
                    list.remove(list.size() - 1);
                    //(o.equals(x.item)) String不能使用删除对象，需要删除索引号
                    //list.remove(node);
                }else{
                    return false;
                }
                
            }else{
                return false;
            }
        }
        if(list.size() != 0){
            return false;
        }

        return true;
    }







    /**
     * 臭代码-吴晓建  用遍历不考虑括号顺序
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        if(s.equals("") || s == null){
            return true;
        }
        String[] strArry = s.split("");
        int index = -1;
        String[] leftKind = new String[]{"(","[","{",};
        String[] ringhtKind = new String[]{")","]","}",};
        for (String string : strArry) {
            if(index == -1){
                for (int i = 0; i < leftKind.length; i++) {
                    if(leftKind[i].equals(string)){
                        index = i;
                        break;
                    }
                }
                if(index == -1){
                  return false;
                }
            }else{
                if(ringhtKind[index].equals(string)){
                    index = -1;
                }else{
                    return false;
                }
            }
        }
        if(index != -1){
            return false;
        }
        return true;

    }
    
}
