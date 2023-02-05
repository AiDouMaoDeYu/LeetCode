public class Solution141_Copy {
    public static void main(String[] args) {
        int[] arry = new int[]{1,2};
        ListNode listNode = new ListNode(arry);
        //listNode.last.next = listNode;
        System.out.println(new Solution141_Copy().hasCycle(listNode));
        
       }
    
        /**
         * 快慢指针
         * @param head
         * @return
         */
        public boolean hasCycle(ListNode head) {
            if(head == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow != fast){
                //注意空指针处理
                if(fast == null || fast.next == null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    
}
