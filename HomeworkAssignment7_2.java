public class HomeworkAssignment7_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {100, 2, 3, 1, 5, 6, 89, 8, 9,10,11,12,13,140};
        int[] test1 = {3, 1, 5, 2, 4};
        int[] test2 = {3, 5, 9, 1, 4, 8};
        System.out.println(sol.getMaxProfit(arr));
        System.out.println(sol.getMaxProfit(test1));
        System.out.println(sol.getMaxProfit(test2));
    }
}

class Solution {
    /**
     * FUNCTION SIGNATURE: int getMaxProfit(int[] prices)
     * PURPOSE: this function takes in an integer array (int[] prices) consisting of all prices,
     * in chronological order, and recommends the maximum profit an investor can make by placing
     * AS MANY buy-sell orders as you may in the time slice represented by the input array.
     * PARAMETER:
     *     int[] prices, an array of integer prices
     * RETURN VALUE:
     *     Integer value, maximum possible profit from AS MANY buy-sell orders as you may.
     */
    public int getMaxProfit(int[] prices) {
        int biggest;
        int lowest = prices[0];
        int singleTrade;
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] <= lowest){
                lowest = prices[i];
            } else {
                biggest = prices[i];
                singleTrade = biggest - lowest;
                profit += singleTrade;
                lowest = prices[i];
            }
        }
        return profit;
    }
}