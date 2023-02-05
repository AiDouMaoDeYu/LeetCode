import java.util.HashSet;
import java.util.Set;

public class Solution141 {
   public static void main(String[] args) {
    int[] arry = new int[]{1,2,3,3};
    ListNode listNode = new ListNode(arry);
    listNode.last.next = listNode;
    System.out.println(new Solution141().hasCycle(listNode));
    
   }

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode prev = head;
        Set<String> addressSet = new HashSet<String>();
        while(prev != null){
            if(addressSet.contains(prev.toString())){
                return true;
            }
            addressSet.add(prev.toString());
            prev = prev.next;
        }
        return false;
    }
}
