import java.util.Arrays;
import java.util.Stack;
/*
* https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/995249/Python-increasing-stack-explained
* */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
//        int[] heights = new int[]{3, 1, 5, 6, 2, 3};
        int[] heights = new int[]{3, 3, 3};
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
    }
    // maintain next smaller element towards left and right for every element
    // calculate the area using the formula
    // height[i] * (index(LS) - index(RS) + 1)
    private static int largestRectangleArea(int[] heights){
        int ans = 0;
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        Arrays.fill(leftSmaller, -1);
        Arrays.fill(rightSmaller, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
             while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                    rightSmaller[stack.peek()] = i;
                    if(heights[i] == heights[stack.peek()]){
                       leftSmaller[i] = stack.peek();
                    }
                    stack.pop();
             }
             if(!stack.isEmpty()){
                leftSmaller[i] = stack.peek();
             }
             stack.push(i);
        }
        printNums(leftSmaller);
        printNums(rightSmaller);

        for (int i = 0; i < n; i++){
             int rs = rightSmaller[i];
             int ls = leftSmaller[i];
             rs = rs == -1 ? n - 1 : rs;
             ls = ls == -1 ? 0 : ls;
             ans = Math.max(ans, (rs - ls - 1) * heights[i]);
        }
        return ans;
    }

    private static void printNums(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++){
            System.out.print(" " + nums[i] + " ");
        }
        System.out.print("]\n");
    }
}
