import java.util.Arrays;

public class ClimbingStairswithMinimumMoves {
    public static void main(String[] args) {
        int[] jumps = new int[]{};
        int n = jumps.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;
    }

    private static int solve(int[] jumps, int[] dp){
        for (int i = jumps.length - 1; i >= 0; i--){
            if(jumps[i] > 0){
                int min = Integer.MAX_VALUE;
                for (int j = jumps[i]; j > 0; j--){
                    if(i + j < dp.length){
                       min = Math.min(min, dp[i + j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
