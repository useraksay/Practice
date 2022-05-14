package dp;
/*
*You are given an array A of N integers and three integers B, C, and D.
*You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
* */
public class MaximumSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-21, 34, 3, 46, 8, -47, -47};
        int b = -13;
        int c = 10;
        int d = 9;
        System.out.println(solve(arr, b, c, d));
    }

    private static int solve(int[] arr, int b, int c, int d){
        int n = arr.length;
        int[] prefixmax1 = new int[n];
        int[] prefixmax2 = new int[n];
        int ans;

        prefixmax1[0] = arr[0] * b;
        for(int i = 1; i < n; i++){
            prefixmax1[i] = Math.max(prefixmax1[i - 1], arr[i] * b);
        }
        prefixmax2[0] = prefixmax1[0] + arr[0] * c;
        for(int j = 1; j < n; j++){
            prefixmax2[j] = Math.max(prefixmax2[j - 1], prefixmax1[j] + (arr[j] * c));
        }

        ans = prefixmax2[0] + arr[0] * d;
        for (int k = 1; k < n; k++){
             ans = Math.max(ans, prefixmax2[k] + (arr[k] * d));
        }
        return ans;
    }
}
