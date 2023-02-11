import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 前序遍历首先访问根结点然后遍历左子树，最后遍历右子树。在遍历左、右子树时，仍然先访问根结点，然后遍历左子树，最后遍历右子树。
 */
public class Solution144 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,4,3,2};
        TreeNode root = new TreeNode(array);
        List<Integer> list = new Solution144().preorderTraversal(root);
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
        
        TreeNode pre = root;
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        while(pre != null){
            list.add(pre.val);
            TreeNode left = pre.left;
            TreeNode right = pre.right;
            if(left != null){
                pre = left;
                if(right != null){
                    stack.push(right);
                }
            }else if(right != null){
                pre = right;
            }else if(stack.isEmpty()){
                pre = null;
            }else{
                pre = stack.pop();
            }
        } 
        return list;
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_recursion(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        recursion(root, list);
        return list;

    }

    void recursion(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        recursion(root.left, list);
        recursion(root.right, list);
    }

    
}
