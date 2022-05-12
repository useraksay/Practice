package dp;

import java.util.Arrays;

public class MinNumOfSquares {
    public static void main(String[] args) {
        int ans1 = solveByRecursion(12, Integer.MAX_VALUE);
        int ans2 = solveByDP(467);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    private static int solveByRecursion(int num, int min){
        if(num == 0 || num == 1) return num;

        for(int i = 1; i <= Math.sqrt(num); i++){
            int ways = solveByRecursion(num - i * i, min) + 1;
            min = Math.min(min, ways);
        }
        return min;
    }

    private static int solveByDP(int num){
        int[] dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            for (int j = 1; j <= Math.sqrt(i); j++){
                 dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[dp.length - 1];
    }
}
