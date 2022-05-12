/*
* Leetcode 698
*
* */

public class PartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;

        int sum = 0;
        System.out.print("[");
        for (int i = 0; i < nums.length; i++){
             System.out.print(" " + nums[i] + " ");
             sum += nums[i];
        }
        System.out.print("]\n");
        if(sum % k == 0){
           int target = sum / k;
           solve(nums, k, 0, target, 0);
        }
    }

    public static boolean solve(int[] nums, int k, int idx, int target, int sum){
        if (k == 0){
            return true;
        }

        if(idx == nums.length){
           if(sum == target){
              printNums(nums);
              return solve(nums, k - 1, 0, target, 0);
           }
           return false;
        }

        if(sum == target){
           printNums(nums);
           return solve(nums,k - 1,0, target,0);
        }

        if(sum > target){
           return false;
        }

        if(nums[idx] != -1){
           int num = nums[idx];
           nums[idx] = -1;
           sum = sum + num;
           if(solve(nums, k,idx + 1, target, sum)){
              return true;
           }
            //Else Backtrack
           nums[idx] = num;
           sum = sum - num;
           return solve(nums, k,idx + 1, target, sum);
        }
        return solve(nums, k, idx + 1, target, sum);
    }

    private static void printNums(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++){
             System.out.print(" " + nums[i] + " ");
        }
        System.out.print("]\n");
    }

}
