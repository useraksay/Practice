package dp;

public class MaxSumWithoutAdjElements {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}};
        System.out.println(adjacent(arr));
    }

    private static int adjacent(int[][] A) {
       //convert arr into 1d matrix
       int n = A[0].length;
       int[] arr = new int[n];
       for (int i = 0; i < n; i++){
           arr[i] = Math.max(A[0][i], A[1][i]);
       }

       int[] dp = new int[n];
       dp[0] = arr[0];
       if(n == 1) return dp[0];
       dp[1] = Math.max(arr[0], arr[1]);

       for (int i = 2; i < n; i++){
            int includeCurrEle = arr[i] + dp[i - 2];
            int prevMax = dp[i - 1];
            dp[i] = Math.max(includeCurrEle, prevMax);
       }

       return dp[n - 1];
    }
}
