
public class TreeNode {
         Integer val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(Integer val) { this.val = val; }
         TreeNode(Integer val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;  
         } 

         /*
          * 怎么用数组创建二叉树？
          */
         TreeNode(Integer[] array) {
            this.val = array[0];
            this.left = new TreeNode(array[1],new TreeNode(array[3]),null);
            this.right = new TreeNode(array[2],null,null);
        }
}
