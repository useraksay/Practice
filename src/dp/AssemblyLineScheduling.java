package dp;

import static java.lang.Math.min;

public class AssemblyLineScheduling {
    public static void main(String[] args) {

    }

    private int solveByDP(int n, int[] entry, int[] exit, int[][] processing, int[][] transfer){
          int[][] dp = new int[2][n + 1];

          //Base case
          dp[0][0] = entry[0] + processing[0][0];
          dp[1][0] = entry[1] + processing[1][0];

        for(int i = 1; i < n; i++) {
            //for being on station i of assembly line 1
            dp[0][i] = min(dp[0][i - 1], dp[1][i - 1] + transfer[1][i - 1]) + processing[0][i];

            //for being on station i of assembly line 2
            dp[1][i] = min(dp[1][i - 1], dp[0][i - 1] + transfer[0][i - 1]) + processing[1][i];
        }

        //exiting from the last station
        dp[0][n] = dp[0][n - 1] + exit[0];
        dp[1][n] = dp[1][n - 1] + exit[1];

        return min(dp[0][n], dp[1][n]);
    }
}
