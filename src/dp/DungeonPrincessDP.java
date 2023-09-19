package dp;

public class DungeonPrincessDP {
    public static void main(String[] args) {

    }

    private int calculateMinimumHP(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1, 1 - a[m - 1][n - 1]);

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - a[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - a[m - 1][j]);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int toRight = Math.max(1, dp[i][j + 1] - a[i][j]);
                int toBottom = Math.max(1, dp[i + 1][j] - a[i][j]);
                dp[i][j] = Math.min(toRight, toBottom);
            }
        }
        return dp[0][0];
    }
}
