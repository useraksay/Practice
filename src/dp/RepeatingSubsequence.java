package dp;

public class RepeatingSubsequence {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(solveRecursively(s.length(), s.length(), s));
        System.out.println(solveByDP(s));
    }

    private static int solveRecursively(int i, int j, String a) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (a.charAt(i - 1) == a.charAt(j - 1) && i != j) {
            return solveRecursively(i - 1, j - 1, a) + 1;
        }

        return Math.max(solveRecursively(i - 1, j - 1, a), solveRecursively(i - 1, j - 1, a));
    }


    private static int solveByDP(String a) {
        int m = a.length();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                // if characters at index `i` and `j` matches
                // and the index are different
                if (a.charAt(i - 1) == a.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][m - 1];
    }
}
