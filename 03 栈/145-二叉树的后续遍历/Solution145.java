import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点。
 */
public class Solution145 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,4,3,2};
        TreeNode root = new TreeNode(array);
        List<Integer> list = new Solution145().postorderTraversal(root);
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(",");
        }
        System.out.println();
    }

    //Leetcode方法 使用链表反转实现倒叙链表插入
    public void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.val);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

    /**
     * 莫里斯算法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        TreeNode x = root;
        TreeNode pre;
        //如果左右节点都为空遍历结束
        while(x != null){
            //获取左子树
            pre = x.left;
            //左子树为空
            if(pre == null){
                x = x.right;
            }else{
                //右指针不能指向自己&&找出前驱节点
                while(pre.right != x && pre.right != null){
                    pre = pre.right;
                }
                //如果前驱指针右节点指向自己
                if(pre.right == x){
                    pre.right = null;
                    //从左子树到前驱节点倒叙插入
                    pre = x.left;
                    int n = list.size();
                    while(pre != null){
                        list.add(n, pre.val);
                        pre = pre.right;
                    }
                    x = x.right;
                }else{
                    pre.right = x;
                    x = x.left;
                }
            }
        }
        int n = list.size();
        pre = root;
        while(pre != null){
            list.add(n, pre.val);
            pre = pre.right;
        }
        return list;
    }



    public List<Integer> postorderTraversal_recursion(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        recursion(root, list);
        return list;

    }

    void recursion(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        recursion(root.left, list);
        recursion(root.right, list);
        list.add(root.val);
    }

    
}
