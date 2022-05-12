public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        int[] A = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };
        System.out.println(runCircularKadane(A));
    }

    private static int kadane(int[] A) {
        // stores the sum of maximum subarray found so far
        int max_so_far = 0;
        // stores the maximum sum of subarray ending at the current position
        int max_ending_here = 0;
        // traverse the given array
        for (int value : A) {
            // update the maximum sum of subarray "ending" at index `i` (by adding the
            // current element to maximum sum ending at previous index `i-1`)
            max_ending_here = max_ending_here + value;
            // if the maximum sum is negative, set it to 0 (which represents
            // an empty subarray)
            max_ending_here = Integer.max(max_ending_here, 0);
            // update result if the current subarray sum is found to be greater
            max_so_far = Integer.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static int runCircularKadane(int[] A) {
        int n = A.length;
        // empty array has sum of 0
        if (A.length == 0) {
            return 0;
        }
        // find the maximum element present in a given array
        int max = Integer.MIN_VALUE;
        int totalSum = 0;
        for (int i = 0; i < n; i++){
             totalSum += A[i];
             max = Math.max(A[i], max);
        }
        // if the array contains all negative values, return the maximum element
        if (max < 0) {
            return max;
        }
        // negate all the array elements
        for (int i = 0; i < n; i++){
             A[i] = -A[i];
        }
        // run Kadane’s algorithm on the modified array
        int neg_max_sum = kadane(A);
        // restore the array
        for (int i = 0; i < n; i++){
             A[i] = -A[i];
        }
        /* Return the maximum of the following:
            1. Sum returned by Kadane’s algorithm on the original array.
            2. Sum returned by Kadane’s algorithm on the modified array +
               the sum of all the array elements.
        */
        return Math.max(kadane(A), totalSum + neg_max_sum);
    }
}
