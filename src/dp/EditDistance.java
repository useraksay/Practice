package dp;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "ram";
        String s2 = "iam";

        System.out.println(solveByRecursion(s1, s2, s1.length(), s2.length()));
        System.out.println(solveByDP(s1, s2, s1.length(), s2.length()));
    }

    private static int solveByRecursion(String a, String b, int m, int n){
        if(m == 0){
            return n;
        }

        if(n == 0){
            return m;
        }

        if(a.charAt(m - 1) == b.charAt(n - 1)){
            return solveByRecursion(a, b, m - 1, n - 1);
        }
        //recursively solve for insert, remove & replace and take the minimum
        return 1 + Math.min(solveByRecursion(a, b, m, n - 1), Math.min(solveByRecursion(a, b, m - 1, n), solveByRecursion(a, b, m - 1, n - 1)));
    }

    private static int solveByDP(String a, String b, int m, int n){
        int dp[][] = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
           for(int j = 0; j <= n; j++) {
               if(i == 0) {
                  dp[i][j] = j;
               }else if(j == 0){
                  dp[i][j] = i;
               }else if(a.charAt(i - 1) == b.charAt(j - 1)){
                  dp[i][j] = dp[i - 1][j - 1];
               }else{
                  dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
               }
           }
        }
        return dp[m][n];
    }
}
