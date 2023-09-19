package dp;

public class UniquePathsInGrid {
    public static void main(String[] args) {

    }


    public static int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 1) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0 && i != 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
