import java.util.Arrays;

public class MaximumProductSubset {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, -2, 4, 3};
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums){
        int ans = 1;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            ans = ans * nums[i];
        }
        int largestMin = nums[0];
        for (int i = n - 1; i >= 0; i--){
            if(nums[i] < 0){
               largestMin = nums[i];
               break;
            }
        }
        if(ans < 0){
            ans = ans / largestMin;
        }

        return ans;
    }
}

