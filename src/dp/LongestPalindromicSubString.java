package dp;

public class LongestPalindromicSubString {
    public static void main(String[] args) {

    }


    //Dynamic Programming
    // S(l,r) is a palindrome
    // if S[l] == S[r] && S(l+1, r-1) is a palindrome
    // DP uses a 2d array to store (l+1, r-1) values, basically palindromes of length 2
    public String longestPalindromeSubStringDP(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                // for two length substrings - if substring is palindrome store true else false
                boolean isSameChar = s.charAt(i) == s.charAt(j);
                if(j - i < 3){
                    dp[i][j] = isSameChar;
                }else if(isSameChar && dp[i + 1][j - 1]){
                    //if dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j); store true
                    dp[i][j] = isSameChar;
                }

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }


    //expand around center approach TC:O(n2) SC:O(n)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
