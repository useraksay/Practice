package dp;

public class CodeDecode {
    public static void main(String[] args) {
        System.out.println(decode("875361268549483279131"));
    }

    public static int decode(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        if(n == 0) return 0;
        if(arr[0] == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;  // if no characters
        dp[1] = 1;  // if single character is present

        for (int i = 2; i < dp.length; i++){
            if(arr[i - 1] >= '1' && arr[i - 1] <= '9'){
               dp[i] = dp[i - 1];
            }
            if(arr[i - 2] == '1'){
               dp[i] = dp[i] + dp[i - 2];
            }else if(arr[i - 2] == '2' && arr[i - 1] >= '0' && arr[i - 1] <= '6'){
               dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
