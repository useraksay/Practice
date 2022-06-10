package dp;

public class Tiling2 {
    public static void main(String[] args) {
        int m = 5;
        int n = 9;
        System.out.println(solveByRecursion(m, n));
        System.out.println(solveByDP(m, n));
    }

    private static int solveByRecursion(int m, int n){
        if(n < m) return 1;
        return solveByRecursion(m, n - 1) + solveByRecursion(m, n - m);
    }

    private static int solveByDP(int m, int n){
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++){
            if(i < m){
               dp[i] = 1;
            }else if(i == m){
               dp[i] = 2;
            }else{
               dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }
}
