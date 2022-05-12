package dp;

public class StairsDP {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    private static int solve(int stairs){
        int[] dp = new int[stairs + 1];
        if(stairs <= 2){
            return stairs;
        }else {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i < dp.length; i++) {
                 dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
