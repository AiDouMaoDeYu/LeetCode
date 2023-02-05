public class Solution83{
    public static void main(String[] args) {
        int[] arry = new int[]{1,2,3,3};
        ListNode listNode = new ListNode(arry);
        listNode = null;
        new Solution83().deleteDuplicates(listNode);
        //listNode.printAllNode();
    }

    public ListNode deleteDuplicates(ListNode head) {
        //一定要记得处理非法值
        if(head == null){
            return null;
        }
        ListNode prev = head;
        while(prev.next != null){
            if(prev.val == prev.next.val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }
}