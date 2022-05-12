import java.util.Arrays;

public class MaxSumAfterKNegotiations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -3, 4, 5};
        int k = 5;
        System.out.println(solve(nums, k));
    }

    public static int solve(int[] nums, int k){
        int ans = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
             if(nums[i] > 0){
                if(k % 2 == 1){
                    nums[i] = -nums[i];
                    break;
                }
             }else {
                nums[i] = -nums[i];
                k--;
             }
        }

        for (int i = 0; i < nums.length; i++){
            ans = ans + nums[i];
        }

        return ans;
    }
}
