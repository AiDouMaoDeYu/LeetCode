import java.util.HashMap;
import java.util.Map;

public class Solution_Copy {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int arry[] = new Solution().twoSum(nums,target);
        for (int i : arry) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    /**
     * 利用HashMap降低时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        /*增加条件判断 保持代码健壮性 */
        if(nums.length < 2){
            return new int[0];
        }
        
        Map<Integer,Integer> valueToIndex = new HashMap<Integer,Integer>();

        /* 1.利用HashMap降低时间复杂度
        *  2.从两边一起找可以节约 1倍时间
        */
        for (int i = 0,j = nums.length - 1; i <= j; i++,j--) {
            if(valueToIndex.containsKey(target - nums[i])){
                return new int[]{i,valueToIndex.get(target - nums[i])};
            }
            valueToIndex.put(nums[i], i);
            if(valueToIndex.containsKey(target - nums[j])){
                return new int[]{j,valueToIndex.get(target - nums[j])};
            }
            valueToIndex.put(nums[j], j);

        }
        return new int[0];
    }

}

