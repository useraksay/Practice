/*
* leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/967951/Python-Two-pointers-approach-explained
* */
public class RemoveDuplicatesFromSortedArrayLC80 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(removeDuplicatesInPlace(nums, k));
    }

    /*private static int removeDuplicates(int[] nums, int k) {
            int ans = 2;
            int n = nums.length;
            if(n == 2) return ans;

            int i = 0, j = i + k, skips = 0;

            while (j < n){
                if(nums[i] != nums[j]){
                   i = j;
                   j = i + k;
                   ans = j - skips;
                }else {
                   j++;
                   skips++;
                }
            }

            return ans - 1;
    }*/

    private static int removeDuplicatesInPlace(int[] nums, int k) {
        int n = nums.length;
        int index = k;

        for(int i = k; i < n; i++){
            if(nums[i] == nums[index - k]){
               // do nothing
            }else{
                //nums[i] = nums[];
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
