
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int arry[] = new Solution1().twoSum(nums,target);
        for (int i : arry) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    public int[] twoSum(int[] nums,int target){
        /*增加条件判断 保持代码健壮性 */
        if(nums.length < 2){
            return new int[0];
        }



        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    int[] arry = new int[2];
                    arry[0] = i;
                    arry[1] = j;
                    return arry;
                }
            }
        }
        return new int[0];
    }
}
