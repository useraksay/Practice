public class TrappingRainWater {
    public static void main(String[] args) {

    }
    /*
    * can be solved using monotonic decreasing stack
    * */
    private static int trap(int[] height){
        int n = height.length;
        int ans = 0;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++){
            if(height[i] > prefixMax[i - 1]){
                prefixMax[i] = height[i];
            }else{
                prefixMax[i] = prefixMax[i - 1];
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(height[i] > suffixMax[i + 1]){
                suffixMax[i] = height[i];
            }else{
                suffixMax[i] = suffixMax[i + 1];
            }
        }

        for(int i = 0; i < n; i++){
            ans = ans + Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return ans;
    }

    private static int trapTwoPtrSolution(int[] height){
        int ans = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int min = -1;
        while(left < right){
            if(height[left] <= height[right]){
               min = height[left];
               left++;
               while (height[left] < min){
                   ans = ans + min - height[left];
                   left++;
               }
            }else{
               min = height[right];
               right--;
               while (height[right] < min){
                    ans = ans + min - height[right];
                    right--;
               }
            }
        }
        return ans;
    }
}
