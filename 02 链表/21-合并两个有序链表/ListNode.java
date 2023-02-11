import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] nums) { 
        if(nums.length > 0){
            this.val = nums[0];
            ListNode prev = this;
            for (int i = 1; i < nums.length; i++) {
                ListNode node =  new ListNode(nums[i]);
                prev.next = node;
                prev = prev.next;
            }
        }

    }

    public Object[] printAll(){
        ListNode prev = this;
        ArrayList<Integer> arryList = new ArrayList<>();
        while(prev != null){
            arryList.add(prev.val);
            System.out.print(prev.val);
            System.out.print(",");
            prev = prev.next;
        }
        System.out.println();
        Object[] arrys= arryList.toArray();

        return arrys;
    }
    
}