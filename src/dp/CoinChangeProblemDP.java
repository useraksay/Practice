package dp;

public class CoinChangeProblemDP {
    public static void main(String[] args) {
        int amt = 10;
        int[] coins = new int[]{2, 3, 5, 6};
        System.out.println(solve(coins, amt));
    }

    private static int solve(int[] coins, int amt){
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++){
             for (int j = coins[i]; j < dp.length; j++){
                  dp[j] = dp[j] + dp[j - coins[i]];
             }
        }
        return dp[dp.length - 1];
    }
}