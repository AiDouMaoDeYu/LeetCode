import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。若二叉树为空则结束返回，否则：
（1）中序遍历左子树
（2）访问根结点
（3）中序遍历右子树
 */
public class Solution94 {
    public static void main(String[] args) {
        int[] arry = new int[]{1,2,2,2};

        
    }

    /*
    Morris遍历
     * 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。

如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。

a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点（在这里输出，这是与中序遍历唯一一点不同）。当前节点更新为当前节点的左孩子。

b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。

重复以上1、2直到当前节点为空。
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        recursion(root,list);
        return list;
    }

    void recursion(TreeNode root,List<Integer> list){
        
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if(leftNode != null){
            recursion(leftNode,list);
            //list.add(leftNode.val);
        }
        list.add(root.val);
        if(rightNode != null){
            recursion(rightNode,list);
            //list.add(rightNode.val);
        }
    }
}
