public class Solution127_copy {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1};
        int profit = new Solution127().maxProfit(nums);
        System.out.println(profit);
    }
    /**
     * 贪心思想
     * 题目是为找出max(prices[i] - minPrice)的金额
     * 如果当天为最低金额，则记录最低金额 如果不是则计算是否是最高收益
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];

            }else{
                if(prices[i] - minPrice > profit){
                    profit = prices[i] - minPrice;
                }
            }
        }
        return profit;
    }
}
