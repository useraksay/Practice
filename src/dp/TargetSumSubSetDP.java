package dp;

public class TargetSumSubSetDP {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 7, 1, 3};
        int target = 10;
        System.out.println(targetSumDP(arr, target));
    }

    private static boolean targetSumDP(int[] arr, int target){
        int m = arr.length;
        int n = target;
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                   dp[i][j] = true;
                }else if(i == 0){
                   dp[i][j] = false;
                }else if(j == 0){
                   dp[i][j] = true;
                }else {
                   if(dp[i - 1][j] == true){
                       dp[i][i] = true;
                   }else{
                       int val = arr[i - 1];
                       if(j >= val){
                          if(dp[i - 1][j - val] = true){
                             dp[i][i] = true;
                          }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
