public class Solution_copy {
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int num = new Solution_copy().removeDuplicates(nums);
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println(num);
    }

    /**
     * 1.想到了双指针但没有想到使用快慢指针，因为存在顺序 所以可以用相邻的数进行比较
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[fast - 1]){
                if(fast - slow > 0){                    
                    nums[slow] = nums[fast];
                }
                slow++;
            }    
            fast++;       
        }
        return slow;


    }
}
