public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] args){
        if(args.length <1){
            return;
        }
        this.val = args[0];
        ListNode prev = this;
        for (int i = 1; i < args.length; i++) {
            ListNode listNode = new ListNode(args[i]);
            prev.next = listNode;
            prev = prev.next;
        }
    }

    void printAllNode(){
        ListNode prev = this;
        while(prev != null){
            System.out.print(prev.val);
            System.out.print(",");
            prev = prev.next;
        }
        System.out.println("");
    }
}
