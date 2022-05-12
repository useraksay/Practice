public class IncreasingArrayCSES {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 1, 7};
        System.out.println(solve(arr));
    }

    public static int solve(int[] nums){
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++){
            if(nums[i] > nums[i + 1]){
                ans += Math.abs(nums[i] - nums[i + 1]);
                nums[i + 1] =  nums[i];
            }
        }

        return ans;
    }
}
