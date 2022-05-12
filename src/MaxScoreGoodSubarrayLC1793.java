public class MaxScoreGoodSubarrayLC1793 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,7,4,5};
        int k = 3;
        int res = maximumScore(nums, k);
    }

    /*
    * Greedy two pointer approach
    * */
    private static int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int minVal = nums[k];
        int res = nums[k];
        int nSize = nums.length;

        while (left > 0 || right < nSize - 1) {
            int leftVal = (left > 0 ? nums[left - 1] : 0);
            int rightVal = (right < nSize - 1 ? nums[right + 1] : 0);

            // Go right
            if (leftVal < rightVal) {
                right++;
                minVal = Math.min(minVal, nums[right]);
            }
            // Go Left
            else {
                left--;
                minVal = Math.min(minVal, nums[left]);
            }
            res = Math.max(res, minVal * (right - left + 1));
        }
        return res;
    }
}


