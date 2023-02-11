
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int num = new Solution().removeDuplicates(nums);
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println("");
        System.out.println(num);
    }

    /**
     * 思路 1.移动数组标志
     * 如果相同 数组匹配标志往后移动一位，新数组长度不变
     * 如果不同 新数组长度+1并交换数值，移动数组标志改为当前数据标标志
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int newLength = 1;
        int i = 1;
        while(i < nums.length){
            if(nums[index] != nums[i]){
                newLength++;
                nums[index + 1] = nums[i];
                index = newLength - 1;
            }else{
                i++;
            }
        }
        return newLength;


    }
}
