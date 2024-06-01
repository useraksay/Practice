import java.util.Arrays;
import java.util.HashSet;
/*
* https://leetcode.com/problems/number-of-squareful-arrays/discuss/1483566/Java-1-ms-backtracking-and-memoization-with-detailed-explanation
* */
public class SquareFullArrays {
    public static int count = 0;
    public static void main(String[] args) {
//        int[] nums = new int[]{428, 56, 88, 12};
//        int[] nums = new int[]{2, 2, 2, 2};
//        int[] nums = new int[]{1, 8, 17};
        int[] nums = new int[]{36229, 1020, 69, 127, 162, 127};
//        int[] nums = new int[]{28059, 841, 315, 85, 84, 37};
        squareFullArrays(nums, 0);
        System.out.println(count);

    }

    public static void squareFullArrays(int[] nums, int idx){
            if(idx == nums.length){
               System.out.println("nums = " + Arrays.toString(nums) + ", idx = " + idx);
               if(isSquareFull(nums)){
//                  System.out.println("nums = " + Arrays.toString(nums) + ", idx = " + idx);
                  count++;
               }
               return;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = idx; i < nums.length; i++){
                 if(!set.add(nums[i])){
                     continue;
                 }

                 swap(nums, idx, i);
                 //permute iff idx == 0 or nums[idx - 1] + nums[idx] is a square
                if(idx == 0 || isSquare(nums[idx - 1] + nums[idx])) {
                    squareFullArrays(nums, idx + 1);
                }
                 swap(nums, idx, i);
            }
    }

    private static void swap(int[] nums, int i, int j) {
        if(i != j){
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
        }
//        System.out.println("nums = " + Arrays.toString(nums) + ", i = " + i + ", j = " + j);
    }

    private static boolean isSquareFull(int[] nums){
        int n = nums.length;
        if (n == 1) return false;

        for (int i = 1; i < n; i++){
             int sq = nums[i - 1] + nums[i];
             double sqrt = Math.round(Math.sqrt(sq));
             if((int)(sqrt*sqrt) != sq){
                 return false;
             }
        }
        return true;
    }

    private static boolean isSquare(int x){
        return (Double)Math.sqrt(x) == (int)Math.sqrt(x);
    }

}