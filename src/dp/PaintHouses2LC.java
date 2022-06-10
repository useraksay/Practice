package dp;

public class PaintHouses2LC {
    public static void main(String[] args) {

    }

    private static int solve(int[][] arr){
        int houses = arr.length;
        int colors = arr[0].length;
        int[][] dp = new int[houses][colors];

        for (int j = 0; j < colors; j++){
            dp[0][j] = arr[0][j];
        }

        for (int i = 1; i < houses; i++){
            for (int j = 0; j < colors; j++){
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < colors; k++){
                    if(k != j){
                       min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < colors; k++){
            ans = Math.min(ans, dp[houses - 1][k]);
        }

        return ans;
    }
}
