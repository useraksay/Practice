public class NextPermutation {
    /*
    * leetcode.com/problems/next-permutation/discuss/13867/C%2B%2B-from-Wikipedia
    * */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

    }

    public static void nextPermutation(int[] nums){
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = nums.length - 1;              // Start from the end
            while(nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
            swap(nums, i, j);                     // Switch i and j
        }
        reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
    }

    private static void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
