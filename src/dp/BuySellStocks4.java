package dp;
/*
 * Given array of stock prices over a period.
 * Find the maximum profit that can be made by making buy and sell transactions.
 * You can perform infinite transactions.Each transaction attracts a transaction fee.
 * */
public class BuySellStocks4 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 1, 1, 9, 3, 5};
        int index = 0;
        int buy = 1;   //if buy == 1 stock is up for buying; if 0 stock is up for selling
        int fee = 2;
        System.out.println(solveBuyRecursion(index, buy, fee, prices));
    }

    private static int solveBuyRecursion(int i, int buy, int fee, int[] prices) {
        if(i == prices.length){
            return 0;
        }

//        stock is up for buying at i'th day, we have two options to buy and not buy.
        if(buy == 1){
//           if stock is bought on i'th day, profit reduces by -prices[i] and stock is up for selling.
//           hence, buy = 0.
//           no fee charged
            int profit1 = -prices[i] + solveBuyRecursion(i + 1, 0, fee, prices);
//           if stock is not bought, profit is 0 and stock is still up for buying. buy = 1.
//           no fee charged
            int profit2 = 0 + solveBuyRecursion(i + 1, 1, fee, prices);
            return Math.max(profit1, profit2);
        }else{  //stock is up for selling at i'th day, we have two options to sell and not sell.

//            if stock is sold at i'th day, profit exceeds by +prices[i] - fee.Since fee is charged
//            stock is up for buying again.
            int profit1 = prices[i] - fee + solveBuyRecursion(i + 1, 1, fee, prices);

//            if stock is not sold at i'th day. 0 profit is made.
//            stock is up of selling. no fee charged
            int profit2 = 0 + solveBuyRecursion(i + 1, 0, fee, prices);
            return Math.max(profit1, profit2);
        }

    }
}
