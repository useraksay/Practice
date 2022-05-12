public class MaxSumSubArray {
    public static void main(String[] args) {
            int[] arr = new int[]{1, 2, -3, -5, 100, 2};
            System.out.println(solve(arr));
    }

    public static int solve(int[] arr){
        int n = arr.length;
        int max = 0;
        int curr_sum = 0;

        for (int i = 0; i < n; i++){
             curr_sum = curr_sum + arr[i];

             if(curr_sum > max){
                max = curr_sum;
             }

             if(curr_sum < 0){
                curr_sum = 0;
             }
        }
        return max;
    }
}
