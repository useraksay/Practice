import java.util.Stack;
/*
* https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
* */
public class MaxWidthRampLC962 {
    public static void main(String[] args) {
        int[] width = new int[]{6, 0, 8, 2, 1, 5};
        int ans = maxWidthRamp(width);
        System.out.println(ans);
    }

    private static int maxWidthRamp(int[] nums){
        int ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        //maintain a decreasing monotonic stack
        for (int i = 0; i < n; i++){
            if(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                continue;
            }
            stack.push(i);
        }

        //check from the right most element of the array whether
        //it is greater than or equal to the peek and is present to its right
        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
        }

        return ans;
    }

    private static int maxWidthRampTwoPtr(int[] nums){
        int ans = 0;
        int n = nums.length;
        int[] prefixMax = new int[n];
        prefixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--){
             prefixMax[i] = Math.max(nums[i], prefixMax[i + 1]);
        }
        int i = 0, j = 0;
        while(j < n){
            while (i < n && nums[i] < prefixMax[j]){
                i++; //move left pointer
            }
            ans = Math.max(ans, j - i);
            j++;  //move right pointer
        }
        return ans;
    }
}
