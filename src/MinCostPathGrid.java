public class MinCostPathGrid {
    public static void main(String[] args) {

    }

    private static int solve(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j =0; j < n; j++){
                 if(i == m - 1 && j == n - 1){
                   dp[i][j] = grid[i][j];
                 }else if(i == m - 1){
                   dp[i][j] = dp[i][j + 1] + grid[i][j];
                 }else if(j == n - 1){
                   dp[i][j] = dp[i + 1][j] + grid[i][j];
                 }else {
                   dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                 }
            }
        }
        return dp[0][0];
    }
}
