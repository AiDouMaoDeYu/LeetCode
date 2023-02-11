

public class Solution127 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1};
        int profit = new Solution127().maxProfit(nums);
        System.out.println(profit);
    }
    /**
     * 暴力算法，时间不通过
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0 ;
        int left = prices[0];
        
        for (int i = 0; i < len - 1; i++) {
            if(prices[i] <= left){            
                left = prices[i];
            }else{
                continue;
            }
            for (int j = len - 1;  j > i; j--) {          
                if(prices[j] < prices[i] ){
                    continue;
                }     
                if(prices[j] - prices[i] > profit){
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
}
