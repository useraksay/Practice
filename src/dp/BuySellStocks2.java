package dp;
/*
* Given array of stock prices over a period.
* Find the maximum profit that can be made by making buy and sell transactions.
* You can perform infinite transactions.
* */
public class BuySellStocks2 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 1, 1, 9, 3, 5};
        System.out.println(solve(prices));
    }

    private static int solve(int[] prices){
        int profit = 0;
        int buyIndx = 0, sellIndx = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] >= prices[i - 1]){
               sellIndx++;
            }else if (prices[i] < prices[i - 1]){
               profit = profit + prices[sellIndx] - prices[buyIndx];
               sellIndx = buyIndx = i;
            }
        }
        profit = profit + prices[sellIndx] - prices[buyIndx];
        return profit;
    }
}
