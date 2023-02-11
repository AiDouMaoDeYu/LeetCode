import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution144_copy {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,4,3,2};
        TreeNode root = new TreeNode(array);
        List<Integer> list = new Solution144_copy().preorderTraversal(root);
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(",");
        }
        System.out.println();
        
        
    }

    /**
     * 迭代方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = root;
        while(!stack.isEmpty() || pre != null){
            while(pre != null){
                list.add(pre.val);
                stack.push(pre);
                pre = pre.left;
            }
            //最后这里精彩
            pre = stack.poll();
            pre = pre.right;
        }
        return list;

    }
    
}
