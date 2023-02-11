public class Solution21 {
   public static void main(String[] args) {
    int[] arry1 = new int[]{1,2,4};
    int[] arry2 = new int[]{1,3,4};
    //ListNode list1 = new ListNode(arry1);
    //ListNode list2 = new ListNode(arry2);
    //ListNode list3 = new Solution21().mergeTwoLists_recursion(list1,list2);
    //list3.printAll();

   }

   /**
    * 迭代方法
    * @param list1
    * @param list2
    * @return
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //怎么判断是否包含节点
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1); 
        ListNode prev = head;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                prev.next = list2;
                list2 = list2.next;
            }else{
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;

            if(list1 == null){
                prev.next = list2;
            }
            if(list2 == null){
                prev.next = list1;
            }
        }
        return head.next;

    }

    public ListNode mergeTwoLists_recursion(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode heaNode = new ListNode(-1);
        ListNode prev = heaNode;
        recursion(list1,list2,prev);
        return heaNode.next;
    }

    /**
     * 递归方法
     * @param list1
     * @param list2
     * @param prev
     */
    public void recursion(ListNode list1, ListNode list2,ListNode prev){
        
        if(list1.val > list2.val){
            prev.next = list2;
            list2  = list2.next;
        }else{
            prev.next = list1;
            list1  = list1.next;
        }
        prev = prev.next;
        if(list1 != null && list2 != null){
            recursion(list1,list2,prev);
        }
        if(list1 == null){
            prev.next = list2;
        }
        if(list2 == null){
            prev.next = list1;
        } 

    }
}
