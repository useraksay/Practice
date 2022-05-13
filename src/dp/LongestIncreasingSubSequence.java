package dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 8, 4, 5, 7, 2};
        System.out.println(solveLIS(arr));
    }

    private static int solveLIS(int[] arr){
        int ans = 0;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;

        for (int i = 1; i < n; i++){
             for (int j = 0; j < i; j++){
                 if(arr[i] >= arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                 }
             }
             ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
