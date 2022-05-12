package dp;

public class LetsParty {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    /*
     f(n) = f(n - 1) + (n - 1)*f(n - 2);
   */
    private static int solve(int A) {
        long[] dp = new long[A + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(A > 1){
            for(int i = 2; i < dp.length; i++){
                dp[i] = (dp[i - 1] + (i - 1)*dp[i - 2]) % 10003;
            }
        }

        return (int) dp[dp.length - 1] % 10003;
    }
}
