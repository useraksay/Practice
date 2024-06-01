package dp;
/*
* Given array of stock prices over a period.
* Find the maximum profit that can be made by making buy and sell transactions.
* You can perform at most 2 transactions.
* A transaction is said to be completed if a stock is bought and sold.
* */
public class BuySellStocks3 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 1, 1, 9, 3, 5};
        int index = 0;
        int buy = 1;   //if buy == 1 stock is up for buying; if 0 stock is up for selling
        int k = 2;
        System.out.println(solveBuyRecursion(index, buy, k, prices));
    }

    private static int solveBuyRecursion(int i, int buy, int k, int[] prices) {
        if(i == prices.length || k == 0){
            return 0;
        }

//        stock is up for buying at i'th day, we have two options to buy and not buy.
        if(buy == 1){
//           if stock is bought on i'th day, profit reduces by -prices[i] and stock is up for selling.
//           hence, buy = 0.
           int profit1 = -prices[i] + solveBuyRecursion(i + 1, 0, k, prices);
//           if stock is not bought, profit is 0 and stock is still up for buying. buy = 1.
           int profit2 = 0 + solveBuyRecursion(i + 1, 1, k, prices);
           return Math.max(profit1, profit2);
        }else{  //stock is up for selling at i'th day, we have two options to sell and not sell.

//            if stock is sold at i'th day, profit exceeds by +prices[i].
//            stock is up for buying again.
//            transaction reduces by 1, since stock is sold.
            int profit1 = prices[i] + solveBuyRecursion(i + 1, 1, k - 1, prices);

//            if stock is not sold at i'th day. 0 profit is made.
//            stock is up of selling.
//            transaction remains same.
            int profit2 = 0 + solveBuyRecursion(i + 1, 0, k, prices);
            return Math.max(profit1, profit2);
        }

    }


}
