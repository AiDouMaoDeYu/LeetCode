public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int num = new Solution().removeElement(nums,val);
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println(num);
    }

    public int removeElement(int[] nums,int val){
        if(nums.length == 0){
            return 0;
        }
        int slow = 0;
        int fast =0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
