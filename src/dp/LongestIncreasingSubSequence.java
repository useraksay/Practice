package dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 8, 4, 5, 7, 2};
//        System.out.println(solveLIS(arr));
        System.out.println(solveLISByBS(arr));
//        System.out.println(solveLISByRecursion(0, - 1, arr, arr.length));
    }



    private static int solveLISByRecursion(int curr, int prev, int[] arr, int n){
        if(curr == n) {
            return 0;
        }

        //take the current element if it is greater than the previous element.
        int take = 0;
        if(prev == -1 || arr[curr] > arr[prev]){
            take = 1 + solveLISByRecursion(curr + 1, curr, arr, n);
        }

        //do not take the current element.
        int donotTake = 0 + solveLISByRecursion(curr + 1, prev, arr, n);

        return Math.max(take, donotTake);
    }

    private static int solveLIS(int[] arr){
        int ans = 1;
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


    private static int solveLISByBS(int[] arr){
        int size = arr.length;
        int[] tempArr = new int[size];
        int len; // always points empty slot

        tempArr[0] = arr[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] < tempArr[0])
                // new smallest value
                tempArr[0] = arr[i];

            else if (arr[i] > tempArr[len - 1])
                // A[i] wants to extend largest subsequence
                tempArr[len++] = arr[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tempArr
                tempArr[binarySearch(tempArr, -1, len - 1, arr[i])] = arr[i];
        }

        return len;
    }


    private static int binarySearch(int arr[], int l, int r, int key){
        int lo = 0, hi = arr.length - 1, res = 0;

        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }
}
