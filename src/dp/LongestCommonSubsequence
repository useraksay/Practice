package dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a = "aaaaaa";
        String b = "ababab";
        System.out.println(LCSRecursion(a.toCharArray(), b.toCharArray(), 0, 0));
        System.out.println(LCSdp(a, b));
    }

    private static int LCSdp(String a, String b) {
        int ans = 0;
        int m = a.length();
        int n = b.length();
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if(i == m || j == n){
                   dp[i][j] = 0;
                }else if(a1[i] == b1[j]){
                   dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                   dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        ans = dp[0][0];
        return ans;
    }

    private static int LCSRecursion(char[] a, char[] b, int i, int j) {
        if(i == a.length || j == b.length){
            return 0;
        }

        if(a[i] == b[j]){
            return  1 + LCSRecursion(a, b, i + 1, j + 1);
        }

        return Math.max(LCSRecursion(a, b, i + 1, j), LCSRecursion(a, b, i, j + 1));

    }
}
