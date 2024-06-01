import java.util.Arrays;

/*
 * Two pointers, prefix sum, binary search
 * Two pointers is applied below.
 *
 * */
public class LeetCode1838 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        int k = 5;
        int res = maxFreq(arr, k);
        System.out.println(res);
    }

    private static int maxFreq(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        int sum = 0;
        Arrays.sort(nums);

        int i = 0, j = 0;

        while(i < n && j < n){
            sum += nums[j];
            while ((j - i + 1) * nums[j] - sum > k){
                sum -= nums[i++];  //main logic
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}
