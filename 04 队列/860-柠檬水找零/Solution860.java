import java.util.HashMap;
import java.util.Map;

public class Solution860 {
    
    public static void main(String[] args) {
        int[] bills = new int[]{5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20};
        boolean b = new Solution860().lemonadeChange(bills);
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0){
            return true;
        }
        //看完题解 我的map有啥用 直接int 定义不香吗？？？？ 我是傻子
        Map<Integer,Integer> moneyMap = new HashMap<>(){{
            put(5, 0);
            put(10, 0);
        }};
        for (int i = 0; i < bills.length; i++) {
            int sum5 = moneyMap.get(5);
            int sum10 = moneyMap.get(10);
            if(bills[i] == 5){
                moneyMap.put(5, sum5+=5);
            }
            if(bills[i] == 10){
                if(bills[i] - 5 > sum5){
                    return false;
                }
                moneyMap.put(5, sum5-=5);
                moneyMap.put(10, sum10+=10);
            }
            if(bills[i] == 20){
                if(sum10 > 0 && sum5 > 0){
                    moneyMap.put(5, sum5-=5);
                    moneyMap.put(10, sum10-=10);
                }else if(sum5 >= 15){
                    moneyMap.put(5, sum5-=15);
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}
