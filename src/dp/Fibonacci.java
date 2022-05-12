package dp;

import java.time.Duration;
import java.time.Instant;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 45;
        Instant startRec = Instant.now();
        System.out.println(fib(n));
        System.out.println("Recursion time: " + Duration.between(startRec, Instant.now()));
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        Instant startDP = Instant.now();
        System.out.println(dp(n, dp));
        System.out.println("DP time: " + Duration.between(startDP, Instant.now()));
    }

    public static int fib(int n){
        if(n == 0 || n == 1) return n;
        int fib1 =  fib(n - 1);
        int fib2 = fib(n - 2);
        return fib1 + fib2;
    }

    public static int dp(int n, int[] dp){
        if(n > 1){
            if(dp[n] != 0) return dp[n];
            int fib1 = dp(n - 1, dp);
            int fib2 = dp(n - 2, dp);
            int fibn = fib1 + fib2;
            dp[n] = fibn;
        }else{
            return dp[n];
        }
        return dp[n];
    }
}
